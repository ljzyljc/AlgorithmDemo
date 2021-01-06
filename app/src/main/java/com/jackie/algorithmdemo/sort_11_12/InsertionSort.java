package com.jackie.algorithmdemo.sort_11_12;

import java.util.Arrays;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/6
 */
class InsertionSort {

    static void insertionSort(int[] items, int length) {
        if (length <= 1) return;
        for (int i = 1; i < length; i++) {
            int value = items[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (items[j] > value) {
                    items[j + 1] = items[j];
                } else {
                    break;
                }
            }
            items[j + 1] = value;
        }
    }


    public static void main(String[] args) {

        int[] a = {2, 1, 4, 6, 8, 5};
        insertionSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }


}
