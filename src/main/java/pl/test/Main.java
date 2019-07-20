package pl.test;

import pl.test.downloaderHtml.Downloader;
import pl.test.patch.Pliki;

import java.io.IOException;
import java.util.List;



public class Main {
    private static List<String> tekst;

    public static void main(String[] args) throws IOException, InterruptedException {
        Downloader downloader = new Downloader();
        //tekst = downloader.tekst("https://www.wykop.pl/","h2","a","href");
         downloader.wyciaghref();
//        Pliki pliki = new Pliki();
//        pliki.nextFiles();
//        pliki.writerFiles(tekst);




    }
}


