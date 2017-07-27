package com.nerdery.icoffiel.quest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class NerdQuestApplication

fun main(args: Array<String>) {
    SpringApplication.run(NerdQuestApplication::class.java, *args)
}
