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
            for (Element element : select) {
                String tekst = element.select("span.notranslate").toString();
                String delim = "(</span>)";
                Scanner scan = new Scanner(tekst).useDelimiter(delim);
                while (scan.hasNext()) {
                    String s = scan.next();
                    lista2.add(s);
                }
            }
            for (String element : lista2) {
                if (!element.startsWith("<span class=")) {
                    if (element.contains("© 2019 WuxiaWorld.")) {
                        return lista3;
                    } else {
                        lista3.add(element);
                    }
                }
            }
        } else {
            throw new RuntimeException("Not exactly ONE iframe found...");
        }
        return lista3;
    }
}

//import java.util.*;
//
//public class Skaner2 {
//
//  public static void main(String[] args) {
//
//    // Zadanie: z napisu (np. jakiegoś dokumentu)
//    // wyróżnić nazwiska, imiona i daty urodzenia
//    // wstawione w odpowiednio opisane pola dokumentu
//
//    String txt = "LNAME: Kowalski FNAME: Jan BORN: 1980-12-01\n" +
//                 "LNAME:  Malinowski FNAME: Stefan BORN: 1950-01-15\n";
//
//    // Separator:
//    // dowolna z nazw pól LNAME: albo FNAME: albo BORN:
//    String delim = "(LNAME:)|(FNAME:)|(BORN:)";
//
//    Scanner scan = new Scanner(txt).useDelimiter(delim);
//    while(scan.hasNext()) {
//      String s = scan.next();
//      // Ponieważ wyłuskane symbole mogą na końcach zawierać białe znaki
//      // usuniemy je za pomocą metody trim() z klasy String
//      s = s.trim();
//      System.out.println( "'" + s + "'");
//    }
//  }
//
//}


