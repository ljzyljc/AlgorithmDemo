package com.jackie.algorithmdemo.stack_08;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/28
 */
public class StackBasedOnArray {

    public String[] arrays;
    private int count; //栈中现有元素个数
    private int n; //栈的大小

    public StackBasedOnArray(int n){
        arrays = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item){
        if (count == n){
            System.out.println("超过栈的最大容量");
            return false;
        }
        arrays[count] = item;
        count++;
        return true;
    }

    public String pop(){
        if (count == 0){
            return null;
        }
        count--;
        return arrays[count];
    }

}
