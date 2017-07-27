package com.nerdery.icoffiel.quest.config

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class JacksonConfiguration : WebMvcConfigurerAdapter() {

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        val builder: Jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilder()
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
        converters?.add(MappingJackson2HttpMessageConverter(builder.build()))
    }
}