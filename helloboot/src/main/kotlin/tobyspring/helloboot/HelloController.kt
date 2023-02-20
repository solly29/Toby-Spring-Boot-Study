package tobyspring.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

//@RestController
class HelloController {

//    @GetMapping("/hello")
    fun hello(name: String?): String {

        val helloService = SimpleHelloService()

        return name?.let { helloService.sayHello(it) } ?: throw NullPointerException()
    }
}