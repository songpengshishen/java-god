package com.wsp.java.god.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序算法
 * 把原数组划分并放入到多个大小一致的桶中,每个桶各自排序最后合并.这些桶本身就按照顺序有进行排序.
 * @author wsp
 */
public class BucketSort {

    public static void main(String[] args) {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        int[] arr = {120,110,70,80,20,3};
        /**
         * 得出数组最大值与最小值
         */
        for(int i = 0 ; i < arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        /**
         * 根据最大值和最小值算出桶的长度并创建桶数组
         */
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        /**
         * 将原数组的元素放入到桶数组的子桶中,元素对应的桶关系公式为 :bucketArr[(arr[i] - min) / (arr.length)]  = arr[i]  ;
         */
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }
}
