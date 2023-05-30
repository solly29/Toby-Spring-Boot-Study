package tobyspring.study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest {

    @Test
    fun conditional() {
        // true
        ApplicationContextRunner().withUserConfiguration(Config1::class.java)
                .run {
                    Assertions.assertThat(it).hasSingleBean(MyBean::class.java)
                    Assertions.assertThat(it).hasSingleBean(Config1::class.java)
                }

        // false
        // 컨디셔널의 조건이 false여서 에러가남
        ApplicationContextRunner().withUserConfiguration(Config2::class.java)
                .run {
                    Assertions.assertThat(it).doesNotHaveBean(MyBean::class.java)
                    Assertions.assertThat(it).doesNotHaveBean(Config1::class.java)
                }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(
        val value: Boolean
    )

    @Configuration
    @BooleanConditional(true)
    class Config1 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @BooleanConditional(false)
    class Config2 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    class BooleanCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            // matadata는 해당 어노테이션이 붙은 클래스에 붙어있는 모든 어노테이션을 불러온다
            val annotationAttributes = metadata.getAnnotationAttributes(BooleanConditional::class.java.name) // 특정 어노테이션의 속성을 가져올 수 있다
            return annotationAttributes?.get("value") as Boolean // 어노테이션의 속성 값을 가져온다.
        }
    }

    class MyBean()
}