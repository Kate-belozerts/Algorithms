//package nodes;
//
//public class OneWayNodes<T> {
//    private Node<T> head;
//    private Node<T> tail;
//
//    public void add(T item) {
//        Node<T> newNode = new Node<>();
//        newNode.value = item;
//        if (head != null) {
//            newNode.next = head;
//        }
//        head = newNode;
//    }
//
//    public void add(T item, int index) {
//        if (index > size() || index < 0) throw new ArrayIndexOutOfBoundsException();
//        if (index != 0) {
//            Node<T> currentNode = head;
//            while (index > 1) {
//                index--;
//                currentNode = currentNode.next;
//            }
//            Node<T> newNode = new Node<>();
//            newNode.value = item;
//            Node<T> temp = currentNode.next;
//            currentNode.next = newNode;
//            newNode.next = temp;
//        } else {
//            add(item);
//        }
//    }
//
//    public int size() {
//        Node<T> current = head;
//        int count = 0;
//        while (current != null) {
//            count++;
//            current = current.next;
//        }
//        return count;
//    }
//
//    public T get(int index) {
//        Node<T> current = head;
//        int count = 0;
//        while (count < index) {
//            count++;
//            if (current.next == null) throw new ArrayIndexOutOfBoundsException();
//            current = current.next;
//        }
//        return current.value;
//    }
//
//    public boolean isHave(T item) {
//        Node<T> current = head;
//        while (current != null) {
//            if (current.value == item) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    public int indexOf(T item) {
//        Node<T> current = head;
//        int count = 0;
//        while (current != null) {
//            if (current.value == item) {
//                return count;
//            }
//            count++;
//            current = current.next;
//        }
//        return -1;
//    }
//
//    public void revert() {
//        Node currentNode = head;
//        while (currentNode != null) {
//            Node next = currentNode.next;
//            Node previous = currentNode.previous;
//            currentNode.next = previous;
//            currentNode.previous = next;
//            if (previous == null) {
//                tail = currentNode;
//            }
//            if (next == null) {
//                head = currentNode;
//            }
//            currentNode = next;
//        }
//    }
//}
