package com.terrylmay.leetcode.solution.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("aaaaaaaa"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));

    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int index = 0; index < s.length(); index++) {
            Map<Character, Object> containsCharMap = new HashMap<Character, Object>();
            if (s.length() - index > maxLength) {
                for (int innerIndex = index; innerIndex < s.length(); innerIndex++) {
                    if (containsCharMap.containsKey(s.charAt(innerIndex))) {
                        break;
                    } else {
                        containsCharMap.put(s.charAt(innerIndex), null);
                    }
                }
            }

            maxLength = maxLength > containsCharMap.size() ? maxLength : containsCharMap.size();
        }

        return maxLength;
    }

}
