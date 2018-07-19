package com.wsp.java.god.algorithm.sort;

/**
 * 插入排序
 * 从数据的第N(通常是2)个元素开始和0 -- n-1之间的元素进行比较交换插入到合适的位置,一直到最后一个元素就完成排序了
 * @author wsp
 */
public class InsertionSort extends Sort {

    @Override
    protected void doSort(int[] sortArr) {
        int n = 1;/*开始排序的元素x*/
        for(int i = n;i<sortArr.length;i++){
            for(int j = i;j>0&&sortArr[j]<sortArr[j-1];j--){
                  int temp = sortArr[j];
                  sortArr[j] = sortArr[j-1];
                  sortArr[j-1] = temp;
            }
        }
    }
}
