package project.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.app.repositoryRD.MovieRDRepository;

@RestController
@RequestMapping("/rdb/movie")
public class MovieRDController {
    @Autowired
    MovieRDRepository movieRDRepository;

}
