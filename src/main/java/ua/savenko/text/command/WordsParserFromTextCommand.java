package ua.savenko.text.command;

import ua.savenko.text.model.Parameter;
import ua.savenko.text.model.TextParameter;
import ua.savenko.text.model.WordsParameter;

import java.util.*;

public class WordsParserFromTextCommand implements Command {

    public Parameter execute(Parameter parameter) {
        String text = ((TextParameter) parameter)
                .getText()
                .replaceAll("[.\"',?!-:;1234567890]", " ");
        Set<String> words = new TreeSet<>();
        StringTokenizer tokenizer = new StringTokenizer(text);
        while (tokenizer.hasMoreElements()){
            words.add(tokenizer.nextToken().toLowerCase());
        }
        return new WordsParameter(words);
    }
}
