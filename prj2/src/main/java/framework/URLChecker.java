package framework;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class URLChecker {

    private static Document doc;

    public boolean openUrl(String urlAddress, int timeout) {
        try {
            doc = Jsoup.connect(urlAddress).timeout(timeout * 1000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.hasText();
    }

    public boolean checkLinkPresentByHref(String href) {
        String cssQuery = "href:contains(" + href + ")";
        Elements elements = doc.select(cssQuery);
        return elements != null;
    }

    public boolean checkLinkPresentByName(String name) {
        Elements elements = doc.select("a:contains(" + name + ")");
        return elements != null;
    }

    public boolean checkPageTitle(String text) {
        String title = doc.title();
        return (title.equals(text));
    }

    public boolean checkPageContains(String text) {
        String cssQuery = "href:contains(" + text + ")";
        Elements elements = doc.select(cssQuery);
        return elements != null;
    }
}
