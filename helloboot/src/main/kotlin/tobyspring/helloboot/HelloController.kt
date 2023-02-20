package tobyspring.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

//@RestController
@RequestMapping("/hello")
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping
    @ResponseBody
    fun hello(name: String?): String {
        return name?.let { helloService.sayHello(it) } ?: throw NullPointerException()
    }
}