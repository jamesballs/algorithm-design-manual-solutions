package com.company;

public class LinkedList {
    private Node[] list;
    private Integer nextFree = 0;
    public int length;
    private Integer start;

    LinkedList(int l) {
        length = l;
        list = new Node[l];

        for (int i = 0; i < l; i++) {
            list[i] = new Node();

            if (i < l - 1 ) {
                list[i].pointer = i + 1;
            }
        }
    }

    public void add(int value) {
        if (nextFree == null) {
            System.out.println("List is full.");
            return;
        }

        list[nextFree].value = value;

        // If there is no start defined, we define the start as being the newly added node.
        if (start == null) {
            Integer temp = list[nextFree].pointer;
            list[nextFree].pointer = null;
            start = nextFree;
            nextFree = temp;
        }
        else {
            Integer p = start;

            // This will make the value we are adding in the starting value and it will change its pointer to whatever used to be the starting value.
            if (value < list[p].value) {
                list[nextFree].pointer = start;
                start = nextFree;
            }
            else {
                boolean placeFound = false;
                while (list[p].pointer != null && !placeFound) {
                    if (value >= list[list[p].pointer].value) {
                        p = list[p].pointer;
                    }
                    else {
                        placeFound = true;
                    }
                }

                Integer temp = nextFree;
                nextFree = list[temp].pointer;
                list[temp].pointer = list[p].pointer;
                list[p].pointer = temp;
            }
        }
    }
}

class Node {
    public Integer value;
    public Integer pointer;
}
