package tree;

public class RedBlackTree {
    private Node root;

    public boolean addNode(Node node, int value) {
        if (node.value == value) { //нода уже имеет текущее значение, значит создать новую нельзя
            return false;
        } else {
            if (node.value > value) { //если значение ноды больше, чем искомое значение И если есть левый ребенок
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value); //поиск рекурсивно вниз по левому ребенку, если можно, то вернет true
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else { // если ноды не существует, но мы нашли подходящее для нее место, генерируем ноду. (все ноды при создании имеют красный цвет)
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else { // если правый ребенок есть, то рекурсивно можно ли найти место для этого значения
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {  // если правного ребенка нет,то генерируем значение
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap(Node node) { // происходит только тогда, когда у ноды 2 красных ребенка. Они становятся черными, а нода - красной
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild; // эл., кот. будет менять своего родителя
        leftChild.rightChild = node; // левая априори красная. Вместро правого ребенка красной ноды назначаем рутовый эл., с которого мы началии (текущий родитель)
        node.leftChild = betweenChild; // левая становится уже не красная, а промежутчный (между красной и рутовой)
        leftChild.color = node.color; // левый получает цвет своего родителя
        node.color = Color.RED; // сам корень, кот. спустился ниже становится красным
        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node rebalance(Node node) {
        // используется только тогда, когда после нее необходимо выполнить swipe color
        // (всегда правый поворот будет совмещен со свайпом цвета)
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED && // есть правый ребенок красный. левый -черный
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result); // правый поворот и ребалансировка еще раз
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && // есть левый ребенок - красный.
                    // У левого ребенка есть свой левый ребенок и он тоже красный (те 2 красных левых ребенка подряд)
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result); // делаем левый поворот и отделяем левого ребенка от его левого ребенка
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && // и правый и левый дети красые - swipe цвета
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    public boolean add(int value){
        if (root != null){ // если рут уже существует, то создаем новую ноду относительно рута
            boolean result = addNode(root, value);
            root = rebalance(root); // балансируем и ставим рут черным цветом
            root.color = Color.BLACK;
            return result;
        }else {
            root = new Node(); // создаем новую ноду. Т.к. рут, то черную - единственный раз, когда создается новая нода не красная.
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
}
