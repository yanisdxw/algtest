package com.study.java;

public class DynamicDispatch {
    static abstract class Human {
        protected abstract void hello();
    }

    static class Man extends Human {
        @Override
        protected void hello() {
            System.out.println("hello man");
        }
    }

    static class Woman extends Human {
        @Override
        protected void hello() {
            System.out.println("hello woman");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.hello();
        woman.hello();
    }
}
