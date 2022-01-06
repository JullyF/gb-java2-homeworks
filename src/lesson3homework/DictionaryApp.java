package lesson3homework;

import java.util.*;

public class DictionaryApp {
    //IDEA предлагает сделать это поле final. А надо ли это делать?
    private static ArrayList<String> dictionary = new ArrayList<>(); // создаю сразу лист, а не простой массив.

    public static void main(String[] args) {
        addWordsToTheDictionary();
        searchDuplicatesAndPrintDictionary();
        System.out.println();
        System.out.println("---- Вариант 2 ----");
        System.out.println();
        makeHashSetAndSearchDuplicates();
        System.out.println();
        System.out.println("---- Вариант 3 ----");
        System.out.println();
        makeHashMapAndCountDuplicates();
    }

    private static void makeHashMapAndCountDuplicates() {
        // Посмотрела этот вариант в разборе домашнего задания. Решила попробовать.
        HashMap<String, Integer> newDictionary2 = new HashMap<>();
        for (String word3 : dictionary) {
            newDictionary2.merge(word3, 1, Integer::sum); // Где можно почитать про такую запись методов (Integer::sum).
            // Хочу понять, как это работает.
        }
        for (Map.Entry<String, Integer> entry : newDictionary2.entrySet()) {
            System.out.printf("%s - встречается в словаре %d раз(а).%n", entry.getKey(), entry.getValue());
        }
    }

    private static void makeHashSetAndSearchDuplicates() {
        //Такой путь: просто скопировать ArrayList в вариант Set, чтобы не было дубликатов слов.
        // Но как оно с точки зрения адекватности использования?
        HashSet<String> newDictionary = new HashSet<>(dictionary);
        for (String word2 : newDictionary) {
            int count2 = 0;
            for (int i = 0; i < dictionary.size(); i++) {
                if (word2.equals(dictionary.get(i))) {
                    count2++;
                }
            }
            System.out.println(word2 + " - встречается в словаре " + count2 + " раз(а).");
        }
    }

    private static void searchDuplicatesAndPrintDictionary() {
        //Странный способ с "удалением зубов через прямую кишку". Но было интересно найти такой путь.
        for (int index = 0; index < dictionary.size(); index++) {
            int count = 0;
            String word = dictionary.get(index);
            for (int i = 0; i < dictionary.size(); i++) {
                if (word.equals(dictionary.get(i))) {
                    count++;
                }
            }

            if (dictionary.indexOf(word) == index) {
                System.out.println(word + " - встречается в словаре " + count + " раз(а).");
            }
        }
    }

    private static void addWordsToTheDictionary() {
        dictionary.add("аквариум");
        dictionary.add("бонбоньерка");
        dictionary.add("аллитерация");
        dictionary.add("дисквалификация");
        dictionary.add("либерализм");
        dictionary.add("аллитерация");
        dictionary.add("аллитерация");
        dictionary.add("жужелица");
        dictionary.add("полемизировать");
        dictionary.add("аллитерация");
        dictionary.add("гуманизм");
        dictionary.add("оранжерея");
        dictionary.add("иллюминация");
        dictionary.add("коврижка");
        dictionary.add("невтерпёж");
        dictionary.add("аллитерация");
        dictionary.add("иллюминация");
        dictionary.add("либерализм");
        dictionary.add("впечатление");
        dictionary.add("репутация");
    }
}
