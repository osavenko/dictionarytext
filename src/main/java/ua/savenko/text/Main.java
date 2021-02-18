package ua.savenko.text;

import ua.savenko.text.command.*;
import ua.savenko.text.model.*;
import ua.savenko.text.util.ConsoleUtilites;

import java.util.stream.Collectors;

public class Main {

    private static Parameter text;
    private static Parameter words;
    private static Parameter pears;

    public static void main(String[] args) {
        String choice = "";
        do {
            ConsoleUtilites.printMenu();
            choice = ConsoleUtilites.readText();
            if (choice.equals("4")) {
                printState();
            } else if (choice.equals("4")) {

                System.out.println("Сброшено состояние!");
            } else if (!choice.equals("") & !choice.equals("10")) {
                Command command = ChoicerCommand.getCommand(choice);
                if (command instanceof ConsoleTextReaderCommand) {
                    text = command.execute(new NullParameter());
                } else if (command instanceof WordsParserFromTextCommand) {
                    words = command.execute(text);
                } else if (command instanceof WordsParserFromInternetCommand) {
                    pears = command.execute(words);
                }
            } else {
                break;
            }
        } while (true);
        System.out.println("До скорой встречи!");
    }

    private static void printState() {
        System.out.println("===================");
        System.out.println("Текущий текст: ");
        if (text != null) {
            System.out.println(((TextParameter) text).getText());
        }
        System.out.println("===================");
        System.out.println("Текущий набор слов:");
        if (words != null) {
            ((WordsParameter) words).getWords().stream()
                    .forEach(System.out::println);
        }
        System.out.println("===================");
        System.out.println("Слова с переводом:");
        if (pears != null) {
            ((PearsParameter) pears).getPears().entrySet().stream().forEach(pears -> {
                System.out.println(pears.getKey() +
                        '(' +
                        pears.getValue().stream()
                                .collect(Collectors.joining(", "))+')');
            });
        }
    }
}
