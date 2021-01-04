package com.jackie.algorithmdemo.stack_08;

import java.util.Stack;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/28
 */
public class StackSimpleBrowser {
    private StackBasedOnLinkedList AStack;
    private StackBasedOnLinkedList BStack;
    private String currentPage;

    public StackSimpleBrowser(int size) {
        AStack = new StackBasedOnLinkedList(size);
        BStack = new StackBasedOnLinkedList(size);
    }

    public static void main(String[] args) {
        StackSimpleBrowser stackSimpleBrowser = new StackSimpleBrowser(100);
        stackSimpleBrowser.open("www.baidu.com");
        stackSimpleBrowser.open("www.alibaba.com");
        stackSimpleBrowser.open("www.tencent.com");
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goForward();
        stackSimpleBrowser.open("www.qq.com");
        stackSimpleBrowser.goForward();
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goBack();
        stackSimpleBrowser.goBack();
        System.out.println(stackSimpleBrowser.currentPage);

    }




    public void goForward(){
        if (!canGoForward()){
            System.out.println("=====no thing to go forward");
            return;
        }
        String forward = BStack.pop();
        System.out.println("==========向前:"+forward);
        AStack.push(forward);
        currentPage(forward);
    }


    public void goBack(){

        if (!canGoBack()){
            this.currentPage = "当前界面为空";
            System.out.println("====no thing to go back");
            return;
        }
        String url = AStack.pop();
        boolean isPush = BStack.push(url);
        if (!isPush){
            System.out.println("前进栈已满");
        }
        System.out.println("从"+url+"返回");

    }

    public void currentPage(String url){
        this.currentPage = url;
        System.out.println("===当前界面======="+this.currentPage);
    }

    public void open(String url){
        boolean isPush = AStack.push(url);
        if (!isPush) {
            System.out.println("已满，不能再打开了");
        }
        currentPage(url);
        BStack.clear();
    }

    private boolean canGoForward(){
        if (BStack.getSize() > 0){
            return true;
        }
        return false;
    }

    private boolean canGoBack(){
        if (AStack.getSize() > 0){
            return true;
        }
        return false;
    }

}
