package lesson11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");

        List<String> strArr = new ArrayList<>(Arrays.asList(
                "Masha", "Petya", "Katya", "Sasha", "Dasha",
                "Vova", "Sveta", "Masha", "Sasha", "Oleg",
                "Luda", "Dasha", "Masha", "Nastya", "Vera",
                "Valera", "Artem", "Oleg", "Irina", "Yura"
        ));
        System.out.println("Весь массив: " + strArr);

        Set<String> unicArr = new HashSet<>(strArr);
        System.out.println("Только уникальные значения: " + unicArr);

        Map<String, Integer> sumArr = new HashMap<>();
        for (String s : strArr) {
            int val = sumArr.getOrDefault(s, 0) + 1;
            sumArr.put(s, val);
        }
        System.out.println("Сколько раз встречается каждое слово: " + sumArr);

        System.out.println();
        System.out.println("Задание 2");

        Contacts contacts = new Contacts();

        contacts.add("Pushkin", "+7987654321");
        contacts.add("Pushkin", "+7987654322");
        contacts.add("Gogol", "+7987654323");
        contacts.add("Tolstoy", "+7987654324");
        contacts.add("Tolstoy", "+7987654325");
        contacts.add("Tolstoy", "+7987654326");
        contacts.add("Esenin", "+7987654327");
        contacts.add("Tutchev", "+7987654328");
        contacts.add("Fet", "+7987654329");

        System.out.println("Pushkin: " + contacts.get("Pushkin"));
        System.out.println("Gogol: " + contacts.get("Gogol"));
        System.out.println("Tolstoy: " + contacts.get("Tolstoy"));
        System.out.println("Esenin: " + contacts.get("Esenin"));
        System.out.println("Tutchev: " + contacts.get("Tutchev"));
        System.out.println("Fet: " + contacts.get("Fet"));
    }
}
