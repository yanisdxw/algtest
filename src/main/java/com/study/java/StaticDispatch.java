package com.study.java;

public class StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void hello(Human human){
        System.out.println("hello guy");
    }

    public void hello(Man man){
        System.out.println("hello man");
    }

    public void hello(Woman woman){
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        //静态分配
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.hello(man);
        staticDispatch.hello(woman);
        staticDispatch.hello((Man) man);
        staticDispatch.hello((Woman) woman);
    }
}
