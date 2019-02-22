package com.fernanthonies.civapp

import com.fernanthonies.civapp.Properties.ApplicationProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties::class)
class ApiApplication

fun main(args: Array<String>) {
	SpringApplication.run(ApiApplication::class.java, *args)
}

