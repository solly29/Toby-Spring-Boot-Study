package tobyspring.config

import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata

class MyAutoConfigImportSelector(
        private val classLoader: ClassLoader
) : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        // MyAutoConfig 의 패키지명.imports 파일의 정보를 가져온다.
        return ImportCandidates.load(MyAutoConfig::class.java, classLoader)
                .toList()
                .toTypedArray()
    }
}