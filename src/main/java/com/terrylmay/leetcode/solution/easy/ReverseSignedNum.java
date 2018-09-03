package com.terrylmay.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseSignedNum {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        boolean isNagetive = x < 0;
        List<Integer> dumpList = new ArrayList<Integer>();
        int unsignedNum = Math.abs(x);
        int cutValue = unsignedNum;
        while (cutValue != 0) {
            dumpList.add(cutValue % 10);
            cutValue = cutValue / 10;
        }

        int reverseIndex = dumpList.size() - 1;
        int index = 0;
        int sum = 0;
        for (;reverseIndex >= 0; reverseIndex--) {
            int currentValue = Double.valueOf(dumpList.get(reverseIndex) * Math.pow(10, index)).intValue();
            sum += currentValue;
            if (sum < 0) {
                return 0;
            }
            index++;
        }

        return isNagetive ? -sum : sum;
    }
}
