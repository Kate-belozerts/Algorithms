package hash;

public class Main {
    public static void main(String[] args) {
        Mapa<Integer, String> mapa = new Mapa<>();
        mapa.put(1, "122");
        mapa.put(2, "12u2");
        mapa.put(3, "1227");
        mapa.put(4, "1224");
        mapa.put(7, "12267");

        mapa.remove(7);
        mapa.replace(3, "new");

        System.out.println(mapa.size());
        System.out.println(mapa.containsKey(2));
        System.out.println(mapa.containsValue("122"));
    }
}
