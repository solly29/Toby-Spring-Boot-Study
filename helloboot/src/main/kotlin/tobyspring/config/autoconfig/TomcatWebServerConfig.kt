package tobyspring.config.autoconfig

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata
import tobyspring.config.MyAutoConfig

@MyAutoConfig
@Conditional(TomcatWebServerConfig.TomcatCondition::class)
class TomcatWebServerConfig {
    class TomcatCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            return true
        }
    }

    @Bean("tomcatWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

}