package lesson3homework;

import java.util.*;

public class PhonebookV2 {
    // Вариант 2. Не уверена, что этот вариант в полном объёме соответствует заданию. Но хотелось попробовать переопределять методы
    // hashCode() и equals(). А также сортировку.
    private static TreeSet<Organization> phonebook;

    public static void main(String[] args) {
        createSomeOrganizations();
        get("МИД");
    }

    private static void get(String organizationName) {
        for (Organization organization : phonebook) {
            if ((organization.getName()).equals(organizationName)) {
                System.out.println(organization);
            } //Тут можно сделать исключение, если не найдено. Или методом обыграть, например, возвращать boolean.
        }
    }

    private static void createSomeOrganizations() {
        //В этом варианте не стала добавлять метод add, т.к. сначала сделала без него, хотела попробовать по-разному коллекции делать.
        // Реализацию метода add можно посмотреть в первом варианте.
        // Часть организаций из массива передала. Просто, чтобы попробовать.
        // И тут выбрала коллекцию с сортировкой - логично же в телефонном справочнике по алфавиту сортировать.
        Organization[] organizationsArray = {
                new Organization("Правительство РФ", "8 (800) 200-84-42"),
                new Organization("Правительство РФ", "+7 (495) 985-44-44"),
                new Organization("Президент", "+7 (495) 606-36-02"),
                new Organization("Госдума", "+7 (495) 629-65-04")
        };
        phonebook = new TreeSet<>(Arrays.asList(organizationsArray));

        phonebook.add(new Organization("Суд", "+7 (495) 606-17-62"));
        phonebook.add(new Organization("МИД", "+7 (495) 244-34-48"));
        phonebook.add(new Organization("МИД", "+7 (495) 695-45-45"));
        phonebook.add(new Organization("МИД", "+7 (495) 695-45-45")); // для проверки вносим дубликат
    }
}
