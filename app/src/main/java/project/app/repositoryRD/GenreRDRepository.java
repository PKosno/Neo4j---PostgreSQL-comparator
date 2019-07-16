package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Genre;

public interface GenreRDRepository extends JpaRepository<Genre, Long> {
}