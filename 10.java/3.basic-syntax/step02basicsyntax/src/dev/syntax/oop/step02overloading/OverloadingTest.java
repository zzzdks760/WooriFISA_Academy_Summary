package dev.syntax.oop.step02overloading;

public class OverloadingTest {
    public static void main(String[] args) {
        //생성자의 오버로딩

        Mouse jerry = new Mouse();
        Mouse jay = new Mouse(15);
        Mouse jamie = new Mouse("제이미");
        Mouse joo = new Mouse(15, "주");
    }
}