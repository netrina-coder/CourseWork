package com.example.coursework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {

    public static void saveFile(List<Phone> phoneList, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream("PhoneNumbers");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneList);
            oos.close();
            fos.close();
            System.out.println("Об'єкт ArrayList успішно збережений у бінарний файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Phone> readFile(String filename) {
        List<Phone> phoneList = null;
        try {
            FileInputStream fis = new FileInputStream("PhoneNumbers");
            ObjectInputStream ois = new ObjectInputStream(fis);
            phoneList = (ArrayList<Phone>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Об'єкт ArrayList успішно зчитаний з бінарного файлу.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return phoneList;
    }
}