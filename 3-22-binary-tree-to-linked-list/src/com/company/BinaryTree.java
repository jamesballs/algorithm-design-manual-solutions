package com.company;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree
{
    // Class used for nodes so that trees can be a list of nodes, rather than three lists for
    // data, left indexes and right indexes.
    class Node
    {
        public int data;
        public int left = -1;
        public int right = -1;

        public Node(int d)
        {
            data = d;
        }
    }

    private List<Node> nodes = new ArrayList<Node>();

    // When adding a new node to the tree, we need to add it to the list
    // and then modify the left or right index of its parent so that we know where it is.
    public void add(int item)
    {
        nodes.add(new Node(item));

        // Index of 0 is used as this is the starting index.
        GetLocation(0, nodes.size() - 1);
    }

    // Recursive function that will search the tree in a divide and conquer manner.
    // Once it has found the right place, the right or left index of its parent will be changed to point to the new node.
    private void GetLocation(int index, int nodeIndex)
    {
        // If the new node's data is greater than the node's data that is being assessed...
        if (nodes.get(nodeIndex).data > nodes.get(index).data)
        {
            // If the current node has no right children then the right location is found.
            if (nodes.get(index).right == -1)
            {
                nodes.get(index).right = nodeIndex;
            }
            // If it has right children, recursively find a node that doesn't.
            else
            {
                GetLocation(nodes.get(index).right, nodeIndex);
            }
        }
        // Do the same as above but for when the node's data is less than.
        else if (nodes.get(nodeIndex).data < nodes.get(index).data)
        {
            if (nodes.get(index).left == -1)
            {
                nodes.get(index).left = nodeIndex;
            }
            else
            {
                GetLocation(nodes.get(index).left, nodeIndex);
            }
        }
    }

    // output all the nodes in the tree, including their left and right indexes and data.
    public void output()
    {
        for (Node node : nodes) {
            System.out.println(node.left + "\t" + node.data + "\t" + node.right);
        }
    }

    // Function for in-order traversal.
    public List<Integer> TraverseInOrder(int index)
    {
        // This will recursively add all values in-order to a list.
        List<Integer> nodeValues = new ArrayList<>();

        // If the current node has left children, then keep traversing using recursion.
        if (nodes.get(index).left != -1)
        {
            nodeValues.addAll(TraverseInOrder(nodes.get(index).left));
        }
        nodeValues.add(nodes.get(index).data);
        if (nodes.get(index).right != -1)
        {
            nodeValues.addAll(TraverseInOrder(nodes.get(index).right));
        }

        return nodeValues;
    }
}