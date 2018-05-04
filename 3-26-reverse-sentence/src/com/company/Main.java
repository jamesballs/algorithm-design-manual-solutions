package com.company;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(ReverseSentence("My name is Chris"));
        long endTime = System.nanoTime();

        System.out.println((endTime - startTime) / 1000000);
    }

    // Function for reversing a sentence.
    public static String ReverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i > -1; i--) {
            sb.append(words[i] + " ");
        }

        return sb.toString();
    }
}
