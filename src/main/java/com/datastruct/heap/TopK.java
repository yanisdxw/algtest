package com.datastruct.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
    public List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }
}
