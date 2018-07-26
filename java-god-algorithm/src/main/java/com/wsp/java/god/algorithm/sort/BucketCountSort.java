package com.wsp.java.god.algorithm.sort;

/**
 * 桶的计数排序
 * @author wsp
 */
public class BucketCountSort extends Sort {

    @Override
    protected void doSort(int[] sortArr) {
        int max = 0;//当前数组中的最大值
        for(int i = 0;i<sortArr.length;i++){
            max = Math.max(max,sortArr[i]);
        }
        int bucketArr[] = new int[max+1];
        for(int i = 0 ; i < sortArr.length;i++){
            bucketArr[sortArr[i]]++ ;
        }

        for(int i =0,j=0;i<bucketArr.length;i++){
            int count = bucketArr[i];
            if(count > 0){
                while (count>0){
                     sortArr[j++] = i;
                     count--;
                }
            }
        }

    }
}
