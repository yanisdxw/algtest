package com.datastruct.LinkedList;

public class LinkedList<E> {

    //用户不需要知道底层细节，只需要知道是一个动态线性结构
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的index位置添加新元素e
    //在链表中不是一个常用操作，练习用
    public void add(E e, int index){
        //关键： 找到要插入节点的前一个节点
        if(index<0|| index>size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        //先找到要插入节点（index位置）的前一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        //优雅的写法
        prev.next = new Node(e,prev.next);
        size++;
    }

    //在链表头添加新的元素e
    public void addFirst(E e){
        add(e,0);
    }
    public void addLast(E e){
        add(e,size);
    }

    //获得链表第index的元素
    public E get(int index){
        if(index<0|| index>size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        //找index那个位置的而不是index前一个位置
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //修改链表的第index个位置的元素为e
    public void set(E e, int index){
        if(index<0|| index>size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        //找index那个位置的而不是index前一个位置
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        //两种遍历方式
        while (cur!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index<0|| index>size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        Node prev = dummyHead;
        while (prev.next!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur!=null){
//            res.append(cur+"->");
//            cur = cur.next;
//        }

        for (Node cur = dummyHead.next;  cur!=null ; cur = cur.next){
            res.append(cur+"->");
        }
        return res.append("Null").toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666,2);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
