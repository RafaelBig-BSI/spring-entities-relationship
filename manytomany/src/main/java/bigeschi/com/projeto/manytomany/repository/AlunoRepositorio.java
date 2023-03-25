package bigeschi.com.projeto.manytomany.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bigeschi.com.projeto.manytomany.models.Aluno;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {
    
}
