package tobyspring.config.autoconfig

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import tobyspring.config.MyAutoConfig

@MyAutoConfig
@Conditional(JettyWebServerConfig.JettyCondition::class)
class JettyWebServerConfig {
    class JettyCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return false
        }
    }

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}