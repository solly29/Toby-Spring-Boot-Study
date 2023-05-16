package tobyspring.helloboot

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.DispatcherServlet

@Configuration
class Config {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

    @Bean
    fun dispatcherServlet(): DispatcherServlet = DispatcherServlet()

}