package project.app.repositoryRD;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Movie;


public interface MovieRDRepository extends JpaRepository<Movie, Long> {
    Movie findByTitle(String title);
}