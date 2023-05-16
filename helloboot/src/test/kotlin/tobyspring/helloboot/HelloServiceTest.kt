package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloServiceTest {

    @Test
    fun simpleHelloService() {
        val helloService = SimpleHelloService()

        val ret = helloService.sayHello("Test")

        Assertions.assertThat(ret).isEqualTo("Hello Test")
    }

    @Test
    fun helloDecorator() {
        val helloDecorator = HelloDecorator(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        val ret = helloDecorator.sayHello("Test")

        Assertions.assertThat(ret).isEqualTo("*Test*")
    }
}