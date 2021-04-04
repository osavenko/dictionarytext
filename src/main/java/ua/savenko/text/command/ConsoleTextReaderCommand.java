package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;
import ua.savenko.text.model.PathParameter;

public class ConsoleTextReaderCommand implements Command {

    public Parameter execute(Parameter parameter) {
        System.out.print("Введите полный путь к вайлу:");
        //String filePath = ConsoleUtil.readText();
        String filePath = "d:\\text.txt";
        TextReaderCommand command = new TextReaderCommand();
        return command.execute(new PathParameter(filePath));
    }
}
