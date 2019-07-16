package project.app.repositoryRD;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Awards;


public interface AwardsRDRepository extends JpaRepository<Awards, Long> {
}