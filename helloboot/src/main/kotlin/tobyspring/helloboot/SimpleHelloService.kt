package tobyspring.helloboot

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

interface HelloService {
    fun sayHello(name: String): String
}

@Service
class SimpleHelloService : HelloService {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }

}