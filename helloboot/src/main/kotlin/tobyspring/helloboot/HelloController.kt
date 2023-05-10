package tobyspring.helloboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

// ApplicationContextAware이건 Spring 컨테이너가 해당 어노테이션이 있으면 빈 생성할때 setter로 넣어준다.

@RestController
class HelloController(
    private val helloService: HelloService
) {

    @GetMapping("/hello")
    fun hello(name: String?): String {

        if(name.isNullOrBlank()) throw IllegalArgumentException()

        return helloService.sayHello(name)
    }
}