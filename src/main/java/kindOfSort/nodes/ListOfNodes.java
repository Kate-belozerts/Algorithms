package kindOfSort.nodes;

public class ListOfNodes<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.value = item;
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
}
