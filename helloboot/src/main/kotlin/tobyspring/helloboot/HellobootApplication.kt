package tobyspring.helloboot

import org.apache.catalina.startup.Tomcat
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.core.io.ResourceLoader
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.reflect.KClass

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
@Configuration
// 해당 어노테이션이 붙어있는 클래스의 패키지 하위에 있는 클래스중 Component를 찾는다.
@ComponentScan
class HellobootApplication {

    @Bean fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

    @Bean fun dispatcherServlet(): DispatcherServlet = DispatcherServlet()
}

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)
    run<HellobootApplication>(*args)
}
