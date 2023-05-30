package tobyspring.config.autoconfig

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
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
    @ConditionalOnMissingBean // 해당 타입의 빈이 사용자 구성 정보로 등록되어있지 않으면 자동 구성으로 등록하도록한다.
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}