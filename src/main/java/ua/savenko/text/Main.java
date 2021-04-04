package ua.savenko.text;

import ua.savenko.text.command.*;
import ua.savenko.text.model.*;
import ua.savenko.text.util.ConsoleUtil;

import java.util.stream.Collectors;

public class Main {

    private static Parameter text;
    private static Parameter words;
    private static Parameter pears;

    public static void main(String[] args) {
        String choice = "";
        do {
            ConsoleUtil.printMenu();
            choice = ConsoleUtil.readText();
            if (choice.equals("4")) {
                printState();
            } else if (choice.equals("5")) {
                clearState();
            } else if (!choice.equals("") & !choice.equals("10")) {
                doCommand(choice);
            } else {
                break;
            }
        } while (true);
        System.out.println("До скорой встречи!");
    }

    private static void doCommand(String choice) {
        Command command = ChoicerCommand.getCommand(choice);
        if (command instanceof ConsoleTextReaderCommand) {
            text = command.execute(new NullParameter());
        } else if (command instanceof WordsParserFromTextCommand) {
            if (text != null) {
                words = command.execute(text);
            }
        } else if (command instanceof WordsParserFromInternetCommand) {
            if (words != null) {
                pears = command.execute(words);
            }
        }
    }

    private static void clearState() {
        text = null;
        words = null;
        pears = null;
        System.out.println("Сброшено состояние!");
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
                                .collect(Collectors.joining(", ")) + ')');
            });
        }
    }
}
