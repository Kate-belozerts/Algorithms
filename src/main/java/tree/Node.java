package tree;

public class Node {
    int value;
    Color color;
    Node leftChild;
    Node rightChild;

    @Override
    public String toString() {
        return "Node: " +
                "value - " + value +
                ", color - " + color +
                ", leftChild - " + leftChild +
                ", rightChild - " + rightChild;
    }
}
