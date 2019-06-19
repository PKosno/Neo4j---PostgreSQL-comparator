package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Languages;

public interface LanguagesRepository extends Neo4jRepository<Languages, Long> {
}
