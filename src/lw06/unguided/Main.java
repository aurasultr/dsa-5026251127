package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
       BinarySearchTree bst = new BinarySearchTree();
                                    
        while (read.hasNextInt()) {
            int data = read.nextInt();

            if (read.hasNextLine()) {
                bst.insert(data);
            }
        }
        int target = 65;
        boolean result = bst.search(target);

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + result);
        System.out.println("Nodes : " + bst.countNodes());
        System.out.println("Leaves : " + bst.countLeaves());

        read.close();
    }
}