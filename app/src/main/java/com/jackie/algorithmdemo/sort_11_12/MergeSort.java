package com.jackie.algorithmdemo.sort_11_12;

import java.util.Arrays;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/18
 */
class MergeSort {


    public static void main(String[] args) {
        int[] a = {9,9,10,11,12,1,3,5,6,8};
        mergeSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a,int n){
        mergeSortInternally(a,0,n-1);
    }

    private static void mergeSortInternally(int[] a,int p,int r){
        //递归终止条件
        if (p >= r){
            return;
        }
        //取p到r之间的中间位置，防止（p+r）的和超过int类型最大值
        int q = p + ((r-p) >> 2);
        //分治递归
        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a,p,q,r);

    }

    private static void merge(int[] a,int p,int q,int r){  //     9,9,10,11,12    1,2,4,6,8
        int i = p;
        int j = q+1;
        int k = 0;

        int[] temp = new int[r-p+1]; //申请一个跟a[p..r]一样的临时数组
        while (i <= q && j<=r){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r){
            start = j;
            end = r;
        }

        while (start <= end){
            temp[k++] = a[start++];
        }
        //将temp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; i++) {
            a[p+i] = temp[i];
        }

    }


}
