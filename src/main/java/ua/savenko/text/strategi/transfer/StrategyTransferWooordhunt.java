package ua.savenko.text.strategi.transfer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class StrategyTransferWooordhunt extends StrategyTransfer {

    public StrategyTransferWooordhunt(Set<String> words) {
        super(words);
        this.URL = "https://wooordhunt.ru/word/";
    }

    @Override
    protected List<String> parseWord(Document page) {
        List<String> words = new ArrayList<>();
        Element element = page.getElementById("content_in_russian");
        if (element != null) {
            Elements tInlineEn = element.getElementsByClass("t_inline_en");
            if (tInlineEn.size() > 0) {
                words = Arrays.asList(tInlineEn.text().split(","));
            }
        }
        return words;
    }
}
