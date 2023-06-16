package com.example.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class Controller {

@FXML
    private TextField timeForTownTalksField;
    @FXML
    private TextField longDistanceCallTimeField;
    @FXML
    private TextField startRangeField;
    @FXML
    public TextField endRangeField;
    @FXML
    private TextField IDField;
    @FXML
    public TextField surnameField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField middlenameField;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField timeForTown;
    @FXML
    private TextField phoneID;

    @FXML
    private TextArea resultText;
    @FXML
    private Label welcomeText;


    String filename = "PhoneNumbers";
    File file = new File();


    PhoneManager phoneManager;

    ArrayList<Phone> phoneList = new ArrayList<>();




    public void initialize() {
        phoneList.add(new Phone(1, "Ivanov", "Ivan", "Ivanovich", 12345, 15.55f, 8.12f));
        phoneList.add(new Phone(2, "Petrov", "Petro", "Petrovich", 67890, 5.33f, 12.37f));
        phoneList.add(new Phone(3, "Sidorov", "Sidor", "Sidorovich", 54321, 18.49f, 3.04f));
        phoneList.add(new Phone(4, "Kovalev", "Vitaliy", "Ivanovich", 98765, 9.26f, 6.41f));
        phoneList.add(new Phone(5, "Kovalenko", "Olena", "Petrovna", 13579, 12.58f, 4.03f));
        phoneManager = new PhoneManager(phoneList);
    }

    //1
    //Відомості про абонентів, у яких час міських розмов перевищує заданий
    @FXML
    private void timeLocalButton(ActionEvent event) {
        resultText.clear();
        float threshold = Float.parseFloat(timeForTownTalksField.getText());
        List<Phone> phones = phoneManager.getPhonesWithExcessiveLocalCallTime(Float.parseFloat(timeForTownTalksField.getText()));
        System.out.printf(phones.toString());
        System.out.printf(phoneManager.phoneList.toString());
        if (phones.isEmpty() ) {
            resultText.setText("Немає абонентів з перевищеним часом міських розмов aбо спробуйте ще раз.");
        } else {
            for (Phone phone : phones) {
               resultText.appendText(phone.getSurname() + " " + phone.getName() + " " + phone.getMiddlename() + " "+ phone.getTimeForTownTalks()+"\n");
           }

        }
    }

//2
    //Відомості про абонентів, які користувались міжміським зв'язком
    @FXML
    private void distanceCommunication (ActionEvent event){
resultText.clear();
        List<Phone> phones =phoneManager.getPhonesWithInternationalCall();
        for (Phone phone : phones) {
            resultText.appendText(phone.getSurname() + " " + phone.getName() + " " + phone.getMiddlename() + ", хвилини: "+ phone.getLongDistanceCallTime()+"\n");
        }
    }

//3
    //Відомості про абонентів чий номер рахунку знаходиться у вказаному діапазоні
    public void rangeButton(ActionEvent actionEvent) {
        resultText.clear();
        int startRange = Integer.parseInt(startRangeField.getText());
        int endRange = Integer.parseInt(endRangeField.getText());
        List<Phone> phoneListInRange = phoneManager.getAccountNumber(startRange, endRange);
        if (phoneListInRange.isEmpty()) {
            resultText.setText("Немає абонентів у вказаному діапазоні");
        } else {
            for (Phone phone : phoneListInRange) {
                resultText.appendText(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename() + ", номер: " + phone.getAccountNumber() + "\n");
            }
        }
    }

    //4
    //Список абонентів, впорядкованих за номером рахунку
    @FXML
    private void listOfSubs(ActionEvent actionEvent) {
        resultText.clear();
        List<Phone> sortedList = phoneManager.sortByAccountNumber();
        if (sortedList.isEmpty()) {
            resultText.setText("Немає даних для відображення");
        } else {
            for (Phone phone : sortedList) {
                resultText.appendText(phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename() + ": " + phone.getAccountNumber() + "\n");
            }
        }
    }

//5
//Додати абонента
    public void addPhoneButton(ActionEvent actionEvent) {
        resultText.clear();
        int ID = Integer.parseInt(IDField.getText()); // Отримання значення ID з текстового поля
        String surname = surnameField.getText(); // Отримання значення прізвища з текстового поля
        String name = nameField.getText(); // Отримання значення імені з текстового поля
        String middlename = middlenameField.getText(); // Отримання значення по батькові з текстового поля
        int accountNumber = Integer.parseInt(accountNumberField.getText()); // Отримання значення номеру рахунку з текстового поля
        float timeForTownTalks = Float.parseFloat(timeForTown.getText()); // Отримання значення часу міських розмов з текстового поля
        float longDistanceCallTime = Float.parseFloat(longDistanceCallTimeField.getText()); // Отримання значення часу міжміських розмов з текстового поля
        // Виклик методу addPhoneList з екземпляром PhoneManager
        phoneManager.addPhoneList(ID, surname, name, middlename, accountNumber, timeForTownTalks, longDistanceCallTime);

        file.saveFile(phoneList, filename);
        resultText.appendText("Абонент доданий до списку.");
    }

    //6
    //Вилучити абонента
    public void removeButton(ActionEvent actionEvent) {
        resultText.clear();
        int ID = Integer.parseInt(phoneID.getText()); // Отримання ідентифікатора абонента з текстового поля
        phoneManager.removePhoneList(ID); // Виклик методу для вилучення абонента
        file.saveFile(phoneList, filename);
        resultText.appendText("Абонент вилучений зі списку");
    }

    //7
    //Показати всіх абонентів

    public void showSubscribers(ActionEvent actionEvent){
        resultText.clear();
            // Зчитування об'єкта ArrayList з бінарного файлу
            List<Phone> readPhoneList = file.readFile(filename);
         // Вивід зчитаного списку абонентів
        if (readPhoneList != null) {
            for (Phone phone : readPhoneList) {
                resultText.appendText( phone.getID() + " " + phone.getSurname() + " " + phone.getName() + " "
                        + phone.getMiddlename() + " " + phone.getAccountNumber() + " " + phone.getTimeForTownTalks()+ " " + phone.getLongDistanceCallTime()+"\n");

            }
        }
    }



}




