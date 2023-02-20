package tobyspring.helloboot

import org.springframework.stereotype.Component
import java.lang.annotation.ElementType

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Component // 메타 어노테이션
annotation class MyComponent()
