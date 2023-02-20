package tobyspring.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

//@RestController
class HelloController(
    private val helloService: HelloService
) {

//    @GetMapping("/hello")
    fun hello(name: String?): String {
        return name?.let { helloService.sayHello(it) } ?: throw NullPointerException()
    }
}