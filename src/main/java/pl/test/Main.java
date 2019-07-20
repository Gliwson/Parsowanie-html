package pl.test;

import pl.test.downloaderHtml.ReaderTranslator;
import pl.test.patch.Pliki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        ReaderTranslator ReaderTranslator = new ReaderTranslator();
        Pliki pliki = new Pliki();
        List<String> tekst = new ArrayList<>();
        // for (int i = 130; i < 140; i++) {
        List<String> list = ReaderTranslator.tekst2("https://translate.google.pl/translate?sl=en&tl=pl&u=https%3A%2F%2Fwww.noodletowntranslated.com%2Fhail-the-king%2Fhail-the-king-chapter-823-2%2F");
        tekst.addAll(list);
        pliki.writerFiles(tekst);
        tekst.clear();
        // }


    }
}


