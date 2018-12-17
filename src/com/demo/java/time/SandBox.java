package com.demo.java.time;

import java.util.Optional;

public class SandBox {

    public static void main(String[] args) {
        SandBox sandBox = new SandBox();
        sandBox.test();
    }

    public void test() {
        User user = new User();
        String namestr = Optional.ofNullable(user).map(User::getClazz).map(Clazz::getClazzName).orElse("");
        System.out.println(namestr);
        Optional<User> optUser = Optional.ofNullable(user);
        Optional<Clazz> clazz = optUser.map(User::getClazz);
        Optional<String> name = clazz.map(Clazz::getClazzName);
        System.out.println(optUser);
        System.out.println(clazz);
        System.out.println(name);
    }
}
