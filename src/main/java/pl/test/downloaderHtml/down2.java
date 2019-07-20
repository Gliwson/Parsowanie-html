package pl.test.downloaderHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class down2 {
    private List<String> lista = new ArrayList<>();

    public List<String> tekst(String tekst) throws IOException {
        URL url = new URL(tekst);

        Document parse = Jsoup.parse(url, 3000);
        Elements h2Elements = parse.select("p").attr("class", "backtoblog");
        //h2Elements.stream().forEach(s-> System.out.println(s));

        String h3text = parse.select("h3").text();
        lista.add(h3text);
        System.out.println(h3text);
        for (Element h2 : h2Elements) {
            if (h2.text().equalsIgnoreCase("© 2019 WuxiaWorld. All rights reserved")) {
                return lista;
            }
            String h2text = h2.text();
            lista.add(h2text);
            System.out.println(h2text);
        }
        return lista;

    }
}


