package com.jackie.algorithmdemo.stack_08;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/28
 */
public class StackBasedOnLinkedList {

    public StackBasedOnLinkedList(int n){
        this.n = n;
        this.count = 0;

    }

    private int count; //栈中元素的个数

    public int n; //栈的大小

    private ListNode top;

    public boolean push(String item){
        if (count == n){
            System.out.println("stack already full");
            return false;
        }
        count++;
        ListNode tempNode = top;
        top = new ListNode(item);
        top.next = tempNode;
        return true;

    }

    public void clear(){
        this.top = null;
        this.count = 0;
    }

    public int getSize(){
        return count;
    }


    public String pop(){
        if (count == 0){
            System.out.println("stack is empty");
            return null;
        }
        count--;
        String data = top.data;
        top = top.next;
        //System.out.println("=============="+data);
        return data;

    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stackBasedOnLinkedList = new StackBasedOnLinkedList(5);
        stackBasedOnLinkedList.push("1");
        stackBasedOnLinkedList.push("12");
        stackBasedOnLinkedList.push("123");
        stackBasedOnLinkedList.push("1234");
        stackBasedOnLinkedList.push("12345");
        stackBasedOnLinkedList.push("123456");

        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.pop();
        stackBasedOnLinkedList.pop();


    }










    public static class ListNode{

        private ListNode next;
        private String data;

        public ListNode(String data){
            this.data = data;
        }

        public ListNode(String data,ListNode next){
            this.data = data;
            this.next = next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

}
