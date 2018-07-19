package com.wsp.java.god.algorithm.sort;

/**
 * 选择排序
 * 从数据的0索引位置开始依次与后续索引的数据进行比较,每次比较出较大或较小的值就交换到此次比较的位置上
 * @author wsp
 */
public class SelectionSort extends Sort{

    @Override
    protected void doSort(int[] sortArr) {
        for(int i = 0 ; i < sortArr.length;i++){
            int min = i;/*此次循环出的最小值索引*/
            for(int j = i + 1;j<sortArr.length;j++){
                if(sortArr[j] < sortArr[min]){
                    min = j;
                }
            }
            /**
             * 如果位置不同在交换
             */
            if(i != min){
                int temp = sortArr[i];
                sortArr[i] = sortArr[min];
                sortArr[min] = temp;
            }
        }
    }
}
