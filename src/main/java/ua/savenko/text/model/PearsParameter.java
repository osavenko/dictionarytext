package ua.savenko.text.model;

import java.util.List;
import java.util.Map;

public class PearsParameter implements Parameter {

    private Map<String, List<String>> pears;

    public PearsParameter(Map<String, List<String>> pears) {
        this.pears = pears;
    }

    public Map<String, List<String>> getPears() {
        return pears;
    }
}
