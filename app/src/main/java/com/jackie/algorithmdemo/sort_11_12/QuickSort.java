package com.jackie.algorithmdemo.sort_11_12;

import java.util.Arrays;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/12
 */
class QuickSort {


    public static void main(String[] args) {
        int[] a = {9, 9, 10, 11, 12, 1, 3, 5, 6, 8};
        quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r); //获取分区点
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) { //
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;

    }


}
