package project.app.repositoryRD;


import org.springframework.data.jpa.repository.JpaRepository;
import project.app.modelRD.Address;

public interface AddressRDRepository extends JpaRepository<Address, Long> {
}