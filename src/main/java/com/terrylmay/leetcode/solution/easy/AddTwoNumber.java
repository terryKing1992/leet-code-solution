package com.terrylmay.leetcode.solution.easy;

public class AddTwoNumber {

    public static void main(String[] args) {

        ListNode leftListNode = new ListNode(2);
        leftListNode.next = new ListNode(4);
        leftListNode.next.next = new ListNode(3);

        ListNode rightListNode = new ListNode(5);
        rightListNode.next = new ListNode(6);
        rightListNode.next.next = new ListNode(4);

        ListNode finalResult = addTwoNumbers(leftListNode, rightListNode);

        while(finalResult != null) {
           System.out.println(finalResult.val);
           finalResult = finalResult.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpListNode = new ListNode(0);
        ListNode leftNextNode = l1, rightNextNode = l2, currentNode = dumpListNode;
        int addToNextSum = 0;

        while (leftNextNode != null || rightNextNode != null) {
            int leftValue = leftNextNode != null ? leftNextNode.val : 0;
            int rightValue = rightNextNode != null ? rightNextNode.val : 0;

            int sumResult = leftValue + rightValue + addToNextSum;
            addToNextSum = sumResult / 10;
            currentNode.next = new ListNode(sumResult % 10);

            if (leftNextNode != null) leftNextNode = leftNextNode.next;
            if (rightNextNode != null) rightNextNode = rightNextNode.next;
            currentNode = currentNode.next;
        }

        if (addToNextSum == 1) {
            currentNode.next = new ListNode(addToNextSum);
        }

        return dumpListNode.next;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
