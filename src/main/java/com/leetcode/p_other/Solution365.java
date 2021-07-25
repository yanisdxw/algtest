package com.leetcode.p_other;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class Solution365 {
    //我们可以认为每次操作只会给水的总量带来 x 或者 y 的变化量。
    //因此我们的目标可以改写成：找到一对整数 a,b 使得
    // ax + by = z
    //而贝祖定理告诉我们，ax+by=z 有解当且仅当 z 是 x, y 的最大公约数的倍数。
    //因此我们只需要找到 x, yx,y 的最大公约数并判断 zz 是否是它的倍数即可。
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y <z){
            return false;
        }
        if(x==0 || y==0){
            return z==0||x+y==z;
        }
        return z%gcd(x,y)==0;
    }

    //找x,y最大公约数
    public int gcd(int x, int y){
        int remain = x%y;
        while (remain!=0){
            x=y;
            y=remain;
            remain=x%y;
        }
        return y;
    }

    //dfs搜索
    public boolean canMeasureWater2(int x, int y, int z){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0,0});
        Set<int[]> visited = new HashSet<>();
        while (!stack.isEmpty()){
            int[] state = stack.pop();
            if(visited.contains(state)){
                continue;
            }
            visited.add(state);
            int x_remain = state[0];
            int y_remian = state[1];
            if(x_remain==z||y_remian==z||x_remain+y_remian==z){
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{x,y_remian});
            // 把 Y 壶灌满。
            stack.push(new int[]{x_remain,y});
            // 把 X 壶倒空。
            stack.push(new int[]{0,y_remian});
            // 把 Y 壶倒空。
            stack.push(new int[]{x_remain,0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{x_remain-Math.min(x_remain,y-y_remian),y_remian+Math.min(x_remain,y-y_remian)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{x_remain+Math.min(y_remian,x-x_remain),y_remian-Math.min(y_remian,x-x_remain)});
        }
        return false;
    }
}
