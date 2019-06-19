package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Awards;

public interface AwardsRepository extends Neo4jRepository<Awards, Long> {

}
