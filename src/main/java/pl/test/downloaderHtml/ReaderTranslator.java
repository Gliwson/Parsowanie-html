package pl.test.downloaderHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderTranslator {
    private List<String> lista2 = new ArrayList<>();
    private List<String> lista3 = new ArrayList<>();

    public List<String> tekst2(String url) throws IOException {
        lista2.clear();
        lista3.clear();
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("iframe[name=c]");
        if (elements.size() == 1) {
            Document pageAfterTranslation = Jsoup.connect(elements.first().attr("abs:src")).get();
            Elements select = pageAfterTranslation.select("p").select("span");
            //System.out.println(select);
            for (Element element : select) {
                String tekst = element.select("span.notranslate").toString();
                String delim = "(</span>)";
                Scanner scan = new Scanner(tekst).useDelimiter(delim);
                while (scan.hasNext()) {
                    String s = scan.next();
                   // System.out.println(s);
                    lista2.add(s);
                }
            }
            for (String element : lista2) {
                if (!element.startsWith("<span class=")) {
                    if (element.contains("© 2019")) {//umieszczamy koniec listy
                        return lista3;
                    } else {
                        lista3.add(element);
                        System.out.println(element);
                    }
                }
            }
        } else {
            throw new RuntimeException("Not exactly ONE iframe found...");
        }
        return lista3;
    }
}


