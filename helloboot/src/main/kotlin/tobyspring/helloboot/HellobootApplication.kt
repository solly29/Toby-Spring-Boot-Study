package tobyspring.helloboot

import org.apache.catalina.startup.Tomcat
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)
    // Spring boot에서 재공
    val server: ServletWebServerFactory = TomcatServletWebServerFactory()

    // spring boot에서 톰캣 외의 다른 Servlet Container도 지원함
    val webServer: WebServer = server.getWebServer(ServletContextInitializer {
        it.addServlet("hello", object : HttpServlet() {
            override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

                val name = req?.getParameter("name")

                // 응답
                resp?.apply {
                    status = HttpStatus.OK.value()
                    setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                    writer.println("Hello $name")
                }
            }
        }).addMapping("/hello")
    })

    webServer.start()
}
