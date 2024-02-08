package dev.syntax.aop;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    public void getUsers() {

        // DB로부터 받아온 User 정보
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Tom"));
        users.add(new User(2, "Jerry"));

        System.out.println("전체 User :" + users);

    }

    public Object saveUser(User user) {

        System.out.println("저장할 User 정보:" + user);
        // DB에 저장하는 로직을 작성하는 부분

        return null;
    }

}
