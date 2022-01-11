package com.study.thread.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("api")
public class Test2 {

    private AtomicInteger count = new AtomicInteger(0);

    @RequestMapping("get")
    public Integer get(){
        return count.incrementAndGet();
    }

}
