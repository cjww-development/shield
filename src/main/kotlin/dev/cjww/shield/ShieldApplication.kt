package dev.cjww.shield

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShieldApplication

fun main(args: Array<String>) {
    runApplication<ShieldApplication>(*args)
}
