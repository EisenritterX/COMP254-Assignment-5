package CustomeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

// Generic Tree where the node data are comparable
public class CustomBinaryTree<E extends Comparable<E>> {
    CustomNode root;
    int levelCounter  =0;

    int maxDepth (CustomNode root){
        // Tree DNE if root is null
        if (root == null) return 0;

        // Get the depth of the left and right subtree using recursion
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        return (leftDepth>rightDepth)? leftDepth+1:rightDepth+1;
    }

    // Recursive Add Node
    private CustomNode addRecursive(CustomNode current, E value){
        if(current == null) return new CustomNode(value);

        // If value is lesser than the current node, set the left child data to value
        if(value.compareTo((E) current.getData())<0){
            current.setLeft(addRecursive(current.getLeft(),value));
        }
        // If value is greater than the current node, set the right child data to value
        else if(value.compareTo((E)current.getData())>0 ){
            current.setRight(addRecursive(current.getRight(),value));
        }
        else {return current;}
        return current;
    }

    // Base Add Case
    public void  add(E value){
        root = addRecursive(root,value);
    }

    // Search for Node
    private boolean containsNodeRecursive(CustomNode current, E value){
        if(current==null) return false;
        if(value.compareTo((E) current.getData()) == 0)return true;
        // Search Left of less, search right if more
        return (value.compareTo((E) current.getData())<0)?containsNodeRecursive(current.getLeft(),value)
                :containsNodeRecursive(current.getRight(),value);
    }

    // Base Search Case
    public boolean containsNode(E value) {
        return containsNodeRecursive(root,value);
    }

    // Recursive Deletion
    private CustomNode deleteRecursive(CustomNode current, E value){
        if (current==null)  return null;
        if(value == current.getData()){
            // Node to delete found
            // Has no children
            if (current.getLeft() == null && current.getRight() == null) return null;
            // Has only one child
            if (current.getRight()==null) return current.getLeft();
            if (current.getLeft()==null) return current.getRight();
            // Has both children
            E smallestValue = findSmallestValue(current.getRight());
            // set the current to the smallest child
            current.setData(smallestValue);
            // delete the right sub-tree
            current.setRight(deleteRecursive(current.getRight(),smallestValue));
            return current;
        }
        if(value.compareTo((E) current.getData())<0){
            current.setLeft(deleteRecursive(current.getLeft(),value));
            return current;
        }
        current.setRight(deleteRecursive(current.getRight(),value));
        return current;
    }

    // Helper function to find the smallest value
    private E findSmallestValue(CustomNode root){
        return root.getLeft()==null? (E)root.getData():findSmallestValue(root.getLeft());
    }

    //Base Case Delete
    public void delete(E value){
        root = deleteRecursive(root,value);
    }

    //////////////////////////
    // Traversing the Tree  //
    //////////////////////////

    // Depth-First Traversal //

    // In Order Traversal left sub-tree, root, right sub-tree
    public void  traverseInOrder(CustomNode node){
        if(node!=null){
            traverseInOrder(node.getLeft());
            System.out.print("Level "+(maxDepth(root)- maxDepth(node))+": " + node.getData() + "\n");
            traverseInOrder(node.getRight());
        }
    }
    // Pre Order Traversal --> root --> Left Subtree --> Right Subtree
    public void traversePreOrder(CustomNode node){

        if(node!=null){
            System.out.print("Level "+(maxDepth(root)- maxDepth(node))+": " + node.getData() + "\n");
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }

    }
    // Post Order Traversal --> Left Subtree --> Right Subtree  --> root
    public void traversePostOrder(CustomNode node){
        if(node!=null){
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
            System.out.print("Level "+(maxDepth(root)- maxDepth(node))+": " + node.getData() + "\n");
        }
    }
    // Breadth-First Search //
    public void traverseLevelOrder() {
        if (root == null) return;
        // Use Queue ADT to hold all node of each level in order
        Queue<CustomNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            CustomNode node = nodes.remove();
            System.out.print(" " + node.getData());
            if (node.getLeft() != null) nodes.add(node.getLeft());
            if (node.getRight() != null) nodes.add(node.getRight());
        }
    }

    // Get depth of the tree

    // String Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Custom Binary Tree: " +"\n"+root.getData());
        return result.toString();
    }
}
