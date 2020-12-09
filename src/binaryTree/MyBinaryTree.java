package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    private Node head;

    private static class Node {
        private Integer value;
        private Node left;
        private Node right;

        private Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public void add(Integer value) {
        head = addRecursion(head, value);
    }

    private Node addRecursion(Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.value) {
            current.right = addRecursion(current.right, value);
        } else {
            current.left = addRecursion(current.left, value);
        }
        return current;
    }

    public void remove(Integer value) {
        removeRecursion(head, value);
    }

    private Node removeRecursion(Node current, Integer value) {
        if (current == null) {
            return current;
        }
        if (current.value > value) {
            current.left = removeRecursion(current.left, value);
        } else if (current.value < value) {
            current.right = removeRecursion(current.right, value);
        }
        else {
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.value = min();
            current.right = removeRecursion(current.right, current.value);
        }

        return current;
    }

    public boolean contains(Integer val) {
        return find(head, val) != null;
    }

    private Node find(Node head, Integer val) {
        if (head == null) {
            return null;
        }
        if (head.value.equals(val)) {
            return head;
        }
        if (head.value < val) {
            return find(head.right, val);
        }
        return find(head.left, val);
    }

    public Integer max() {
        Node current = head;
        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }

    public Integer min() {
        Node current = head;
        while (current.left != null) {
            current = current.left;
        }

        return current.value;
    }

    public void traverseInOrder() {
        traverseInOrderRecursive(head);
    }

    private void traverseInOrderRecursive(Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.left);
            System.out.print(" " + node.value);
            traverseInOrderRecursive(node.right);
        }
    }

    public void traversePreOrder() {
        traversePreOrderRecursive(head);
    }

    private void traversePreOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrderRecursive(node.left);
            traversePreOrderRecursive(node.right);
        }
    }

    public void traversePostOrder() {
        traversePostOrderRecursive(head);
    }

    private void traversePostOrderRecursive(Node node) {
        if (node != null) {
            traversePostOrderRecursive(node.left);
            traversePostOrderRecursive(node.right);
            System.out.print(" " + node.value);
        }
    }

    public void traverseLevelOrder() {
        if (head == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(head);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
