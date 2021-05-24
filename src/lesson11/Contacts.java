package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {
    private final Map<String, List<String>> addressBook = new HashMap<>();

    void add(String lastName, String phoneNumber) {
        List<String> numbers = addressBook.getOrDefault(lastName, new ArrayList<>());
        numbers.add(phoneNumber);
        addressBook.put(lastName, numbers);
    }

    List<String> get(String lastName) {
        return addressBook.getOrDefault(lastName, new ArrayList<>());
    }
}
