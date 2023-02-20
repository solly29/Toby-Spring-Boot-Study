package tobyspring.helloboot

import org.apache.catalina.startup.Tomcat
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
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

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
@Configuration
// 해당 어노테이션이 붙어있는 클래스의 패키지 하위에 있는 클래스중 Component를 찾는다.
@ComponentScan
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)
    // GenericWebApplicationContext 는 자바에서 작성한 config를 읽을 수 없다

    // kotlin 에서는 AnnotationConfigWebApplicationContext가 안된다.......ㅠㅜㅠㅜ
    val applicationContext = object : AnnotationConfigServletWebApplicationContext() {

        override fun onRefresh() {
            super.onRefresh()

            // 스프링 컨테이너가 초기화하는 중에 해당 작업을 실행한다.
            // Spring boot에서 재공
            val server: ServletWebServerFactory = TomcatServletWebServerFactory()

            // spring boot에서 톰캣 외의 다른 Servlet Container도 지원함
            val webServer: WebServer = server.getWebServer(ServletContextInitializer {
                it.addServlet("dispatcherServlet",
                    DispatcherServlet(this)
                ).addMapping("/*")
            })

            webServer.start()
        }
    }
    // 빈 등롤
    applicationContext.register(HellobootApplication::class.java)
    // 스프링 컨테이너 초기화
    applicationContext.refresh()
}
