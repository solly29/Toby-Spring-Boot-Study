package tobyspring.helloboot

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Retention(AnnotationRetention.RUNTIME) // 자바의 디폴트는 클레스이다. 런타임까지 살아있음
@Target(AnnotationTarget.CLASS)
@Configuration
// 해당 어노테이션이 붙어있는 클래스의 패키지 하위에 있는 클래스중 Component를 찾는다.
@ComponentScan
annotation class MySpringBootAnnotation()
