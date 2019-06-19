package project.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.app.modelGraph.*;
import project.app.repositoryGraph.MovieRepository;
import project.app.repositoryGraph.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }
}
