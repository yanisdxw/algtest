package com.datastruct.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public void enqueue(E e) {
        if((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        if(size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return data[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front==tail;
    }

    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d capacity = %d\n",
                size,getCapacity()));
        res.append("front [");
        //与resize的遍历方法不同，可以互换
//        for (int i = front; i !=tail; i=(i+1)%data.length) {
//            res.append(data[i]);
//            if((i+1)%data.length!=tail){
//                res.append(",");
//            }
//        }

        for (int i = 0; i < size; i++) {
            res.append(data[(i+front)%data.length]);
            if(i!=size-1){
                res.append(",");
            }
        }

        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if(i%3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }

}
