package com.datastruct.array;

public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 想所有元素后添加一个元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个新元素
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(size==data.length){
            //throw new IllegalArgumentException("AddLast failed. Array is full");
            //扩容
            resize(2*data.length);
        }
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        for (int i = size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E remove(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        //data[size] = null;
        //lazy缩容以防止复杂度震荡
        if(size==data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public boolean removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d capacity = %d\n",
                size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    public E get(int index){
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index, E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("AddLast failed. Array is full");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.removeElement(9);
        System.out.println(arr);
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
