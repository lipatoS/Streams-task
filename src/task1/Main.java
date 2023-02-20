package task1;


import utils.Contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        getOutput(findNames(getNames()));
    }

    public static Stream<String> getNames() {
        String path = Contacts.BASE_URL + "names.txt";
        try {
            return Files.lines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Stream<String> findNames(Stream<String> names) {
        return names.filter(str -> str.startsWith("Г"));
    }

    private static void getOutput(Stream<String> stream) {
        AtomicInteger cnt = new AtomicInteger(0);
        stream.forEach(name ->
                System.out.println(cnt.incrementAndGet() + ") " + name));
    }
}
