package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment

@Configuration(proxyBeanMethods = false)
class WebServerConfig {

    /**
     * 유저 구성 정보가 우선 빈으로 등록된다.
     * 그 다음에 자동 구성정보가 등록됨
     */
    @Bean
    fun customerWebServerFactory(env: Environment): ServletWebServerFactory {
        return TomcatServletWebServerFactory().apply {
            contextPath = env.getProperty("contextPath")
            port = 9090
        }
    }
}
