package tobyspring.helloboot

import org.apache.catalina.startup.Tomcat
import org.springframework.beans.factory.config.BeanDefinitionCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.context.support.GenericWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)

    val applicationContext = object : GenericWebApplicationContext() {
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
    applicationContext.registerBean(HelloController::class.java, BeanDefinitionCustomizer {  })
    applicationContext.registerBean(SimpleHelloService::class.java, BeanDefinitionCustomizer {  })
    // 스프링 컨테이너 초기화
    applicationContext.refresh()
}
