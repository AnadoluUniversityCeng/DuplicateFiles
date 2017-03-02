package ceng.bim208;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.err.println("Usage: java App startingDir...");
            return;
        }
        
        Path startingDir = Paths.get(args[0]);
        RegularFileVisitor visitor = new RegularFileVisitor();
        Files.walkFileTree(startingDir, visitor);
        
        // your codes goes here ...
    }

    private static <K extends Comparable<? super K>, V> Map<K, List<V>> sortByListSize(Map<K, List<V>> map) {
        return map.entrySet()
                .stream()
                .filter((c1) -> c1.getValue().size() > 1)
                .sorted((c1, c2) -> c2.getValue().size() - c1.getValue().size())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
