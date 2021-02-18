package ua.savenko.text.util;

import java.util.Scanner;

public class ConsoleUtilites {

    public static String readText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void printMenu(){
        System.out.println("Выбирите номер пункта меню из списка:");
        System.out.println("1. Читать из файла в текст.");
        System.out.println("2. Парсить слова из текста.");
        System.out.println("3. Парсить(искать) слова из интернета.");
        System.out.println("4. Печать состояние программы.");
        System.out.println("10. Выход.");
        System.out.print("-> ");
    }
}
