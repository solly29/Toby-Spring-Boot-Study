package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HelloControllerTest {

    @Test
    fun helloController() {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }

        })

        val ret = helloController.hello("Test")

        Assertions.assertThat(ret).isEqualTo("Test")
    }

    @Test
    fun failsHelloController() {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }
        })

        /* 예외가 발생할 경우 테스트 성공 */
        Assertions.assertThatThrownBy {
            helloController.hello(null)
        }.isInstanceOf(IllegalArgumentException::class.java)

        Assertions.assertThatThrownBy {
            helloController.hello("")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}