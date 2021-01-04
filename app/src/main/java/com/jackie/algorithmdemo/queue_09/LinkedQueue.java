package com.jackie.algorithmdemo.queue_09;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/4
 */
class LinkedQueue {

    private ListNode head,tail;
    private int n;

    public LinkedQueue(int capacity){
        this.n = capacity;
    }

    public void enqueue(String value){
        if (head == null){
            head = new ListNode(value);
            tail = head;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
    }

    public String dequeue(){
        if (head == null){
            return null;
        }
        String value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return value;
    }




    public static class ListNode{

        private ListNode next;
        private String value;

        public ListNode(String value){
            this.value = value;
        }

        public ListNode(String value,ListNode next){
            this.value = value;
            this.next = next;
        }

    }

}
