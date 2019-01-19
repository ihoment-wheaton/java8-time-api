package com.demo.java.time.reactor;

import jdk.nashorn.internal.ir.SetSplitState;

import java.util.HashSet;
import java.util.Set;

public class ReactorSandBox {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("cs-eu2@mingerlighting.com");
        set.add("cs-jp@mingerlighting.com");
        set.add("cs-us2@mingerlighting.com");
        set.add("cs-us@mingerlighting.com");
        set.add("cs@mingerlighting.com");
        set.add("govee_sales@hotmail.com");
        set.add("support@aliergo.com");
        set.add("support@govee.com");
        for (String mail : set) {
            System.out.println(mail.hashCode());
        }
    }
}
