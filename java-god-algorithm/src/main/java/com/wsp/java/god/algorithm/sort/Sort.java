package com.wsp.java.god.algorithm.sort;

import java.util.Arrays;

/**
 * 排序类
 * @author wsp
 */
public abstract class Sort {


    public static void main(String[] args) {
        int arr[] = {12,8,1,4,6,2,6,3,12,8,1,4,6};
        Sort sort = new QuickSort();
        sort.sort(arr);
    }

    public void sort(int sortArr[]){
        long startTime = System.currentTimeMillis();
        doSort(sortArr);
        showSortArr(sortArr);
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.println("total Use Time : " + endTime);
    }

    private void showSortArr(int sortArr[]){
        System.out.println(Arrays.toString(sortArr));
    }


    protected abstract void doSort(int sortArr[]);



}
