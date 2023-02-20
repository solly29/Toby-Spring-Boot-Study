package tobyspring.helloboot

import org.springframework.beans.BeansException
import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.servlet.DispatcherServlet

class MySpringApplication {

    companion object {
        fun run(applicationClass: Class<*>, vararg args: String) {
            // GenericWebApplicationContext 는 자바에서 작성한 config를 읽을 수 없다

            // kotlin 에서는 AnnotationConfigWebApplicationContext가 안된다.......ㅠㅜㅠㅜ
            val applicationContext = object : AnnotationConfigServletWebApplicationContext() {

                override fun onRefresh() {
                    super.onRefresh()

                    // 스프링 컨테이너가 초기화하는 중에 해당 작업을 실행한다.
                    // Spring boot에서 재공
                    val server: ServletWebServerFactory = getBean(ServletWebServerFactory::class.java)
                    val dispatcherServlet = getBean(DispatcherServlet::class.java)

                    // spring boot에서 톰캣 외의 다른 Servlet Container도 지원함
                    val webServer: WebServer = server.getWebServer(ServletContextInitializer {
                        it.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*")
                    })

                    webServer.start()
                }
            }
            // 빈 등롤
            applicationContext.register(applicationClass)
            // 스프링 컨테이너 초기화
            applicationContext.refresh()
        }
    }

}
inline fun <reified T> run(vararg args: String) {
    MySpringApplication.run(T::class.java, *args)
}