package ua.savenko.text.command;

public class ChoicerCommand {

    public static Command getCommand(String text){
        Command command = null;

        switch (Integer.parseInt(text)){
            case 1:
                command = new ConsoleTextReaderCommand();
                break;
            case 2:
                command = new WordsParserFromTextCommand();
                break;
            case 3:
                command = new WordsParserFromInternetCommand();
                break;
            default:
                command = new NullCommand();
        }
        return command;
    }
}
