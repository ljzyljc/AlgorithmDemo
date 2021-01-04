package com.jackie.algorithmdemo.queue_09;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/4
 * 关键在于判断队满和队空的条件
 */
class CircleQueue {

    private int head, tail;
    private String[] array;
    private int n;

    public CircleQueue(int capacity) {
        this.n = capacity;
        array = new String[n];
    }

    public boolean enqueue(String item) {
        //队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        array[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = array[head];
        head = (head + 1) % n;
        return item;


    }


}
