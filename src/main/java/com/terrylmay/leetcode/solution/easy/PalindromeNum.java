package com.terrylmay.leetcode.solution.easy;

public class PalindromeNum {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    static boolean isPalindrome(int x) {
        String value = String.valueOf(x);

        int leftPos = 0;
        int rightPos = value.length() - 1;
        int midPos = value.length() / 2;
        midPos = value.length() % 2 == 0 ? midPos - 1 : midPos;

        while (leftPos <= midPos) {
            if (value.charAt(leftPos++) != value.charAt(rightPos--)) return false;
        }

        return true;
    }
}
