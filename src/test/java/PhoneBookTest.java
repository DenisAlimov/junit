import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    //Вводные данные для проверки
    PhoneBook pBook = new PhoneBook();
    public static int i = 1;
    final String group = "Семья";
    final String name = "Иванов Иван Иванович";
    final String number = "+7-777-77-77";
    final List<Contact> contacts = new ArrayList<>();
    final Map<String, List<Contact>> phoneBook = new HashMap<>();

    @BeforeAll
    public static void started() {
        System.out.println("Testing started");
    }

    @BeforeEach
    public void startMsg() {
        System.out.println("Test " + i + " started");
    }

    @AfterEach
    public void endMsg() {
        System.out.println("Test " + i + " ended");
        i++;
    }

    @AfterAll
    public static void ended() {
        System.out.println("Testing ended");
    }

    @Test
    public void testGetContact() {
        //arrange
        final Contact expected = new Contact(name, number);

        //act
        pBook.addGroup(group);
        pBook.addContact(number, name, group);
        final Contact result = pBook.getContact(number);

        //assert
      assertEquals(expected, result);
    }

    @Test
    public void testAddGroup() {
        //arrange
        phoneBook.put(group, contacts);

        //act
        pBook.addGroup(group);

        //assert
        assertEquals(phoneBook, pBook.phoneBook);
    }

    @Test
    public void testAddContact() {
        //arrange
        Contact contact = new Contact(name, number);
        contacts.add(contact);
        Contact expected = contacts.get(0);

        //act
        pBook.addGroup(group);
        pBook.addContact(number, name, group);

        //assert
        assertEquals(expected, pBook.contacts.get(0));
    }

    @Test
    public void testAddGroup_null() {
        //arrange
        pBook = null;

        //assert
        assertThrows(NullPointerException.class, () -> pBook.addGroup(group));
    }
}