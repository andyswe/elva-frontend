package io.github.andyswe.elva.data

import java.util.*
import javax.persistence.*

/**
 * Created by andreas on 2017-09-06.
 */
@Entity
@Cacheable
@org.springframework.cache.annotation.Cacheable
data class Measurement(
        @Id @Temporal(TemporalType.TIMESTAMP) val timestamp: Date,
        val power: Int,
        val elTotal: Int,
        val vaTotal: Int) {
}

