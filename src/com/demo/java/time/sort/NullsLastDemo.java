package com.demo.java.time.sort;

import com.demo.java.time.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NullsLastDemo {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("name" + i);
            user.setGrade(20 - i);

            User user1 = new User();
            user1.setName("nn" + i);
            user1.setGrade(1000-i);
            list.add(user);
            list.add(user1);
        }
        System.out.println(list);

        list.sort(Comparator.comparing(User::getAge, Comparator.nullsFirst(Comparator.naturalOrder()))
                            .thenComparing(User::getGrade).reversed());
        System.out.println(list);
    }
}
