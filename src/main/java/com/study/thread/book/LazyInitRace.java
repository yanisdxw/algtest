package com.study.thread.book;

public class LazyInitRace {

    private static LazyInitRace instance;

    private LazyInitRace(){};

    public static LazyInitRace getInstance(){
        if(instance==null){
            instance = new LazyInitRace();
        }
        return instance;
    }

}
