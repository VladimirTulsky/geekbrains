package lesson3;

import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    static Map<String, String> map = new HashMap<>();

    protected static void add (String name, String phone) {
        map.put(phone, name);
    }

    protected static void get (String name) {
        map.forEach((key, value) -> {
            if (value.equals(name)) {
                System.out.println(value + ": " + key);
            }
        });
    }
}