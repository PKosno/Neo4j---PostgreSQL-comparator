package project.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.app.modelGraph.Movie;
import project.app.modelGraph.User;
import project.app.repositoryGraph.MovieRepository;
import project.app.service.MovieService;
import project.app.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping("/")
public class MovieGraphController {

    @Autowired
    MovieRepository movieRepository;

/*
    @RequestMapping(method = RequestMethod.GET)
    public String listStudent(Model model) {
        StopWatch test = new StopWatch();
        test.start();
        Collection<Movie> movies = movieRepository.getAllMovies();
        test.stop();
        model.addAttribute("movies", movies);
        model.addAttribute("time", test.getTotalTimeSeconds());
        return "index";
    } */




}
