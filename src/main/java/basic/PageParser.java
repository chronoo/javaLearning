package basic;

import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * PageParser - выводит заголовок страницы и список новых публикаций со ссылками
 */
public class PageParser {
    public static void main(String[] args) {
        String url = PropertyManager.getProperties("src/main/resources/auth.properties").getProperty("url");
        Document doc;

        try {
            doc = Jsoup.connect(url).get();
            System.out.println(doc.title());

            Map<String, String> volumes = getVolumes(doc);
            for (Map.Entry<String, String> volume : volumes.entrySet()) {
                System.out.println(volume.getKey() + " : " + volume.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> getVolumes(Document document) {
        Elements newVolumes = document.select("div.entry-meta > span.entry-date > a");
        Map<String, String> volumes = new HashMap<String, String>();

        for (Element headline : newVolumes) {
            volumes.put(headline.attr("title"), headline.absUrl("href"));
        }

        return volumes;
    }
}