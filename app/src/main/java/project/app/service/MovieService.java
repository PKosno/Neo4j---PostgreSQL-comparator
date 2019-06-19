package project.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.app.modelGraph.*;
import project.app.repositoryGraph.MovieRepository;

import java.util.Collection;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository repository;
    public Collection<Movie> getAll() {
        return repository.getAllUsers();
    }
}