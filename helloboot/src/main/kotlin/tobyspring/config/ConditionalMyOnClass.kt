package tobyspring.config

import org.springframework.context.annotation.Conditional

/**
 * 자동 구성
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Conditional(MyOnClassCondition::class)
annotation class ConditionalMyOnClass(
        val value: String
)
