package pl.test.downloaderHtml;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Downloader {
    private List<String> lista = new ArrayList<>();
    private List<String> listHref = new ArrayList<>();
    private Document parse;
    private List<String> lista2 = new ArrayList<>();

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

    public List<String> tekst(String tekst, String select, String clas, String attribute) throws IOException {
        URL url = new URL(tekst);
        Document parse = Jsoup.parse(url, 3000);
        Elements h2Elements = parse.select(select).attr(clas, attribute);
        for (Element h2 : h2Elements) {
            String h2text = h2.text();
            lista.add(h2text);
        }
        return lista;
    }

    public List<String> tekstOpisu(String input) throws IOException, InterruptedException, HttpStatusException {
        URL url = new URL(input);
        load(url);
        //TimeUnit.SECONDS.sleep(1);
        Elements h2Elements = parse.select("p.text");
        //TimeUnit.SECONDS.sleep(1);
        //h2Elements.stream().forEach(s-> System.out.println(s));
        for (Element h2 : h2Elements) {
            //TimeUnit.SECONDS.sleep(1);
            //lista2.add(h2text);
            String h2text = h2.text();
            String hrefText = h2.select("a").first().attr("href");
            System.out.println(h2text + ":::" + hrefText);
            lista2.add(h2text + ":::" + hrefText);
            System.out.println();
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

    public void wyciaghref() throws IOException, InterruptedException {
        URL url = new URL("https://www.wykop.pl/");
        load(url);
        Elements h2Elements = parse.select("h2").attr("a", "href");
        //h2Elements.stream().forEach(s-> System.out.println(s));
        for (Element h2 : h2Elements) {
            String h2text = h2.select("a").first().attr("href");
            listHref.add(h2text);
            System.out.println(h2text);
        }
        for (String element : listHref) {

            tekstOpisu(element);
        }
    }

}
