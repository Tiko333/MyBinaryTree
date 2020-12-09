package binaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(7);
        tree.add(6);
        tree.add(5);
        tree.add(9);
        tree.add(1);
        tree.add(8);
        tree.add(10);
        tree.add(14);
        tree.add(23);

        System.out.println("Traverse-in-order: The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree");
        tree.traverseInOrder();
        System.out.println("\nTraverse-pre-order: Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree");
        tree.traversePreOrder();
        System.out.println("\nTraverse-post-order: Post-order traversal visits the left subtree, the right subtree, and the root node at the end");
        tree.traversePostOrder();
        System.out.println("\nTraverse-level-order: visits all the nodes of a level before going to the next level");
        tree.traverseLevelOrder();
    }
}
