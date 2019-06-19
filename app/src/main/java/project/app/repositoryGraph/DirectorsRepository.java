package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Directors;

public interface DirectorsRepository extends Neo4jRepository<Directors, Long> {
}
