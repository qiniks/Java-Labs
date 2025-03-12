import java.util.Map;

public class Dictionary {
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("{" + entry.getKey() + ":" + entry.getValue() + "}");
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
        printMap(map);
    }
}