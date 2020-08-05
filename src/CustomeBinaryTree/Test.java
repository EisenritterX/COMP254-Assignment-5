// Test Harness
// Created By: George Zhou
// Last Modified: Aug, 5, 2020

package CustomeBinaryTree;
public class Test {
    public static void main(String[] args) {
        CustomBinaryTree myCbt = GenerateBinaryTree();
        // Preorder Test From Root
        myCbt.traversePreOrder(myCbt.root);
        System.out.println();
        // Inorder Test From Root
        myCbt.traverseInOrder(myCbt.root);
        System.out.println();
        // Postorder Test From Root
        myCbt.traversePostOrder(myCbt.root);
        System.out.println();

        // Node Search Test
        System.out.println(myCbt.containsNode(4));
        System.out.println(myCbt.root.search(4));
        CustomNode testNode =myCbt.root.search(4);
        CustomNode testNode2 =myCbt.root.search(9);

        // Test Case for middle node
        System.out.println("This is test case for middle node");
        // Preorder Test From Root
        myCbt.traversePreOrder(testNode);
        System.out.println();
        // Inorder Test From Root
        myCbt.traverseInOrder(testNode);
        System.out.println();
        // Postorder Test From Root
        myCbt.traversePostOrder(testNode);
        System.out.println();

        // Test Case for end node
        System.out.println("This is test case for end node");
        // Preorder Test From Root
        myCbt.traversePreOrder(testNode2);
        System.out.println();
        // Inorder Test From Root
        myCbt.traverseInOrder(testNode2);
        System.out.println();
        // Postorder Test From Root
        myCbt.traversePostOrder(testNode2);
        System.out.println();
    }

    private static CustomBinaryTree GenerateBinaryTree(){
        CustomBinaryTree cbt = new CustomBinaryTree();
        cbt.add(6);
        cbt.add(4);
        cbt.add(8);
        cbt.add(3);
        cbt.add(5);
        cbt.add(7);
        cbt.add(9);
        return cbt;
    }
}
