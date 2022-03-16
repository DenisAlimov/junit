import java.util.*;

public class PhoneBook {
    public Map<String, List<Contact>> phoneBook = new HashMap<>();
    public List<Contact> contacts = new ArrayList<>();

    public void addGroup(String name) {
        phoneBook.put(name, new ArrayList<>());
    }

    public void addContact(String number, String name, String group) {
        String[] groups = group.split(" ");
        for (String squad : groups) {
            contacts = phoneBook.get(squad);
            if (contacts != null) {
                Contact contact = new Contact(name, number);
                contacts.add(contact);
            }
        }
    }

    public void printPhoneBook() {
        System.out.println("Список контактов по группам:");
        for (String key : phoneBook.keySet()) {
            if (!phoneBook.get(key).isEmpty()) {
                System.out.println("Группа " + key);
                for (Contact contact : phoneBook.get(key)) {
                    System.out.println(contact);
                }
            }
        }
    }

    public Contact getContact(String number) {
        for (List<Contact> con : phoneBook.values()) {
            for (Contact cont : con) {
                if (cont.toString(number).equals(number)) return cont;
            }
        }
        return null;
    }
}