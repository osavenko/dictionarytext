package ua.savenko.text.model;

import java.util.Set;

public class WordsParameter implements Parameter {

    private Set<String> words;

    public WordsParameter(Set<String> words) {
        this.words = words;
    }

    public Set<String> getWords() {
        return words;
    }
}
