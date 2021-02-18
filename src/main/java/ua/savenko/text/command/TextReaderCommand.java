package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;
import ua.savenko.text.model.PathParameter;
import ua.savenko.text.model.TextParameter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextReaderCommand implements Command {
    @Override
    public Parameter execute(Parameter parameter) {
        String text = "";
        String filePath = ((PathParameter) parameter).getPath();
        File file = new File(filePath);
        if (file.exists()) {
            try {
                text = Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Такого файла не существует!");
        }
        return new TextParameter(text);
    }
}
