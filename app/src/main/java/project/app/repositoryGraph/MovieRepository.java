package project.app.repositoryGraph;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    @Query("MATCH (a:Movie {title: {0}})-[r]-(b)" + "RETURN r, a, b")
    Movie findByTitle(String title);
    @Query("MATCH p=()-->() RETURN p")
    Collection<Movie> getAllMovies();
    @Query("MATCH (n) detach delete n")
    void deleteAll();
}
