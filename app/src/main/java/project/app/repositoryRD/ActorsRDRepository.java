package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Actors;

public interface ActorsRDRepository extends JpaRepository<Actors, Long> {

}