package Homework16;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Except {
    static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {
        createFile(inputData());
    }

    public static String[] inputData() {
        String data;
        System.out.println("Введите через пробел ФИО, дату рождения, номер телефона и пол:");
        data = iScanner.nextLine();
        String[] dataArray = data.split(" ");
        if (dataArray.length != 6) {
            System.out.println("Введено неверное количество информации.");
            return inputData();
        }
        if (checkName(dataArray[0])) {
            System.out.println("Введен неверный формат фамилии.");
            return inputData();
        }
        if (checkName(dataArray[1])) {
            System.out.println("Введен неверный формат имени.");
            return inputData();
        }
        if (checkName(dataArray[2])) {
            System.out.println("Введен неверный формат отчества.");
            return inputData();
        }
        if (checkBirthday(dataArray[3])) {
            System.out.println("Введен неверный формат даты рождения.");
            return inputData();
        }
        if (checkPhoneNumber(dataArray[4])) {
            System.out.println("Введен неверный формат телефона.");
            return inputData();
        }
        if (checkSex(dataArray[5])) {
            System.out.println("Введен неверный формат пола.");
            return inputData();
        }
        return dataArray;
    }

    public static boolean checkName(String data) {
        char[] chars = data.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkBirthday(String data) {
        String[] birthdayArray = data.split("\\.");
        if (birthdayArray.length != 3) {
            return true;
        }
        Integer day;
        Integer month;
        Integer year;
        try {
            day = Integer.parseInt(birthdayArray[0]);
            month = Integer.parseInt(birthdayArray[1]);
            year = Integer.parseInt(birthdayArray[2]);
        } catch (Exception e) {
            return true;
        }
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return true;
        }
        return false;
    }

    public static boolean checkPhoneNumber(String data) {
        try {
            Integer phoneNumber = Integer.parseInt(data);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public static boolean checkSex(String data) {
        if (data.equals("m") || data.equals("f")) {
            return false;
        }
        return true;
    }

    public static void createFile(String [] input) {
        String fileName = input[0] + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(input[0] + " " + input[1] + " " + input[2]+  " " + input[3] + " " + input[4] + " " + input[5] + "\n");
            System.out.println("Запись успешно добавлена");
        } catch (IOException e) {
            System.out.println("Ошибка с записью в файл.");
        }
    }
}
