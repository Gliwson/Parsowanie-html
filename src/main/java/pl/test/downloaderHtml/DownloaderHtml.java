package pl.test.downloaderHtml;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloaderHtml {
    private List<String> lista = new ArrayList<>();
    private List<String> listHref = new ArrayList<>();
    private Document parse;
    public List<String> lista2 = new ArrayList<>();

    public List<String> tekst(String tekst, String select) throws IOException {
        URL url = new URL(tekst);
        Document parse = Jsoup.parse(url, 3000);
        Elements h2Elements = parse.select(select);
        for (Element h2 : h2Elements) {
            String h2text = h2.text();
            lista.add(h2text);
        }
        return lista;
    }

    public List<String> tekstOpisu(String inputUrl) throws IOException, InterruptedException {
        URL url = new URL(inputUrl);
        load(url);
        Elements h2Elements = parse.select("p.text");

        for (Element h2 : h2Elements) {
            String h2text = h2.text();
            String hrefText = h2.select("a").first().attr("href");
            //System.out.println(h2text + ":::" + hrefText);
            lista2.add(h2text /*+ ":::" + hrefText*/);
        }
        return lista2;
    }

    private void load(URL url) throws IOException, InterruptedException {
        try {
            parse = Jsoup.parse(url, 3000); //problem
        } catch (HttpStatusException exception) {
            load(url);
        }
    }

    public void wyciagHref(String inputUrl) throws IOException, InterruptedException {
        URL url = new URL(inputUrl);
        load(url);
        Elements h2Elements = parse.select("a[href]");
        //System.out.println(h2Elements);
        for (Element h2 : h2Elements) {
            String h2text = h2.select("a").first().attr("href");
            listHref.add(h2text);
            System.out.println(h2text);
        }
    }
}
