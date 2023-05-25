package tobyspring.config.autoconfig

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import tobyspring.config.MyAutoConfig

@MyAutoConfig
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}