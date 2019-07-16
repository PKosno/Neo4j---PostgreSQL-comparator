package project.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;
import project.app.modelGraph.*;
import project.app.repositoryGraph.*;
import project.app.service.GraphService;
import project.app.service.PostgreService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@SpringBootApplication
@EnableAutoConfiguration
public class AppApplication implements CommandLineRunner {

	@Autowired
	GraphService graphService;
	@Autowired
	PostgreService postgreService;
	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);
	}

	public void run(String[] args) throws FileNotFoundException {
		//save();
		Scanner scanner = new Scanner(System.in);
		int k;
		do
		{
			System.out.println("Wybierz opcję do wykonania. 1 - Operacja na bazie grafowej, 2 - Operacja na bazie PostgreSQL, 3 -wyjście");
			k = scanner.nextInt();
			switch(k)
			{
				case 1: operateOnGraph(); break;
				case 2: operateOnDatabase(); break;
				default: break;
			}
			k =4;
		}while(k != 3);
	}
	public void operateOnGraph() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		int k;
		do
		{
			System.out.println("Wybierz opcję do wykonania. 1 - Zapis, 2 - Aktualizuj, 3 - Odczyt, 4 - Usuń, 5 - Wyjście");
			 k = scanner.nextInt();
			switch(k)
			{
				case 1: graphService.createGraph(); break;
				case 2: graphService.updateGraph(); break;
				case 3: graphService.readGraph(); break;
				case 4: graphService.deleteGraph(); break;
				default: break;
			}
		}while(k != 5);
	}
	public void operateOnDatabase() throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in);
		int k;
		do
		{
			System.out.println("Wybierz opcję do wykonania. 1 - Zapis, 2 - Aktualizuj, 3 - Odczyt, 4 - Usuń, 5 - Wyjście");
			k = scanner.nextInt();
			switch(k)
			{
				case 1: postgreService.create(); break;
				case 2: postgreService.update(); break;
				case 3: postgreService.read(); break;
				case 4: postgreService.delete(); break;
				default: break;
			}


		}while(k != 5);
	}
}
