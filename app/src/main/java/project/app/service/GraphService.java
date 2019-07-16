package project.app.service;

import javafx.scene.paint.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import project.app.DataGeneratorGraf;
import project.app.modelGraph.Actors;
import project.app.modelGraph.Directors;
import project.app.modelGraph.Movie;
import project.app.repositoryGraph.ActorsRepository;
import project.app.repositoryGraph.AwardsRepository;
import project.app.repositoryGraph.DirectorsRepository;
import project.app.repositoryGraph.MovieRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
@Service
public class GraphService {
    @Autowired
    MovieRepository movierepository;
    @Autowired
    ActorsRepository actorsrepository;
    @Autowired
    AwardsRepository awardsRepository;
    @Autowired
    DirectorsRepository directorsRepository;

    public void createGraph() throws FileNotFoundException {
        StopWatch test = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc stworzonych obiektow");
        int count = scanner.nextInt();
        if(count==1) {
            int c = 0;
            Movie movie = new Movie();
            List<Directors> directors = new ArrayList<Directors>();
            List<Actors> actors = new ArrayList<Actors>();
            System.out.println("Podaj tytul filmu");
            movie.setTitle(scanner.next());
            System.out.println("Podaj rezyserow filmu, 5 - kończy wczytywanie");
            while (c != 5) {
                Directors director = new Directors();
                System.out.println("Podaj imie");
                director.setFirstname(scanner.next());
                System.out.println("Podaj nazwisko");
                director.setLastname(scanner.next());
                directors.add(director);
                System.out.println("Czy koniec?");
                c = scanner.nextInt();
            }
            movie.setDirectors(directors);
            System.out.println("Podaj aktorow filmu, 5 - kończy wczytywanie");
            c = 0;
            while (c != 5) {
                Actors actor = new Actors();
                System.out.println("Podaj imie");
                String name = scanner.next();
                actor.setFirstname(name);
                System.out.println("Podaj nazwisko");
                String surname = scanner.next();
                actor.setLastname(surname);
                actors.add(actor);
                System.out.println("Czy koniec?");
                c = scanner.nextInt();
            }
            movie.setActors(actors);
            System.out.println("Podaj panstwo filmu");
            movie.setCountry(scanner.next());
            System.out.println("Podaj date wydania");
            movie.setReleaseDate(scanner.next());
            System.out.println("Podaj dlugosc filmu");
            movie.setMovieLength(scanner.nextInt());
            test.start();
            movierepository.save(movie);
            test.stop();
            System.out.println("Czas create: "+ test.getTotalTimeSeconds());
        }
        else
        {
            DataGeneratorGraf generator = new DataGeneratorGraf();
            List<Movie> movieList = generator.generateDataForGraf(count);
            test.start();
            for(Movie movie: movieList)
            {
                movierepository.save(movie);
            }
            test.stop();
            System.out.println("Czas create: "+ test.getTotalTimeSeconds());
        }
    }
    public void updateGraph()
    {
        Scanner scanner = new Scanner(System.in);
        StopWatch clock = new StopWatch();
        System.out.println("Podaj tytul filmu");
        Movie movie = movierepository.findByTitle(scanner.next());
        System.out.println("Podaj nowe panstwo filmu");
        movie.setCountry(scanner.next());
        System.out.println("Podaj nowa date wydania");
        movie.setReleaseDate(scanner.next());
        System.out.println("Podaj nowa dlugosc filmu");
        movie.setMovieLength(scanner.nextInt());
        clock.start();
        movierepository.save(movie);
        clock.stop();
        System.out.println("Czas update: "+ clock.getTotalTimeSeconds());

    }
    public void deleteGraph() throws FileNotFoundException {
        StopWatch clock = new StopWatch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - usun wybrana ilosc filmow, inna liczba - usun caly graf");
        int d = scanner.nextInt();
        if(d == 1) {
            System.out.println("Podaj ilosc filmow do usuniecia");
            int count = scanner.nextInt();
            if (count == 1) {
                System.out.println("Podaj tytul filmu");
                Movie movie = movierepository.findByTitle(scanner.next());
                clock.start();
                movierepository.delete(movie);
                clock.stop();
                System.out.println("Czas delete: "+ clock.getTotalTimeSeconds());
            } else {
                Collection<Movie> movies = movierepository.getAllMovies();
                ArrayList<Movie> copy = new ArrayList<Movie>(movies);
                clock.start();
                for (int i = 0; i < count; i++) {
                    Movie movie = movierepository.findByTitle(copy.get(i).getTitle());
                    movierepository.delete(movie);
                }
                clock.stop();
                System.out.println("Czas delete: "+ clock.getTotalTimeSeconds());
            }
        } else
        {
            clock.start();
            movierepository.deleteAll();
            clock.stop();
            System.out.println(clock.getTotalTimeSeconds());
        }
    }
    public void readGraph() {
        StopWatch clock = new StopWatch();
        List<Directors> directors;
        List<Actors> actors;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ilosc odczytanych filmów, 1 - wszystkie, inny wybór - podaj wybrany film");
        int count = scanner.nextInt();
        if (count == 1) {
            System.out.println("Lista filmow");
            clock.start();
            Collection<Movie> movies = movierepository.getAllMovies();
            clock.stop();
            for (Movie movie : movies) {
                System.out.println("Tytuł:");
                System.out.println(movie.getTitle());
                System.out.println("Dyrektorzy:");
                directors = movie.getDirectors();
                for (Directors director : directors) {
                    System.out.println(director.getFirstname() + " " + director.getLastname());
                }
                System.out.println("Actorzy:");
                actors = movie.getActors();
                for (Actors actor : actors) {
                    System.out.println(actor.getFirstname() + " " + actor.getLastname());
                }
                System.out.println("Panstwo:");
                System.out.println(movie.getCountry());
                System.out.println("Data wydania:");
                System.out.println(movie.getReleaseDate());
                System.out.println("Dlugosc:");
                System.out.println(movie.getMovieLength());
            }
            System.out.println("Czas read: "+ clock.getTotalTimeSeconds());
        } else
        {
            System.out.println("Podaj tytul filmu");
            String title = scanner.next();
            clock.start();
            Movie movie = movierepository.findByTitle(title);
            clock.stop();
            System.out.println("Tytuł:");
            System.out.println(movie.getTitle());
            System.out.println("Dyrektorzy:");
            directors = movie.getDirectors();
            if(directors != null) {
                for (Directors director : directors) {
                    System.out.println(director.getFirstname() + " " + director.getLastname());
                }
            }
            System.out.println("Actorzy:");
            actors = movie.getActors();
            if(actors != null) {
                for (Actors actor : actors) {
                    System.out.println(actor.getFirstname() + " " + actor.getLastname());
                }
            }
            System.out.println("Panstwo:");
            System.out.println(movie.getCountry());
            System.out.println("Data wydania:");
            System.out.println(movie.getReleaseDate());
            System.out.println("Dlugosc:");
            System.out.println(movie.getMovieLength());
            System.out.println("Czas read: "+ clock.getTotalTimeSeconds());
        }
    }
}
