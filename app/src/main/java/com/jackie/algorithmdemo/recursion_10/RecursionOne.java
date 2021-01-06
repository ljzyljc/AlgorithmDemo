package com.jackie.algorithmdemo.recursion_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/5
 */
// 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
// 编程实现求阶乘 n!
// 编程实现一组数据集合的全排列
class RecursionOne {

    static int fibonacciSequence(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    static private List<String> quanPaiLieList = new LinkedList<>();

    static List<String> quanpailie(char[] items, int current) {
        if (current == items.length) {
            quanPaiLieList.add(Arrays.toString(items));
        } else {
            for (int k = current; k < items.length; k++) {

                // k == current 是需要通过的，  而如果两项相等就不需要在排序了 //TODO:待解决重复问题
                if (k == current || items[k] != items[current]) {
                    swap(items, k, current);
                    quanpailie(items, current + 1);
                    swap(items, k, current);
                }
            }
        }
        return quanPaiLieList;
    }

    static void swap(char[] items, int i, int j) {
        char temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(output, res, n, 0);
        return res;

    }

    public void backtrack(List<Integer> output, List<List<Integer>> res, int length, int start) {
        if (start == length) {
            res.add(new ArrayList(output));
        } else {
            for (int i = start; i < length; i++) {
                Collections.swap(output, start, i);
                backtrack(output, res, length, start + 1);
                Collections.swap(output, start, i);
            }
        }
    }

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//        List<Integer> output = new ArrayList<Integer>();
//        for (int num : nums) {
//            output.add(num);
//        }
//
//        int n = nums.length;
//        backtrack(n, output, res, 0);
//        return res;
//    }
//
//    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//        // 所有数都填完了
//        if (first == n) {
//            res.add(new ArrayList<Integer>(output));
//        }
//        for (int i = first; i < n; i++) {
//            // 动态维护数组
//            Collections.swap(output, first, i);
//            // 继续递归填下一个数
//            backtrack(n, output, res, first + 1);
//            // 撤销操作
//            Collections.swap(output, first, i);
//        }
//    }

    public static void main(String[] args) {
        //测试
        System.out.println(fibonacciSequence(10));

        System.out.println(factorial(6));

        char[] a = {'1', '2', '3', '4', '5'};
        char[] b = {'1', '2', '2'};

        List list = quanpailie(b, 0);
        System.out.println(list.toString());
    }

    Map<Integer, Integer> hasSloveMap = new HashMap();

    int totalChoose(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        if (hasSloveMap.containsKey(n)) {
            hasSloveMap.get(n);
        }
        int result = totalChoose(n - 1) + totalChoose(n - 2);
        hasSloveMap.put(n, result);
        return result;
    }


    //非递归实现

    int f(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i < n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return pre;
    }

}
