package com.demo.java.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Filter;

public class SandBox {

    public static void main(String[] args) {
        System.out.println("H7203011".hashCode());
        List<Long> list = new ArrayList<>();
        list.add(1545806098676L);
        list.add(1545808322417L);
        list.add(1545808372894L);
        list.add(1545804513659L);
        list.add(1545807564794L);
        list.add(1545807652820L);
        list.add(1545804767062L);
        list.add(1545805544704L);
        list.add(1545806169947L);
        list.add(1545806098676L);
        list.add(1545807824245L);
        list.add(1545803851868L);
        list.add(1545806596129L);
        list.add(1545807593801L);
        list.add(1545803958620L);
        list.add(1545806817214L);
        list.forEach(l -> {
            System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.of("Asia/Shanghai")));
        });
    }

    public static void filter(String str) {
        if (!"Yes".equalsIgnoreCase(str)) {//过滤掉MFN或者非该市场的库存。
            System.out.println("过滤");
        } else {
            System.out.println("不过滤");
        }
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
