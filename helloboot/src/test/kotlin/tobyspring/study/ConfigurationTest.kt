package tobyspring.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ConfigurationTest {

    @Test
    fun configuration() {

        val ac = AnnotationConfigApplicationContext()
        ac.register(MyConfig::class.java)
        ac.refresh()

        val bean1 = ac.getBean(Bean1::class.java)
        val bean2 = ac.getBean(Bean2::class.java)

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    @Test
    fun proxyCommonMethod() {
        val myConfigProxy = MyConfigProxy()

        val bean1 = myConfigProxy.bean1()
        val bean2 = myConfigProxy.bean2()

        Assertions.assertThat(bean1.common).isSameAs(bean2.common)
    }

    class MyConfigProxy : MyConfig() {
        private lateinit var cm: Common
        override fun common(): Common {
            if(!::cm.isInitialized) cm = super.common()

            return cm
        }
    }

    @Configuration
    class MyConfig {

        /**
         * proxyBeanMethods 가 true로 설정되어있으면 프록시 패턴으로 인해서 같은 common 객체를 사용하게된다.
         */
        @Bean
        fun common(): Common = Common()

        @Bean
        fun bean1(): Bean1 = Bean1(common())

        @Bean
        fun bean2(): Bean2 = Bean2(common())
    }

    class Bean1(
            val common: Common
    ) {}

    class Bean2(
            val common: Common
    ) {}

    class Common {

    }
}