package tobyspring.helloboot

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

// ApplicationContextAware이건 Spring 컨테이너가 해당 어노테이션이 있으면 빈 생성할때 setter로 넣어준다.

@RestController
class HelloController(
    private val helloService: HelloService,
    private val applicationContext: ApplicationContext
) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        println(applicationContext)
        return name?.let { helloService.sayHello(it) } ?: throw NullPointerException()
    }
}