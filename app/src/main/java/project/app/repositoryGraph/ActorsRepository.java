package project.app.repositoryGraph;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Actors;

import java.util.Collection;

public interface ActorsRepository extends Neo4jRepository<Actors, Long> {

}
