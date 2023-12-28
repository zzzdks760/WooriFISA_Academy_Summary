package dev.syntax.oop.step02overloading;

public class Mouse {
    int age;
    String name;

    Mouse(){}//기본 생성자

    Mouse(int age){//나이만 지정하여 생성하는 생성자
        this.age = age;
    }

    Mouse(String name){//이름만 지정하여 생성하는 생성자
        this.name = name;
    }

    Mouse(int age, String name) {//나이와 이름을 지정하여 생성하는 생성자
        this.age = age;
        this.name = name;
    }
}