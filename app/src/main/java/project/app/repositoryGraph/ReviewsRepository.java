package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Reviews;

public interface ReviewsRepository extends Neo4jRepository<Reviews, Long> {
}
