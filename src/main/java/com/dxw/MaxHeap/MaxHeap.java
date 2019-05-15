package com.dxw.MaxHeap;

import com.dxw.array.Array;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1); i>=0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //辅助函数
    private int parent(int index){
        if(index == 0)
        {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index -1)/2;
    }

    private int leftChild(int index){
        return index*2 + 1;
    }

    private int rightChild(int index){
        return index*2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int k){
        //和父亲元素做比较,小的话就交换位置
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    //看堆中最大元素
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("can not find max when heap is empty");
        }
        return data.get(0);
    }

    //取出从堆中最大元素
    public E extractMax(){
        E ret = findMax();

        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            int j = leftChild(k);
            //比较k和左右孩子中最大的那个节点
            //右孩子对应节点的元素值比左孩子对应节点的元素值要大
            if(j+1 < data.getSize() &&
                    data.get(j+1).compareTo(data.get(j))>0){
                j = rightChild(k);
            }
            //data[j] 是左右孩子节点中的最大值
            //如果当前节点对应的元素值比左右孩子的最大值还大，位置正确，结束比较
            if(data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            //否则交换节点的元素值，并继续比较
            data.swap(k,j);
            k = j;
        }
    }

    //取出堆中最大的元素并替换为e
    public E replace(E e){
        E ret = findMax();

        data.set(0,e);
        siftDown(0);

        return ret;
    }


    public static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (int num:testData) {
                maxHeap.add(num);
            }
        }
//        int[] arr = new int[testData.length];
//        for (int i = 0; i < testData.length; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 1; i < testData.length; i++) {
//            if(arr[i-1]<arr[i])
//                throw new IllegalArgumentException("Error");
//        }
//        System.out.println("test completed");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000.0;
    }

    public static void main(String[] args) {
        int n = 2000000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData,true);
        System.out.println(time1);
        double time2 = testHeap(testData,false);
        System.out.println(time2);
        //        //堆排序
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 1; i < n; i++) {
//            if(arr[i-1]<arr[i])
//                throw new IllegalArgumentException("Error");
//        }
//        System.out.println("test completed");
    }
}
