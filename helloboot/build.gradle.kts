import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.spring") version "1.7.21"
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

group = "tobyspring"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") {
        // 해당 라이브러리에서 특정 의존성 삭제
//        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

//    implementation("org.springframework.boot:spring-boot-starter-jetty")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kover {
    htmlReport {
        onCheck.set(true)
    }
    verify {
        rule {
            isEnabled = true
            name = "Coverage must be more then 60%"
            bound {
                minValue = 30
            }
        }
    }
}