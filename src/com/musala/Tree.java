package com.musala;

public class Tree {

    private Node root;

    private static class Node {
        Node left;
        int value;
        Node right;
    }

    public void insert(int key) {

        if (root != null) {
            insert(key, root);
        } else {
            root = new Node();
            root.value= key;
        }
    }

    private void insert(int key, Node currentNode) {

        if (key < currentNode.value) {

            if (currentNode.left == null) {
                Node newNode = new Node();
                newNode.value = key;
                currentNode.left = newNode;
            } else {
                insert(key, currentNode.left);
            }
        } else if (key > currentNode.value) {

            if (currentNode.right == null) {
                Node newNode = new Node();
                newNode.value = key;
                currentNode.right = newNode;
            } else {
                insert(key, currentNode.right);
            }
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node currentNode) {

        if (currentNode != null) {
            print(currentNode.left);
            System.out.print(currentNode.value + " ");
            print(currentNode.right);
        }
    }
}
