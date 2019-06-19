package project.app.repositoryGraph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import project.app.modelGraph.Address;

public interface AddressRepository extends Neo4jRepository<Address, Long> {

}