package lesson3homework;

import java.util.*;

public class Phonebook {
    // Вариант 1. Не уверена, что этот вариант в полном объёме соответствует заданию. Но хотелось попробовать переопределять методы
    // hashCode() и equals().
    private static ArrayList<Organization> organizations = new ArrayList<>();
    private static HashMap<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        createSomeOrganizations();
        insertOrganizationsToPhonebook();
        get("Правительство РФ");
    }

    private static void add(String name, String phoneNumber) {
        organizations.add(new Organization(name, phoneNumber));

    }

    private static void get(String organizationName) {
        for (Map.Entry<String, String> phonebook : phonebook.entrySet()) {
            if ((phonebook.getValue()).equals(organizationName)) {
                System.out.println(phonebook.getValue() + ", тел.: " + phonebook.getKey());
            } //Тут можно сделать исключение, если не найдено. Или методом обыграть, например, возвращать boolean.
        }
    }

    private static void insertOrganizationsToPhonebook() {
        for (Organization organization : organizations) {
            phonebook.put(organization.phoneNumber, organization.name);
        }
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
}
