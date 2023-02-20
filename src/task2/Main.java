package task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        getOutput(findProductPrice(dataProduct()));

    }

    public static Map<String, Double> dataProduct() {
        Map<String, Double> products = new HashMap<>();
        products.put("apple", 1.99);
        products.put("banana", 2.99);
        products.put("plum", 1.89);
        products.put("orange", 1.49);
        products.put("pear", 2.99);
        products.put("pineapple", 3.14);
        return products;
    }

    private static Map<String, Double> findProductPrice(Map<String, Double> maps) {
        return maps.entrySet().stream().filter(map -> map.getValue() <= 2.00)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void getOutput(Map<String, Double> stream) {
        AtomicInteger cnt = new AtomicInteger(0);
        stream.forEach((key, value) ->
                System.out.println(cnt.incrementAndGet() + ") " + key + ": " + value));
    }
}

