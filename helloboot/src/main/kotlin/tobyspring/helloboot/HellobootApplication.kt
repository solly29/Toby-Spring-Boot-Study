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
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//import org.springframework.boot.autoconfigure.SpringBootApplication
//import org.springframework.boot.runApplication

//@SpringBootApplication
class HellobootApplication

fun main(args: Array<String>) {
//    runApplication<HellobootApplication>(*args)

    val applicationContext = GenericApplicationContext()
    // 빈 등롤
    applicationContext.registerBean(HelloController::class.java, BeanDefinitionCustomizer {  })
    applicationContext.registerBean(SimpleHelloService::class.java, BeanDefinitionCustomizer {  })
    // 컨테이너 초기화
    applicationContext.refresh()

    // Spring boot에서 재공
    val server: ServletWebServerFactory = TomcatServletWebServerFactory()

    // spring boot에서 톰캣 외의 다른 Servlet Container도 지원함
    val webServer: WebServer = server.getWebServer(ServletContextInitializer {

        it.addServlet("frontcontroller", object : HttpServlet() {
            override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

                // 인증, 보안, 다국어 등등의 공동 기능 처리
                if(req?.requestURI == "/hello" && req.method == HttpMethod.GET.name) {
                    // 바인딩
                    val name = req.getParameter("name")

                    val helloController = applicationContext.getBean(HelloController::class.java)
                    val result = helloController.hello(name)

                    // 응답
                    resp?.apply {
                        contentType = MediaType.TEXT_PLAIN_VALUE
                        writer.println(result)
                    }
                } else {
                    resp?.status = HttpStatus.NOT_FOUND.value()
                }

            }
        }).addMapping("/*")
    })

    webServer.start()
}
