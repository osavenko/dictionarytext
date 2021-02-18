package ua.savenko.text.command;

import ua.savenko.text.model.NullParameter;
import ua.savenko.text.model.Parameter;

public class NullCommand implements Command {

    public Parameter execute(Parameter parameter) {
        System.out.println("NullCommand.execute");
        return new NullParameter();
    }
}
