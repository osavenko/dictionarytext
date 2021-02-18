package ua.savenko.text.strategi.transfer;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StrategyTransferBabla extends StrategyTransfer {

    public StrategyTransferBabla(Set<String> words) {
        super(words);
        this.URL = "https://www.babla.ru/%D0%B0%D0%BD%D0%B3%D0%BB%D0%B8%D0%B9%D1%81%D0%BA%D0%B8%D0%B9-%D1%80%D1%83%D1%81%D1%81%D0%BA%D0%B8%D0%B9/";
    }

    protected List<String> parseWord(Document page) {
        List<String> words = new ArrayList<>();
        Elements elements = page.getElementsByClass("sense-group-results");
        if (elements != null) {
            Element firstSenseGroupResults = null;
            try {
                firstSenseGroupResults = elements.get(0);
                Elements anchors = firstSenseGroupResults.getElementsByTag("a");
                for (Element anchor : anchors) {
                    words.add(anchor.text());
                }
            }catch (Exception e){
                System.err.println("пусто");
            }
        }
        return words;
    }
}
