package com.terrylmay.leetcode.solution.easy;

import com.terrylmay.leetcode.solution.easy.common.ListNode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode leftNode = new ListNode(1);
        leftNode.next = new ListNode(2);
        leftNode.next.next = new ListNode(6);

        ListNode rightNode = new ListNode(1);
        rightNode.next = new ListNode(3);
        rightNode.next.next = new ListNode(5);

        ListNode result = mergeTwoLists(leftNode, rightNode);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode rootListNode = new ListNode(0);
        ListNode dumpListNode = rootListNode;

        ListNode currentLeftNode = l1;
        ListNode currentRightNode = l2;

        while (currentLeftNode != null || currentRightNode != null) {

            int leftValue = currentLeftNode != null ? currentLeftNode.val : Integer.MIN_VALUE;
            int rightValue = currentRightNode != null ? currentRightNode.val : Integer.MIN_VALUE;

            if (currentLeftNode == null) {
                currentRightNode = currentRightNode.next;
                dumpListNode.next = new ListNode(rightValue);
                dumpListNode = dumpListNode.next;
                continue;
            }

            if (currentRightNode == null) {
                currentLeftNode = currentLeftNode.next;
                dumpListNode.next = new ListNode(leftValue);
                dumpListNode = dumpListNode.next;
                continue;
            }

            if (leftValue < rightValue) {
                currentLeftNode = currentLeftNode.next;
                dumpListNode.next = new ListNode(leftValue);
            } else {
                currentRightNode = currentRightNode.next;
                dumpListNode.next = new ListNode(rightValue);
            }

            dumpListNode = dumpListNode.next;
        }

        return rootListNode.next;
    }
}
