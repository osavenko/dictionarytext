package ua.savenko.text.strategi.transfer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class StrategyTransfer {

    protected String URL;
    protected Set<String> words;

    protected StrategyTransfer(Set<String> words) {
        this.words = words;
    }

    protected Document getDocument(String word) throws IOException {
        Document document = Jsoup.connect(this.URL + word)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .get();
        //System.out.println(this.URL + word);
        return document;
    }

    public Map<String, List<String>> parseInInternet() {
        Map<String, List<String>> pears = new HashMap<>();
        try {
            for (String word : words) {
                Document page = getDocument(word);
                List<String> translationsList = parseWord(page);
                pears.put(word, translationsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pears;
    }

    protected abstract List<String> parseWord(Document page);
}
