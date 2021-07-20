package com.study.java;

import org.openjdk.jol.info.ClassLayout;

public class ObjectTest {



    public static void main(String[] args) {
        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
    }
}
