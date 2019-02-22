package com.fernanthonies.civapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
	SpringApplication.run(ApiApplication::class.java, *args)
}

