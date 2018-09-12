package com.terrylmay.leetcode.solution.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{ "flower", "flow", "floo"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        boolean flag = true;
        int index = 1;
        String longestCommonPrefix = "";
        while (flag) {
            if (strs[0].length() > index) {
                String tempPrefix = strs[0].substring(0, index++);
                boolean hasCommonPrefix = true;
                for (int innerIndex = 1; innerIndex < strs.length; innerIndex++) {
                    if (!strs[innerIndex].startsWith(tempPrefix)) {
                        hasCommonPrefix = false;
                        break;
                    }
                }

                if (hasCommonPrefix) {
                    longestCommonPrefix = tempPrefix;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }

        return longestCommonPrefix;
    }
}
