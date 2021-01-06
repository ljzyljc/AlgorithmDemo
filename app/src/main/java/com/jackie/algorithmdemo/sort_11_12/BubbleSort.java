package com.jackie.algorithmdemo.sort_11_12;

import java.util.Arrays;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/6
 */
class BubbleSort {



    static int[] bubbleSort(int[] items, int length) {
        if (length <= 1){
            return items;
        }
        for (int i = 0; i < length; i++) {
            System.out.println(items[i]);
            //提前退出标志位，优化
            boolean flag = false;
            //最后一次交换的位置，优化
            int lastExchange = 0;
            int sortBorder = length - 1;
            for (int j = 0; j < sortBorder; j++) {
                if (items[j] > items[j+1]){
                    swap(items,j,j+1);
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag){  //没有数据交换，提前退出
                break;
            }
        }
        return items;
    }

    static void swap(int[] sortItems,int a,int b){
        int temp = sortItems[a];
        sortItems[a] = sortItems[b];
        sortItems[b] = temp;
    }


    public static void main(String[] args) {
        int[] sortItems = {1, 4, 5, 7, 2, 9, 7};
        int[] b = bubbleSort(sortItems,sortItems.length);
        System.out.println(Arrays.toString(b));
    }
}
