package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Languages;

public interface LanguagesRDRepository extends JpaRepository<Languages, Long> {
}