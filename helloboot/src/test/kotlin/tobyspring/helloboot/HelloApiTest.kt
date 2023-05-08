package tobyspring.helloboot

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

class HelloApiTest {

    @Test
    fun helloApi() {
        // http localhost:8080/hello?name=Spring

        val rest = TestRestTemplate()

        val res: ResponseEntity<String> = rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "Spring")

        // 검증
        // status code 200
        Assertions.assertThat(res.statusCode).isEqualTo(HttpStatus.OK)

        // header(content-type) text/plain
        // startsWith는 결과값이 MediaType.TEXT_PLAIN_VALUE 이거로 시작하는지 확인
        Assertions.assertThat(res.headers.getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE)

        // body Hello Spring
        Assertions.assertThat(res.body).isEqualTo("Hello Spring")
    }
}