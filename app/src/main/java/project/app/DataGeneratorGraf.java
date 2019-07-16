package project.app;

import project.app.modelGraph.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataGeneratorGraf {
    public DataGeneratorGraf() {
    }

    public List<Movie> generateDataForGraf(int count) throws FileNotFoundException {
        String[] city = new String[50];
        List<Actors> movieActors = new ArrayList<Actors>();
        List<Directors> directors = new ArrayList<Directors>();
        List<Genre> genres = new ArrayList<Genre>();
        List<Movie> movies = new ArrayList<Movie>();
        File file = new File("city.txt");
        Scanner scan = new Scanner(file);
        for (int i = 0; i < 50; i++) {
            city[i] = scan.nextLine();
        }
        Random generator = new Random();
        String[] firstnames = new String[30];
        File file2 = new File("firstnames.txt");
        Scanner scanner2 = new Scanner(file2);
        for (int i = 0; i < 30; i++) {
            firstnames[i] = scanner2.next();
        }
        String[] lastnames = new String[30];
        File file3 = new File("lastnames.txt");
        Scanner scanner3 = new Scanner(file3);
        for (int i = 0; i < 30; i++) {
            lastnames[i] = scanner3.next();
        }
        String[] gender = {"M", "F"};
        String[] country = {"USA", "Anglia", "Polska", "Francja", "Rosja", "Hiszpania", "Szwecja", "Kanada", "Niemcy", "Belgia"};
        for(int i=0; i<count/2;i++)
        {
            Address address = new Address(null, city[generator.nextInt(50)], country[generator.nextInt(10)]);
            Actors actors = new Actors(null, firstnames[generator.nextInt(30)], lastnames[generator.nextInt(30)], gender[generator.nextInt(2)], address, null);
            movieActors.add(actors);
        }
        for(int i=0; i<20;i++)
        {
            Directors director = new Directors(null, firstnames[generator.nextInt(30)], lastnames[generator.nextInt(30)]);
            directors.add(director);
        }
        String[] genre1 = {"Fantasy", "Sci-fi", "Akcji", "Dramat", "Przygodowy", "Obyczajowy", "Komedia", "Horror", "Familijny", "Sensacyjny"};
        for(int i=0; i<10;i++)
        {
            Genre genre = new Genre(null, genre1[generator.nextInt(10)]);
            genres.add(genre);
        }
        String[] languages = {"Angielski", "Polski", "Niemiecki", "Francuski", "Hiszpański"};
        String[] releaseDate = {"2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
        String[] awards = {"Oscar","Zlote maliny","Teen awards","BAFTA","Zloty Glob","Cannes","Orly"};
        String[] titles = new String[100];
        File file4 = new File("movies.txt");
        Scanner scanner4 = new Scanner(file4);
        for (int i = 0; i < 100; i++) {
            titles[i] = scanner4.nextLine();
        }
        List<Languages> languagesList = new ArrayList<>();
        for(int i = 0; i < 5; i++)
        {
            Languages language = new Languages(null, languages[generator.nextInt(5)]);
            languagesList.add(language);
        }
        for(int i=0; i<count;i++)
        {
            List<Genre> newGenres = new ArrayList<>();
            List<Directors> newDirectors = new ArrayList<>();
            List<Actors> newActors = new ArrayList<>();
            for(int j=0;j<3;j++)
            {
                newDirectors.add(directors.get(generator.nextInt(20)));
            }
            for(int g=0;g<3;g++)
            {
                newGenres.add(genres.get(generator.nextInt(10)));
            }
            for(int k=0;k<10;k++)
            {
                newActors.add(movieActors.get(generator.nextInt(count/2)));
            }
            Movie movie= new Movie(null, titles[i], newDirectors, languagesList.get(generator.nextInt(5)), null, newGenres, null, newActors, null, country[generator.nextInt(10)], releaseDate[generator.nextInt(10)], generator.nextInt(30)+100);
            movies.add(movie);

        }
        return movies;
    }
}
