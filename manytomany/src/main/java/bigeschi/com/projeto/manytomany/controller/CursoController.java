package bigeschi.com.projeto.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigeschi.com.projeto.manytomany.models.Aluno;
import bigeschi.com.projeto.manytomany.models.Curso;
import bigeschi.com.projeto.manytomany.repository.AlunoRepositorio;
import bigeschi.com.projeto.manytomany.repository.CursoRepositorio;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Autowired
    private AlunoRepositorio alunoRepositorio;

    @GetMapping("/")
    public String rota()
    {
        return "API de cursos em execução.";
    }

    @GetMapping("/listar")
    public Iterable<Curso> listar()
    {
        return cursoRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Curso cadastrar(@RequestBody Curso curso)
    {
        Curso aux = new Curso();
        aux.setCurso(curso.getCurso());
        
        return cursoRepositorio.save(aux);
    }

    @PostMapping("/cadastrar/{alunoId}") //coloca o curso referente à algum aluno.
    public Curso adicionarCurso(@PathVariable Long alunoId, @RequestBody Curso cursoRequest)
    {
        Curso auxCurso = alunoRepositorio.findById(alunoId).map(aluno -> {
            
            Long cursoId = cursoRequest.getCodigo();
            List<Curso> lista_cursos = new ArrayList<>();

            //Se o curso já existir
            if(cursoId != null)
            {
                Curso _curso = cursoRepositorio.findById(cursoId).get();
                lista_cursos.add(_curso);

                aluno.setCursos(lista_cursos);
                alunoRepositorio.save(aluno);

                return _curso;
            }
            else
            {
                //Cria um novo curso
                lista_cursos.add(cursoRequest);
                aluno.setCursos(lista_cursos);              

                return cursoRepositorio.save(cursoRequest);
            }
        }).get();

        if(auxCurso != null)
            return auxCurso;
        else
            return null;
    }
}
