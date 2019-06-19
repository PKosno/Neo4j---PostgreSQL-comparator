package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Genre;

public interface GenreRepository extends Neo4jRepository<Genre, Long> {
}
