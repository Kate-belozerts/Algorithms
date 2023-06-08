package kindOfSort.nodes;

public class Main {
    public static void main(String[] args) {
        ListOfNodes<Integer> integerListOfNodes = new ListOfNodes<>();
        integerListOfNodes.add(1);
        integerListOfNodes.add(2);
        integerListOfNodes.add(3);
        integerListOfNodes.add(4);
        integerListOfNodes.add(5);
        integerListOfNodes.revert();
    }
}
