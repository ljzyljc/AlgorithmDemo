package com.jackie.algorithmdemo.sort_11_12;

import java.util.Arrays;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/6
 */
class SelectionSort {

    public static void selectionSort(int[] items, int length) {
        if (length <= 1) return;
        for (int i = 0; i < length - 1; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (items[j] < items[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            swap(items,i,minIndex);
        }
    }

    private static void swap(int[] items,int i,int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 6, 8, 5};
        selectionSort(a,a.length);
        System.out.println(Arrays.toString(a));
    }

}
