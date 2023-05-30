package tobyspring.config

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils

class MyOnClassCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val attrs = metadata.getAnnotationAttributes(ConditionalMyOnClass::class.java.name)
        return ClassUtils.isPresent(attrs?.get("value") as String, context.classLoader) // 해당 클래스가 의존성에 포함되어있으면 true
    }
}
