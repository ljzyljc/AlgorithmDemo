package com.jackie.algorithmdemo.linkedlist_06;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/24
 */
class LinkedListAlgo {


//   single list reverse
    public static ListNode reverse(ListNode listNode){
        ListNode curr = listNode;
        ListNode pre = null;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

//    the center of linkedlist
    public static ListNode searchCenterListNode(ListNode listNode){
        if (listNode == null){
            return null;
        }
        ListNode quick = listNode;
        ListNode slow = listNode;


        // 注意这里不能写成 quick.next != null && quick.next.next != null
        // 因为 quick可能为null
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;


    }

    // The check of ring
    public static boolean checkRing(ListNode listNode){
        if (listNode == null || listNode.next == null){
            return false;
        }
        ListNode quick = listNode;
        ListNode slow = listNode;

        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow){
                return true;
            }
        }
        return false;
    }

    // merge two ordered linkedlist
    public static ListNode mergeTwoListNode(ListNode first,ListNode sec){

        ListNode soldier = new ListNode(0,null);   //利用哨兵节点简化难度
        ListNode mergeListNode = soldier;
        while (first != null && sec != null){
            if (first.data <= sec.data){
                mergeListNode.next = first;
                first = first.next;

            } else {

                mergeListNode.next = sec;
                sec = sec.next;
            }
            mergeListNode = mergeListNode.next;
        }

        if (first == null){
            mergeListNode.next = sec;
        }
        if (sec == null){
            mergeListNode.next = first;
        }

        return soldier.next;


    }


//    delete reciprocal K listnode
    public static ListNode deleteReciprocalKNode(ListNode listNode,int k){

        if (k == 0){
            return listNode;
        }

        ListNode quick = listNode;
        int tempCount = 0;
        while (quick != null && tempCount < k){
            tempCount++;
            quick = quick.next;
        }
        if (quick == null){
            return listNode;
        }

        ListNode tempNode = listNode;
        while (quick.next != null){
            quick = quick.next;
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;

        return listNode;

    }




    public static void main(String[] args) {

        ListNode five = new ListNode(5,null);
        ListNode four = new ListNode(4,five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode one = new ListNode(1,two);




        //测试，单链表反转
//        printAll(one);
//        ListNode listNode = reverse(one);
//        printAll(listNode);

        //测试，链表的中心点
//        printAll(one);
//        ListNode listNode = searchCenterListNode(one);
//        System.out.println(listNode.data);

        //测试，链表中环的存在
        // 添加一行代码,确保是个环,加上返回true,否则false
        //five.next = one;
//        boolean checkRing = checkRing(one);
//        System.out.println(checkRing);

        //测试，合并两个有序链表
        //添加一个链表
//        ListNode l = new ListNode(51,null);
//        ListNode k = new ListNode(10,l);
//        ListNode j = new ListNode(5,k);
//        ListNode i = new ListNode(3,j);
//        ListNode h = new ListNode(0,i);
//
//        ListNode listNode = mergeTwoListNode(one,h);
//        printAll(listNode);

        //测试，删除倒数第K个元素
//        ListNode listNode = deleteReciprocalKNode(one,2);
//        printAll(listNode);


    }

    private static void printAll(ListNode node){
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }


    public static class ListNode{

        ListNode next;
        int data;

        public ListNode(int value,ListNode next){
            this.data = value;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
