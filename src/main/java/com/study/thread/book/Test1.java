package com.study.thread.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Test1 {

    private Integer count = 0;

    @RequestMapping("get")
    public Integer get(){
        return count++;
    }

}
