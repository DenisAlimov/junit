import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        System.out.println("Телефонная книга: ");

        addGroupsAndContacts(phoneBook);

        realization(phoneBook);

        phoneBook.printPhoneBook();

        System.out.println("Введите номер для поиска контакта: ");

        System.out.println(phoneBook.getContact(sc.nextLine()));
    }

    public static void addGroupsAndContacts(PhoneBook phoneBook) {

        while (true) {
            System.out.println("Введите название группы контактов, или 'end': ");
            String groupName = sc.nextLine();
            if (groupName.equals("end")) break;
            phoneBook.addGroup(groupName);
        }

        while (true) {
            System.out.println("Введите номер контакта, или 'end': ");
            String number = sc.nextLine();
            if (number.equals("end")) break;
            System.out.println("Введите имя контакта: ");
            String name = sc.nextLine();
            System.out.println("Укажите группы контакта через пробел");
            String group = sc.nextLine();
            phoneBook.addContact(number, name, group);
        }
    }

    public static void realization(PhoneBook phoneBook) {
        phoneBook.addGroup("Семья");
        phoneBook.addGroup("Друзья");
        phoneBook.addGroup("Работа");
        phoneBook.addContact("+7-777-77-77", "Иванов Иван Иванович", "Семья");
        phoneBook.addContact("+7-888-88-88", "Петров Петр Петрович", "Друзья Работа");
        phoneBook.addContact("+7-999-99-99", "Сидоров Сидор Сидорович", "Работа");
    }
}