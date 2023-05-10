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
}