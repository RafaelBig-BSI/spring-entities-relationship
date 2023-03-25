package bigeschi.com.projeto.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bigeschi.com.projeto.onetomany.models.Comentario;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
    
}
