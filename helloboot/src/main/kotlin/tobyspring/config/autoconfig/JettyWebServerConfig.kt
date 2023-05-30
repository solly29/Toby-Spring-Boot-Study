package tobyspring.config.autoconfig

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils
import tobyspring.config.ConditionalMyOnClass
import tobyspring.config.MyAutoConfig

@MyAutoConfig
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}