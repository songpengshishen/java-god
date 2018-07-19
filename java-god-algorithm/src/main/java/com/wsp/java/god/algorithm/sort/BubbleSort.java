package com.wsp.java.god.algorithm.sort;

/**
 * 冒泡排序
 * 依次比较相邻的两个数值,按照升序或降序交换它们,每次比较都决定一个该次最大值或最小值的位置
 * @author wsp
 */
public class BubbleSort extends Sort{

    @Override
    protected void doSort(int[] sortArr) {
        for(int i = 0;i<sortArr.length;i++){
            for(int j = 0;j<sortArr.length-i-1;j++){
                 if(sortArr[j] > sortArr[j+1]){
                     int temp = sortArr[j];
                     sortArr[j] = sortArr[j+1];
                     sortArr[j+1] = temp;
                 }
            }
        }
    }
}
