package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Reviews;

public interface ReviewsRDRepository extends JpaRepository<Reviews, Long> {
}