package com.terrylmay.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class Roman2Int {

    public static Map<Character, Integer> romanMapping = new HashMap<Character, Integer>();

    static {
        romanMapping.put('I', 1);
        romanMapping.put('V', 5);
        romanMapping.put('X', 10);
        romanMapping.put('L', 50);
        romanMapping.put('C', 100);
        romanMapping.put('D', 500);
        romanMapping.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int sum = 0;

        for (int index = 0; index < s.length(); index++) {
            Character character = s.charAt(index);
            int nextIndex = index + 1;
            if (nextIndex < s.length()) {
                Character nextChar = s.charAt(nextIndex);
                if ((character == 'I' && (nextChar == 'X' || nextChar == 'V')) ||
                        (character == 'X' && (nextChar == 'L' || nextChar == 'C')) ||
                        (character == 'C' && (nextChar == 'D' || nextChar == 'M'))) {
                    sum -= romanMapping.get(character);
                    sum += romanMapping.get(nextChar);
                    index++;
                }else {
                    sum += romanMapping.get(s.charAt(index));
                }
            }else {
                sum += romanMapping.get(s.charAt(index));
            }

        }
        return sum;
    }
}
