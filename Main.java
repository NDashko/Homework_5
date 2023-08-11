import java.util.*;

class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "Иванов", "499-45-78");
        addContact(phoneBook, "Петров", "499-65-32");
        addContact(phoneBook, "Петров", "495-61-11");
        addContact(phoneBook, "Сидоров", "499-55-55");
        addContact(phoneBook, "Иванов", "495-22-33");
        addContact(phoneBook, "Петров", "495-44-44");

        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Преобразование HashMap в отсортированный список
        List<Map.Entry<String, List<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));

        // Вывод телефонной книги
        for (Map.Entry<String, List<String>> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}