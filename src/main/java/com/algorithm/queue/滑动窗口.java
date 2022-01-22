package com.algorithm.queue;

import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 滑动窗口 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[n];
//        for(int i=0;i<n;i++){
//            a[i] = sc.nextInt();
//        }
//        //队头维护最小值
//        Deque<Integer> q = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if(!q.isEmpty() && q.getFirst()<i-k+1) q.removeFirst();
//            while (!q.isEmpty() && a[q.getLast()]>=a[i]) q.removeLast();
//            q.offerLast(i);
//            if(i>=k-1) System.out.print(a[q.getFirst()]+" ");
//        }
//        System.out.println();
//        q.clear();
//        //队头维护最大值
//        for (int i = 0; i < n; i++) {
//            if(!q.isEmpty() && q.getFirst()<i-k+1) q.removeFirst();
//            while (!q.isEmpty() && a[q.getLast()]<=a[i]) q.removeLast();
//            q.offerLast(i);
//            if(i>=k-1) System.out.print(a[q.getFirst()]+" ");
//        }
//    }


    private static int N = 1000010;
    private static int[] q = new int[N];
    private static int h = 0;
    private static int t = -1;
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        //队头维护最小值
        for (int i = 0; i < n; i++) {
            if(h<=t && q[h]<i-k+1) h++;
            while (h<=t && a[q[t]]>=a[i]) t--;
            q[++t] = i;
            if(i>=k-1) out.print(a[q[h]]+" ");
        }
        out.println();
        h=0; t=-1;
        //队头维护最大值
        for (int i = 0; i < n; i++) {
            if(h<=t && q[h]<i-k+1) h++;
            while (h<=t && a[q[t]]<=a[i]) t--;
            q[++t] = i;
            if(i>=k-1) out.print(a[q[h]]+" ");
        }
        out.flush();
    }
}
