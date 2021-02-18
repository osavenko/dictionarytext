package ua.savenko.text.model;

public class TextParameter implements Parameter {

    private String text;

    public TextParameter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
