package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(13);
        tree.add(18);
        tree.add(3);
        tree.add(12);
        tree.add(20);
        tree.add(2);
        tree.add(6);
        tree.add(19);
        tree.add(16);

        tree.output();

        System.out.println();

        List<Integer> orderedList = tree.TraverseInOrder(0);

        for (Integer num : orderedList) {
            System.out.println(num);
        }
    }
}
