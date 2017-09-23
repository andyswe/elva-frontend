package io.github.andyswe.elva.data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.view.InternalResourceViewResolver


/**
 * Created by andreas on 2017-09-05.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableCaching
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Bean
    public open fun viewResolver(): InternalResourceViewResolver {
        val resolver = InternalResourceViewResolver()
        resolver.setPrefix("/WEB-INF/jsp/")
        resolver.setSuffix(".jsp")

        return resolver
    }
}