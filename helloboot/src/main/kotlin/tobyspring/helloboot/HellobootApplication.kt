package tobyspring.helloboot

import org.apache.catalina.startup.Tomcat
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)
    // Spring boot에서 재공
    val server: ServletWebServerFactory = TomcatServletWebServerFactory()

    // spring boot에서 톰캣 외의 다른 Servlet Container도 지원함
    val webServer: WebServer = server.getWebServer()

    webServer.start()
}
