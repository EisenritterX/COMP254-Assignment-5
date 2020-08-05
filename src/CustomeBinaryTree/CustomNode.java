package CustomeBinaryTree;

// Custom comparable generic node
public class CustomNode<E extends Comparable<E>> {
    // Custom Node Propertiies
    private E data;
    private  CustomNode left;
    private  CustomNode right;

    // Custom Node Constructor
    public CustomNode(E value){
        this.data = value;
        CustomNode left;
        CustomNode right;
    }

    // Data Getter & Setter
    public void setData(E data) {
        this.data = data;
    }
    public E getData() {
        return data;
    }

    // Node Left Property
    public CustomNode getLeft() {
        return left;
    }
    public void setLeft(CustomNode left) {
        this.left = left;
    }

    // Node Right Property
    public CustomNode getRight() {
        return right;
    }
    public void setRight(CustomNode right) {
        this.right = right;
    }

    // Search Node Function
    public  CustomNode search(E value){
        CustomNode result = null;
        if(this.data.compareTo(value)==0) return this;
        if(this.left==null&& this.right == null) return null;
        result=this.right.search(value);
        if(result!= null && result.data.compareTo(value) == 0) return result;
        return this.left.search(value);
    }

    // Display Override
    @Override
    public String toString() {
        return "CustomNode{" +
                "Data =" + data +
                '}';
    }
}

