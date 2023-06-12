package hash;

public class Mapa<K, V> {
    Node<K, V>[] nodes;
    private int size = 16;

    public Mapa() {
        this.nodes = new Node[size];
    }

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>();
        newNode.value = value;
        newNode.key = key;
        int hash = Math.abs(key.hashCode()) & size - 1;
        Node<K, V> current = nodes[hash];
        while (current != null) {
            if (current.key == key) {
                V temp = current.value;
                current.value = value;
                return temp;
            }
            current = current.nextNode;
        }
        newNode.nextNode = nodes[hash];
        nodes[hash] = newNode;
        return null;
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode()) % size;
        Node<K, V> node = nodes[hash];
        while (node != null) {
            if (node.value instanceof String) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            } else {
                if (node.key == key) {
                    return node.value;
                }
            }
            node = node.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        int hash = Math.abs(key.hashCode()) % size;
        Node<K, V> current = nodes[hash];
        Node<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                V temp = current.value;
                if (previous == null) {
                    nodes[hash] = current.nextNode;
                } else if (current.nextNode == null) {
                    previous.nextNode = null;
                } else previous.nextNode = current.nextNode;
                return temp;
            }
            previous = current;
            current = current.nextNode;
        }
        return null;
    }

    public int size() {
        int count = 0;
        if (nodes != null) {
            for (Node<K, V> node : nodes) {
                if (node != null) count++;
            }
        }
        return count;
    }

    public V replace(K key, V value) {
        int hash = Math.abs(key.hashCode()) & size - 1;
        Node<K, V> current = nodes[hash];
        while (current != null) {
            if (current.key.equals(hash)) {
                current.value = value;
                return current.value;
            }
            current = current.nextNode;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = Math.abs(key.hashCode()) & size - 1;
        if (nodes[hash] != null) return true;
        else return false;
    }

    public boolean containsValue(V value) {
        for (Node<K, V> node : nodes) {
            if (node != null && node.value == value) return true;
        }
        return false;
    }
}
