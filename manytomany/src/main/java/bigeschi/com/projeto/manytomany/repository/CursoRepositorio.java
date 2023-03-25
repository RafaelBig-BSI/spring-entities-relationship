package bigeschi.com.projeto.manytomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bigeschi.com.projeto.manytomany.models.Curso;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long> {
    
}
