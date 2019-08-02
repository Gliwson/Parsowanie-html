package pl.test;

import pl.test.downloaderHtml.DownloaderHtml;
import pl.test.downloaderHtml.ReaderTranslator;
import pl.test.patch.Pliki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ReaderTranslator ReaderTranslator = new ReaderTranslator();
        DownloaderHtml downloaderHtml = new DownloaderHtml();
        Pliki pliki = new Pliki();
        List<String> tekst = new ArrayList<>();
        downloaderHtml.wyciagHref("https://www.wykop.pl/");


//        List<String> list = ReaderTranslator.tekst2("");
//        tekst.addAll(list);
//        pliki.writerFiles(tekst);
//        tekst.clear();
    }
}


