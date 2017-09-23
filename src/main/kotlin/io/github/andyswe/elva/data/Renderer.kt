package io.github.andyswe.elva.data;


import org.apache.commons.collections4.queue.CircularFifoQueue
import org.apache.commons.lang.ArrayUtils
import org.apache.commons.math3.stat.StatUtils
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.text.SimpleDateFormat
import java.util.function.Consumer


public class Renderer : Consumer<Measurement> {

    private val dt = SimpleDateFormat("yyyy-MM-dd HH:mm")
    private val out = PipedOutputStream()
    private val ins = PipedInputStream(out)
    private val queue24 = CircularFifoQueue<Double>(1440)
    private val queue1 = CircularFifoQueue<Double>(60);
    private var previousWater: Int? = null


    fun Renderer() {
        out.write("Date, El, Wa, El24, El1".toByteArray())

    }

    override fun accept(record: Measurement) {

        synchronized(this) {
            if (previousWater == null) {
                previousWater = record.vaTotal

            }
            queue24.add(record.power.toDouble())
            queue1.add(record.power.toDouble())

            out.write(dt.format(record.timestamp).toByteArray())
            out.write(",".toByteArray())

            //out.write(record.power.toString().toByteArray())
            //out.write(",".toByteArray())

            val water = 100 * (record.vaTotal - previousWater!!)
            out.write(water.toString().toByteArray())
            out.write(",".toByteArray())


            if (queue24.isAtFullCapacity) {
                val values24: DoubleArray = ArrayUtils.toPrimitive(queue24.toTypedArray())
                val values1: DoubleArray = ArrayUtils.toPrimitive(queue1.toTypedArray())
                val movingAverage24 = StatUtils.mean(values24, 0, 1440)
                val movingAverage1 = StatUtils.mean(values1, 0, 60)

                out.write(movingAverage24.toString().toByteArray())

                out.write(",".toByteArray())
                out.write(movingAverage1.toString().toByteArray())
            } else {
                out.write(record.power.toString().toByteArray())
                out.write(",".toByteArray())
                out.write(record.power.toString().toByteArray())
            }

            out.write("\n".toByteArray())



            previousWater = record.vaTotal
            // println("r st")

            // val mapper = ObjectMapper(
            //val out2 = ByteArrayOutputStream()
            //mapper.writeValue(out2, record)
            //println(String(out2.toByteArray()))

        }

    }

    fun close() {
        synchronized(this) {
            println("closing")
            out.close()
        }
    }

    fun getRenderedStream(): PipedInputStream {
        return ins
    }


}
