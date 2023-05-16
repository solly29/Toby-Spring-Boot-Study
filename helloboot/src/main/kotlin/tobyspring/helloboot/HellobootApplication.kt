package tobyspring.helloboot

import org.springframework.boot.runApplication

//import org.springframework.boot.autoconfigure.SpringBootApplication

//@SpringBootApplication
@MySpringBootAnnotation
class HellobootApplication

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
