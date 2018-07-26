package com.wsp.java.god.algorithm.sort;

/**
 * 快速排序
 * 在待排序的数据中找出一个基数(参照数)通常是左边的第一个数,从右边开始找到小于基准数的数,在从左边找到大于基准数的数进行跳跃交换直到相遇后。
 * 把基数放到了合适的位置,左边的数都小于它,右边的数据都大于它,然后一直迭代直到排序完成
 *
 * @author wsp
 */
public class QuickSort extends Sort {

    @Override
    protected void doSort(int[] sortArr) {
        quickSort(sortArr,0,sortArr.length-1);
    }

    protected void quickSort(int[] sortArr, int leftIndex, int rightIndex) {
        int i, j, temp, baseNum;
        if (leftIndex > rightIndex) {
            return;
        }
        baseNum = sortArr[leftIndex];//设置基准数
        i = leftIndex;/*当前左边索引*/
        j = rightIndex; /*当前右边索引*/
        /**
         *条件就是不相遇
         */
        while (i != j) {
            /**
             * 先从右边查小的
             */
            while (sortArr[j]>=baseNum&&i<j){
                j--;
            }

            /**
             * 再从左边查大的
             */
            while (sortArr[i]<=baseNum&&i<j){
                i++;
            }

            if(i<j){
                temp = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = temp;
            }
            sortArr[leftIndex] = sortArr[i];
            sortArr[i] = baseNum;
            quickSort(sortArr,leftIndex,i-1);
            quickSort(sortArr,i+1,rightIndex);
        }
    }


}
