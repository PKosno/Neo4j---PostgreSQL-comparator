package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Directors;

public interface DirectorsRDRepository extends JpaRepository<Directors, Long> {
}