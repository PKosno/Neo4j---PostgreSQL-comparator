package project.app.repositoryRD;

import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Tags;

public interface TagsRDRepository extends JpaRepository<Tags, Long> {
}