package com.study.thread.book;

import java.util.Vector;

public class VectorTest {

    public static Object getLast(Vector list){
        int lastIndex = list.size()-1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list){
        int lastIndex = list.size()-1;
        list.remove(lastIndex);
    }

}
