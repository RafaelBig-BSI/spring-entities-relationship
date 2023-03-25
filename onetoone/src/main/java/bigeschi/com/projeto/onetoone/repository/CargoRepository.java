package bigeschi.com.projeto.onetoone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bigeschi.com.projeto.onetoone.models.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {
    
}
