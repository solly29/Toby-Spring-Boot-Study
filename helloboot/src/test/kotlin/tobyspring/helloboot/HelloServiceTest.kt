package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy

/* 메타 어노테이션 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@UnitTest
annotation class FastUnitTest

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Test
annotation class UnitTest


class HelloServiceTest {

    @UnitTest
    fun simpleHelloService() {
        val helloService = SimpleHelloService()

        val ret = helloService.sayHello("Test")

        Assertions.assertThat(ret).isEqualTo("Hello Test")
    }

    @FastUnitTest
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