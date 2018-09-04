package com.terrylmay.leetcode.solution.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for (int index = 1; index <= n; index++) {
            String itemString = "";
            int times3 = index % 3;
            int time5 = index % 5;
            if (times3 == 0) {
                itemString = "Fizz";
            }

            if (time5 == 0) {
                itemString = itemString + "Buzz";
            }

            if (times3 != 0 && time5 != 0) {
                itemString = index + "";
            }

            result.add(itemString);
        }
        return result;
    }
}
