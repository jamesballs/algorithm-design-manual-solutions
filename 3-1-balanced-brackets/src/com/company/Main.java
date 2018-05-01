package com.company;

public class Main {

    public static void main(String[] args) {
        String brackets = "((())))())))";
        int pointer = BalancedBrackets(brackets);

        System.out.println(brackets);

        if (pointer > -1) {
            for (int i = 0; i < pointer; i++) {
                System.out.print(" ");
            }
            System.out.print("^");
        }
    }

    // Didn't use a stack for this solution as it seemed redundant when you can just use a counter.
    public static int BalancedBrackets(String line) {
        char[] chars = line.toCharArray();
        int brackets = 0;
        int i;

        for (i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                brackets++;
            }
            else if (chars[i] == ')') {
                brackets--;
            }

            if (brackets < 0) {
                return i;
            }
        }

        if (brackets > 0) {
            return i;
        }

        return -1;
    }
}
