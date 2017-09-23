package io.github.andyswe.elva.data

/**
 * Created by andreas on 2017-09-08.
 */
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronization
import org.springframework.transaction.support.TransactionSynchronizationManager
import org.springframework.transaction.support.TransactionSynchronizationUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@RestController
class MeasurementController() {

    @Autowired lateinit var repo: MeasurementRepository


    @GetMapping("/latest")
    fun latestRecords() =
            repo.findAll(PageRequest(0, 5, Sort.Direction.DESC, "timestamp")).content

    @RequestMapping(value = "/")
    fun index(): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "graph"
        return mav
    }

    @RequestMapping(value = "data/{id}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun data(@PathVariable("id") id: String): ResponseEntity<InputStreamResource> {

        val renderer = Renderer()

        println("starting for ${id}")

        Thread({ getTheData(renderer) }).start()
        println("returning")
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(InputStreamResource(renderer.getRenderedStream()))
    }


    @Transactional(readOnly = true)
    fun getTheData(renderer: Renderer) {

        TransactionSynchronizationManager.setActualTransactionActive(true)
        TransactionSynchronizationManager.initSynchronization()


        println("requesting stream")
        val dataStream = repo.streamAll()

        println("got beginnign of stream")
        dataStream.forEach(renderer)
        println("got end of stream")
        renderer.close()
        dataStream.close()
        TransactionSynchronizationUtils.triggerAfterCompletion(TransactionSynchronization.STATUS_COMMITTED);


    }
}

