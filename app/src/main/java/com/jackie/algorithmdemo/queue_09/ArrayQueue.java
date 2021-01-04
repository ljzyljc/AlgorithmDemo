package com.jackie.algorithmdemo.queue_09;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/4
 */
class ArrayQueue {

    private String[] array;
    private int n;

    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.n = capacity;
        array = new String[capacity];
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) { //表示此时队列全满
                return false;
            }
            //数据搬移
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }
            tail =  tail - head;
            head = 0;
        }
        array[tail] = item;
        tail++;
        return true;

    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = array[head];
        head++;
        return item;

    }


}
