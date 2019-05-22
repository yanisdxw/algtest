package com.dxw.UnionFind;

public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p){
        assert ( p >= 0 && p < count);
        return id[p];
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void unionElements(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return;
        }
        for (int i = 0; i < count; i++) {
            if(id[i]==pID){
                id[i] = qID;
            }
        }
    }

//    public void printUF(){
//        for (int i = 0; i < count; i++) {
//            System.out.print(id[i]);
//            System.out.print(" ");
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        UnionFindTestHelper.testUF1(1000);
        UnionFindTestHelper.testUF2(1000);
    }
}
