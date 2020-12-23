package com.jackie.algorithmdemo.linkedlist_06;

import org.w3c.dom.Node;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/23
 */
public class LRUSingleLinkedList<T> {

    private int capacity;
    private int DEFAULT_CAPACITY = 10;
    private int length;
    private Node<T> headNode;


    public LRUSingleLinkedList(){
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public void insert(T t){
        Node preNode = findPreNode(t);
        if (preNode != null){
            deleteElemOptim(preNode);
            insertElementAtBegin(t);
        } else { //链表中存在，删除，在插入到头部
            if (length >= this.capacity){
                //删除尾结点
                deleteElemAtEnd();
            }
            insertElementAtBegin(t);
        }

    }

    //链表头部插入节点
    private void insertElementAtBegin(T t){
        //Node next = headNode.next;
        headNode.next = new Node(t,headNode.next);
        length++;
    }

    //删除尾部节点
    private void deleteElemAtEnd(){
        Node ptr = headNode;
        if (ptr.next == null){
            return;
        }

        //倒数第二个节点
        while (ptr.next.next != null){
            ptr = ptr.next;
        }
        ptr.next = null;
        length--;
    }


    //删除preNode节点的下一个元素
    private void deleteElemOptim(Node preNode){
        preNode.next = preNode.next.next;
        length--;
    }

    //找到元素的前一个节点
    public Node findPreNode(T data){
        Node tempNode = headNode;
        while (tempNode.next != null){
            if (data.equals(tempNode.getNext().element)){ //关键代码
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;

    }

    private void printAll(){
        Node node = headNode.getNext();
        while (node != null){
            System.out.println(node.element);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LRUSingleLinkedList<Integer> linkedList = new LRUSingleLinkedList();
        linkedList.insert(0);
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.insert(60);
        linkedList.insert(70);
        linkedList.insert(80);
        linkedList.insert(90);

        linkedList.insert(40);
        linkedList.insert(100);
        linkedList.insert(50);
        linkedList.insert(0);

        linkedList.printAll();
    }




    public class Node<T>{

        public Node(){
            this.next = null;
        }

        public Node(T element){
            this.element = element;
        }

        public Node(T element,Node next){
            this.element = element;
            this.next = next;
        }

        private T element;
        private Node next;

        public void setElement(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

}
