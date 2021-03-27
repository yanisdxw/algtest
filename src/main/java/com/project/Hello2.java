package com.project;

import java.util.ArrayList;
import java.util.List;

public class Hello2 {
    private int o1;
    private int o2;
    public Hello2(int o1, int o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    public List<Integer> say() {
        List<Integer> ans = new ArrayList<>();
        ans.add(Integer.valueOf(o1));
        ans.add(Integer.valueOf(o2));
        return ans;
    }
}
