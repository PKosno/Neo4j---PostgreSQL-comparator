package project.app.repositoryGraph;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Movie;

import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

}
