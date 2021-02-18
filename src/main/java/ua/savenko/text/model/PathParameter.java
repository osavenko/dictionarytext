package ua.savenko.text.model;

public class PathParameter implements Parameter {
    private String path;

    public PathParameter(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
