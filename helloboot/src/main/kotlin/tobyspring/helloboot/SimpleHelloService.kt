package tobyspring.helloboot

interface HelloService {
    fun sayHello(name: String): String
}

class SimpleHelloService : HelloService {

    override fun sayHello(name: String): String {
        return "Hello $name"
    }

}