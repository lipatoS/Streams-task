package task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        getOutput(findTemperatureDays(daysTemperature()));

    }

    public static Map<String, Integer> daysTemperature() {
        Map<String, Integer> days = new HashMap<>();
        days.put("Monday", 8);
        days.put("Tuesday", 10);
        days.put("Wednesday", 11);
        days.put("Thursday", 15);
        days.put("Friday", 12);
        days.put("Saturday", 10);
        days.put("Sunday ", 8);
        return days;
    }

    private static Map<String, Integer> findTemperatureDays(Map<String, Integer> maps) {
        return maps.entrySet().stream().filter(map -> map.getValue() >= 10 && map.getValue() <= 13)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void getOutput(Map<String, Integer> stream) {
        AtomicInteger cnt = new AtomicInteger(0);
        stream.forEach((key, value) ->
                System.out.println(cnt.incrementAndGet() + ") " + key + ": " + value + "°"));
    }
}

