package lesson3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SimilarSearch {

    static Map<String, Integer> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    protected static void searchQuantity (String[] mass) {
        for (String s : mass) {
            Integer val = map.getOrDefault(s, 0);
            map.put(s, val + 1);
        }
        map.forEach((key, value) -> System.out.println(key + ", количество: " + value));
    }

    protected static void searchUnique (String[] mass) {
        Collections.addAll(set, mass);
        System.out.println("Уникальные слова " + set);
    }
}