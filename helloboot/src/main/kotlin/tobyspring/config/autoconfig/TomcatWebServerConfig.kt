package tobyspring.config.autoconfig

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils
import tobyspring.config.ConditionalMyOnClass
import tobyspring.config.MyAutoConfig

@MyAutoConfig
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

}