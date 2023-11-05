package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

import javax.crypto.spec.PSource;

public class Main {

    public static void main(String[] args) throws IOException {

        String json
                = String.join(" ",
                Files.readAllLines(
                        Paths.get("./resources/package.json"),
                        StandardCharsets.UTF_8)
        );

        Search s = new Gson().fromJson(json, Search.class);

        if (s != null) {
            List<Filme> filmes = s.getFilmes();

            if (filmes != null && !filmes.isEmpty()) {
                for (Filme f : filmes) {


                    System.out.println("Title: " + f.getTitle());
                    System.out.println("Year: " + f.getYear());
                    System.out.println("imdbID: " + f.getImdbID());
                    System.out.println("Type: " + f.getType());
                    System.out.println("Poster: " + f.getPoster());
                    System.out.println();
                }
            } else {
                System.out.println("Filme nao encontrado");
            }
        } else {
            System.out.println("JSON inválido ou vazio");
        }

    }
}
