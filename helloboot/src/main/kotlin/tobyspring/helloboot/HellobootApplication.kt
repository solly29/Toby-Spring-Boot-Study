package tobyspring.helloboot

import org.springframework.boot.runApplication
import tobyspring.config.MySpringBootApplication

//import org.springframework.boot.autoconfigure.SpringBootApplication

//@SpringBootApplication
@MySpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
