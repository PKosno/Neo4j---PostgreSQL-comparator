package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Tags;

public interface TagsRepository extends Neo4jRepository<Tags, Long> {
}
