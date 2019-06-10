package com.interview.array.leetcode_215;

/**
 * @author ：dxw
 * @date ：Created in 2019/6/10 15:37
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Solution_heap {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k){
            return 0;
        }
        HeapSort(nums,k-1);
        return nums[0];
    }

    private void HeapSort(int nums[], int len){
        //先取前k个元素构建小顶堆
        for (int i = len/2; i>=0; i--) {
            siftDown(nums,i,len);
        }
        //然后依次将k后面的元素加入堆中，维护一个元素大小为k的堆
        //其中堆顶元素为k个元素中的最小值，也是最后要返回的结果
        for (int i = len+1; i < nums.length; i++) {
            if(nums[0]<=nums[i]){
                swap(nums,0,i);
                siftDown(nums,0,len);
            }
        }
    }

    private void siftDown(int[] nums, int k, int len){
        while (leftChild(k) <= len){
            int j = leftChild(k);
            if(j+1<=len && nums[j+1]<nums[j]){
                j = rightChild(k);
            }
            //nums[j]是左右节点中的较小值
            if(nums[k]<=nums[j]){
                break;
            }
            swap(nums,k,j);
            k = j;
        }
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

    private void swap(int nums[],int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
