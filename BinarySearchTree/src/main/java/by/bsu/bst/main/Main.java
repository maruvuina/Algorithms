package by.bsu.bst.main;

import by.bsu.bst.creator.BinarySearchTreeCreator;
import by.bsu.bst.entity.AvlTree;
import by.bsu.bst.entity.BinarySearchTree;
import by.bsu.bst.entity.TreeTraversal;
import by.bsu.bst.print.OutputData;
import by.bsu.bst.random.RandomGenerator;

public class Main {
    public static void main(String[] args) {
       RandomGenerator random = new RandomGenerator();
       int []arr = random.generateRandomArray(20);
       OutputData.printArrayData(arr);
       BinarySearchTreeCreator creator = new BinarySearchTreeCreator();
       BinarySearchTree tree = creator.getBinarySearchTreeFromRandomArray(arr);
       System.out.println("Height: " + tree.getHeight());
       int numberToFind = 4;
       System.out.println("Search: " + numberToFind);
       if (tree.search(numberToFind)) {
           System.out.println("YES");
       }
       else {
           System.out.println("NO");
       }

       TreeTraversal traversal = new TreeTraversal(tree.getRoot());
       System.out.println("In order: ");
       traversal.inorderTraversal().forEach(System.out::println);
       System.out.println("*****************************");
       System.out.println("Pre order: ");
       traversal.preorderTraversal().forEach(System.out::println);
       System.out.println("*****************************");
       System.out.println("Post order: ");
       traversal.postorderTraversal().forEach(System.out::println);
       System.out.println("*****************************");
       System.out.println("Level order");
       traversal.levelOrderTraversal().forEach(System.out::println);
       System.out.println("*****************************");

       BinarySearchTree binaryTree = new BinarySearchTree();
       binaryTree.insert(50);
       binaryTree.insert(30);
       binaryTree.insert(70);
       binaryTree.insert(15);
       binaryTree.insert(35);
       binaryTree.insert(37);
       System.out.println("*****************************");
       traversal = new TreeTraversal(binaryTree.getRoot());
       traversal.levelOrderTraversal().forEach(System.out::println);
       binaryTree.delete(30);
       System.out.println("*****************************");
       traversal.levelOrderTraversal().forEach(System.out::println);

        AvlTree avlTree = new AvlTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(8);
        avlTree.insert(9);
        avlTree.insert(10);
        traversal = new TreeTraversal(avlTree.getRoot());
        System.out.println("*****************************");
        traversal.levelOrderTraversal().forEach(System.out::println);
    }
}
