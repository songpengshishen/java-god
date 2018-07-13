package com.wsp.java.god.datastruct;

import java.util.Arrays;

/**
 * Java实现排序算法,默认从小至大
 * @author wangsongpeng
 */
public class Sort {

    public static void main(String[] args) {
        int arr[] = {9,6,5,7,2,1};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arrs){
        int count = 0;
        int length = arrs.length;
        for(int i = 0 ; i<length;i++){
            for(int j = 0 ; j < length - 1 - i;j++){
                if(arrs[j] > arrs[j+1]){
                    int temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(arrs));
        System.out.println("forEach Count is : " + count);
    }



}
