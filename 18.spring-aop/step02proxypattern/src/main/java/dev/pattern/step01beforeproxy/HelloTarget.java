package dev.pattern.step01beforeproxy;

public class HelloTarget implements Hello {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "Bye " + name;
    }
}
