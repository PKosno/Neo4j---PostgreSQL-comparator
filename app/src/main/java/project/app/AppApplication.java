package project.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.app.modelGraph.*;
import project.app.repositoryGraph.MovieRepository;
import project.app.repositoryGraph.UserRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	MovieRepository repository;

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);
	}

	public void run(String[] args) throws FileNotFoundException {
		save();
	}

	public void save() throws FileNotFoundException {
		String[] city = new String[20];
		List<Actors> movieActors = new ArrayList<Actors>();
		List<Directors> directors = new ArrayList<Directors>();
		List<Genre> genres = new ArrayList<Genre>();
		List<Movie> movies = new ArrayList<Movie>();
		fillCity(city);
		fillActors(movieActors, city);
		fillDirectors(directors);
		fillGenres(genres);
		fillMovies(movieActors, directors, genres, movies);
		for(int i=0;i<movies.size(); i++)
		{
			repository.save(movies.get(i));
		}

	}

	public void fillCity(String[] array) throws FileNotFoundException {
		File file = new File("city.txt");
		Scanner scanner = new Scanner(file);
		for (int i = 0; i < 20; i++) {
			array[i] = scanner.nextLine();
		}
	}
	public void fillActors(List<Actors> movieActors, String[] array)
	{
		Random generator = new Random();
		String[] firstnames = {"John", "Sam", "Adam", "Karolina", "Chris", "Dwayne", "Sylwester", "Kit", "Caytlin", "Natalie"};
		String[] lastnames = {"Depp", "Worthington", "Kowalski", "Maciejewisz", "Hemsworth", "Johnson", "Stalone", "Byddy", "Snow", "Portman"};
		String[] gender = {"M", "F"};
		String[] country = {"USA", "Anglia", "Polska", "Francja", "Rosja", "Hiszpania", "Szwecja", "Kanada", "Niemcy", "Belgia"};
		for(int i=0; i<20;i++)
		{
			Address address = new Address(null, array[generator.nextInt(20)], country[generator.nextInt(10)]);
		Actors actors = new Actors(null, firstnames[generator.nextInt(10)], lastnames[generator.nextInt(10)], gender[generator.nextInt(2)], address, null);
		movieActors.add(actors);
		}
	}
	public void fillDirectors(List<Directors> directors)
	{
		Random generator = new Random();
		String[] firstnames = {"John", "Sam", "Adam", "Karolina", "Chris", "Dwayne", "Sylwester", "Kit", "Caytlin", "Natalie"};
		String[] lastnames = {"Cameron", "Mess", "Badley", "Bond", "Hemsworth", "Johnson", "Standalone", "Parker", "Snow", "Portman"};
		for(int i=0; i<10;i++)
		{
			Directors director = new Directors(null, firstnames[generator.nextInt(10)], lastnames[generator.nextInt(10)]);
			directors.add(director);
		}
	}
	public void fillGenres(List<Genre> genres)
	{
		Random generator = new Random();
		String[] genre1 = {"Fantasy", "Sci-fi", "Akcji", "Dramat", "Przygodowy", "Obyczajowy", "Komedia", "Horror", "Familijny", "Sensacyjny"};
		for(int i=0; i<10;i++)
		{
			Genre genre = new Genre(null, genre1[generator.nextInt(10)]);
			genres.add(genre);
		}
	}
	public void fillMovies(List<Actors> movieActors, List<Directors> directors, List<Genre> genres, List<Movie> movies)
	{
		Random generator = new Random();
		String[] country = {"USA", "Anglia", "Polska", "Francja", "Rosja", "Hiszpania", "Szwecja", "Kanada", "Niemcy", "Belgia"};
		String[] languages = {"Angielski", "Polski", "Niemiecki", "Francuski", "Hiszpański"};
		String[] releaseDate = {"2009","2010","2011","2012","2013","2014","2015","2016","2017","2018"};
		String[] awards = {"Oscar","Zlote maliny","Teen awards","BAFTA","Zloty Glob","Cannes","Orly"};
		String[] titles = {"Titanic","Eragon","Wladca pierscieni","Papiez Polak","Avengers","Zielona Mila","Deadpool", "Opowiesci z Narnii",
		"Trzej muszkieterowie", "American Pie"};
		for(int i=0; i<10;i++)
		{
			List<Genre> newGenres = new ArrayList<>();
			List<Directors> newDirectors = new ArrayList<>();
			List<Actors> newActors = new ArrayList<>();
			newDirectors.add(directors.get(generator.nextInt(10)));
			for(int j=0;j<3;j++)
			{
				newGenres.add(genres.get(generator.nextInt(10)));
			}
			for(int k=0;k<8;k++)
			{
				newActors.add(movieActors.get(generator.nextInt(20)));
			}
			Movie movie= new Movie(null, titles[i], newDirectors, new Languages(null, languages[generator.nextInt(5)]), null, newGenres, null, newActors, null, country[generator.nextInt(10)], releaseDate[generator.nextInt(10)], generator.nextInt(30)+100);
			movies.add(movie);
		}

	}
}
