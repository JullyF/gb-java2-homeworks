package lesson3homework;

import java.util.*;

public class PhonebookV3 {
    // Вариант 3. После просмотра разбора домашнего задания. Без дополнительных классов и переопределения методов.

    private static final Map<String, Set<String>> phonebook = new TreeMap<>();

    public static void main(String[] args) {
        createSomeOrganizations();
        get("Правительство РФ");
    }

    private static void createSomeOrganizations() {
        add("Правительство РФ", "8 (800) 200-84-42");
        add("Правительство РФ", "+7 (495) 985-44-44");
        add("Президент", "+7 (495) 606-36-02");
        add("Госдума", "+7 (495) 629-65-04");
        add("Суд", "+7 (495) 606-17-62");
        add("МИД", "+7 (495) 244-34-48");
        add("МИД", "+7 (495) 695-45-45");
        add("МИД", "+7 (495) 695-45-45"); // для проверки вносим дубликат
    }

    private static void add(String name, String phoneNumber) {
        Set<String> phoneNumbers = phonebook.getOrDefault(name, new HashSet<>()); // Я правильно понимаю, что в данном случае
        // этот метод подставит или существующий уже Set из Map, или подставит выражение new HashSet<>()? Т.е. мы получим
        // Set<String> phoneNumbers = new HashSet<>(); ???
        phoneNumbers.add(phoneNumber);
        phonebook.put(name, phoneNumbers);
    }

    private static void get(String organizationName) {
        System.out.println(organizationName + ", контакты: ");
        Iterator<String> it = phonebook.get(organizationName).iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
