package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;
import ua.savenko.text.model.PathParameter;
import ua.savenko.text.util.ConsoleUtilites;

public class ConsoleTextReaderCommand implements Command {

    public Parameter execute(Parameter parameter) {
        System.out.print("Введите полный путь к вайлу:");
        //String filePath = ConsoleUtilites.readText();
        String filePath = "d:\\text.txt";
        TextReaderCommand command = new TextReaderCommand();
        return command.execute(new PathParameter(filePath));
    }
}
