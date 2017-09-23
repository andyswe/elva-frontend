package io.github.andyswe.elva.data

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver


@Configuration
class ApplicationMvc : WebMvcConfigurerAdapter() {

    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer?) {
        configurer!!.enable()
    }

    @Bean
    fun viewResolver(): InternalResourceViewResolver {
        val resolver = InternalResourceViewResolver()
        resolver.setPrefix("WEB-INF/jsp/")
        resolver.setSuffix(".jsp")
        return resolver
    }
}