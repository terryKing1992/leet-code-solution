package com.terrylmay.leetcode.solution.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
//        System.out.println(isValid("[](){)"));
        System.out.println(isValid("(][(}(])(({]{{){){(]}}}){}))(){(}[{)})[["));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        if (s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) return false;

        Stack<Character> characterStack = new Stack<Character>();
        boolean isValid = true;
        for (char item : s.toCharArray()) {
            switch (item) {
                case '(':
                case '[':
                case '{':
                    characterStack.push(item);
                    break;
                case ')':
                    if ('(' != characterStack.pop().charValue()) {
                        return false;
                    }
                    break;
                case ']':
                    if ('[' != characterStack.pop().charValue()) {
                        return false;
                    }
                    break;
                case '}':
                    if ('{' != characterStack.pop().charValue()) {
                        return false;
                    }
                    break;
            }
        }
        return isValid && characterStack.size() == 0;
    }
}
