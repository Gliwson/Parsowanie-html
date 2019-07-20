package pl.test.patch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Pliki {
    private Path sciezka;
    private int number;

    public void files(String patchIn) throws IOException {
        sciezka = Paths.get(patchIn);
        Files.newBufferedWriter(sciezka, StandardOpenOption.CREATE_NEW);
    }

    public void writerFiles(List<String> tekst){
        int size = tekst.size();
        try (BufferedWriter writer = Files.newBufferedWriter(sciezka, StandardOpenOption.APPEND)) {
            for (int i = 0; i < size; i++) {
                writer.write(tekst.get(i));
                writer.newLine();
            }
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void nextFiles() throws IOException {
        number++;
        String sciezkaNext = "src/sda" + number +".txt";
        files(sciezkaNext);
    }
}
