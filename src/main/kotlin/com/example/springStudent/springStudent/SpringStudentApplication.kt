package com.example.springStudent.springStudent

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class SpringStudentApplication

fun main(args: Array<String>) {
	runApplication<SpringStudentApplication>(*args)
}
