package project.app.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.app.modelGraph.Movie;
import project.app.modelGraph.User;
import project.app.service.MovieService;
import project.app.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public Collection<Movie> getAll() {
        return movieService.getAll();
    }
}
