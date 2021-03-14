package com.study.bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 位图排序
 * 首先我们要明确对于位向量来说，要存储一组小于N的正整数，那么就需要N位的二进制数。
 * 而如果使用int数组来表示二进制位，1int=4byte=4*8bit，那么一个int元素就可以表示32位，
 * 即存储小于32的正整数集合，两个int元素可以表示64位，即存储小于64的正整数集合。
 * 如何定位正整数i在数组中的位置呢？ 一句话：32整除i，商Q是int数组的下标，余数P是1在这个int元素中的位数。
 */
//原文链接：https://blog.csdn.net/weixin_42237496/article/details/114191729
public class Bitmap {
    /**
     * 置位：用余数(二进制表示，即1 << Q)与相应的int元素做或操作
     *
     * 置零：将余数(二进制表示，即1 << Q)取反，然后结果与int元素做与运算
     *
     * 读取：用余数与相应的int元素做与运算，得到int元素中该位置的值，如为1则返回1，为0则返回0。
     */
    private int n;
    private int[] bitmap;
    private static final int BIT_LENGTH=32;//int 类型32位
    private static int P;
    private static int Q;

    public Bitmap(int n){
        this.n = n;
        bitmap = new int[(n-1)/BIT_LENGTH+1];
        init();
    }

    private void init(){
        for (int i = 0; i < n; i++) {
            clr(i);
        }
    }

    /** * 获取排序后的数组 *@return */
    public List getSortedArray(){
        List sortedArray = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (get(i) == 1) {
                sortedArray.add(i);
            }
        }
        return sortedArray;
    }

    /**输入未排序数组*/
    public void setUnsortArray(int[] unsortArray){
        for (int i = 0; i < unsortArray.length; i++) {
            set(unsortArray[i]);
        }
    }

    /**
     * 置零：将余数(二进制表示，即1 << Q)取反，然后结果与int元素做与运算
     * @param i
     */
    private void clr(int i){
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;
        bitmap[P]&= ~(1<<Q);
    }

    /**
     * 置位：用余数(二进制表示，即1 << Q)与相应的int元素做或操作
     * @param i
     */
    private void set(int i){
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;
        bitmap[P]|= 1<<Q;
    }

    /**
     * 读取：用余数与相应的int元素做与运算，得到int元素中该位置的值，如为1则返回1，为0则返回0。
     * @param i
     * @return
     */
    public int get(int i){
        P = i / BIT_LENGTH;
        Q = i % BIT_LENGTH;
        return Integer.bitCount(bitmap[P] & (1 << Q));
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(15);
        bitmap.init();
        int[] unsorted = new int[]{11,7,12,1,2,9,3,13,6,5,14,4,8,10};
        bitmap.setUnsortArray(unsorted);
        List<Integer> sorted = bitmap.getSortedArray();
        for (int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < bitmap.bitmap.length; i++) {
            System.out.print(bitmap.bitmap[i]+" ");
        }
        System.out.println();
        int a = 10;
        int b = 1<<a;
        System.out.println(b);
    }
}
