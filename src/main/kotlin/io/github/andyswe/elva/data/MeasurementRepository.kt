package io.github.andyswe.elva.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.QueryHints
import org.springframework.scheduling.annotation.Async
import java.util.*
import java.util.stream.Stream
import javax.persistence.QueryHint


/**
 * Created by andreas on 2017-09-08.
 */


interface MeasurementRepository : JpaRepository<Measurement, Date> {


    @QueryHints(QueryHint(name = "org.hibernate.fetchSize", value = "1"), QueryHint(name = "org.hibernate.readOnly", value = "true"))
    @Query(value = "select t from Measurement t")
    @Async
    fun streamAll(): Stream<Measurement>


}