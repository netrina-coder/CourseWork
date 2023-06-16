package tests;

import com.example.coursework.Phone;
import com.example.coursework.PhoneManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PhoneManagerTest {

    PhoneManager phoneManager;

    @BeforeEach
    void setUp() {
        phoneManager = new PhoneManager();
    }

    // тест першого методу
@Test
public void testGetPhonesWithExcessiveLocalCallTime() {
    ArrayList<Phone> phoneList = new ArrayList<>();
    phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
    phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
    phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
    phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
    phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
     phoneManager = new PhoneManager(phoneList);

    float threshold = 10.0f;
    List<Phone> result1 = phoneManager.getPhonesWithExcessiveLocalCallTime(threshold);

    int expectedSize = 3;
    assertEquals(expectedSize, result1.size());
}


    //тест другого методу
    @Test
    public void testGetPhonesWithInternationalCall() {
        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
        phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));

         phoneManager = new PhoneManager(phoneList);
float longDistanceCallTime= 0.0f;
        List<Phone> result2 = phoneManager.getPhonesWithInternationalCall(longDistanceCallTime);

        ArrayList<Phone> expectedSubset = new ArrayList<>();
        expectedSubset.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        expectedSubset.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        expectedSubset.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        expectedSubset.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
        expectedSubset.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));

        Assertions.assertEquals(expectedSubset, result2);

    }

    //тест третього методу
    @Test
    public void testGetAccountNumber() {
        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
        phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));

         phoneManager = new PhoneManager(phoneList);
        int startRange = 10000;
        int endRange = 90000;

        List<Phone> result = phoneManager.getAccountNumber(startRange, endRange);

        ArrayList<Phone> expectedSubset1 = new ArrayList<>();
        expectedSubset1.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        expectedSubset1.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        expectedSubset1.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        expectedSubset1.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
        Assertions.assertEquals(expectedSubset1, result);
    }
// тест четвертого методу
@Test
public void testSortByAccountNumber() {
    ArrayList<Phone> phoneList = new ArrayList<>();
    phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
    phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
    phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
    phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
    phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
     phoneManager = new PhoneManager(phoneList);

    List<Phone> result = phoneManager.sortByAccountNumber();

    List<Phone> expectedList = new ArrayList<>();
    expectedList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
    expectedList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
    expectedList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
    expectedList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
    expectedList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));


   Assertions.assertEquals(expectedList, result);
}

    // тест п'ятого методу
    @Test
    public void testAddPhoneList() {
        ArrayList<Phone> phoneList = new ArrayList<>();

            phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
            phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
            phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
            phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
            phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
            phoneManager = new PhoneManager(phoneList);

        // Перевірка, чи доданий абонент з'явився в списку
        assertEquals(5, phoneList.size());

        Phone addedPhone = phoneList.get(0);
        assertEquals(1, addedPhone.getID());
        assertEquals("Ivan", addedPhone.getName());
        assertEquals("Ivanov", addedPhone.getSurname());
        assertEquals("Ivanovich", addedPhone.getMiddlename());
        assertEquals(12345, addedPhone.getAccountNumber());
        assertEquals(15.55f, addedPhone.getTimeForTownTalks());
        assertEquals(8.12f, addedPhone.getLongDistanceCallTime());
    }

    //тест шостого методу
    @Test
    public void testRemovePhoneList() {
        ArrayList<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
        phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));

         phoneManager = new PhoneManager(phoneList);
        int IDToRemove = 3;
        phoneManager.removePhoneList(IDToRemove);

        // Перевіряємо, чи абонент був успішно вилучений зі списку
        ArrayList<Phone> expectedPhoneList = new ArrayList<>();

        phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));

        List<Phone> actualPhoneList = new ArrayList<>();

        Assertions.assertEquals(expectedPhoneList, actualPhoneList);
    }


}



