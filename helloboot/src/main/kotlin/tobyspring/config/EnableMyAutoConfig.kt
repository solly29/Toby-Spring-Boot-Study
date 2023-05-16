package tobyspring.config

import org.springframework.context.annotation.Import
import tobyspring.config.autoconfig.DispatcherServletConfig
import tobyspring.config.autoconfig.TomcatWebServerConfig

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(MyAutoConfigImportSelector::class) // component가 붙은 어노테이션을 임폴트할 수 있다.
annotation class EnableMyAutoConfig()
