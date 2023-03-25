package bigeschi.com.projeto.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepositorio alunoRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @GetMapping("/")
    public String rota()
    {
        return "API de alunos em execução.";
    }

    @GetMapping("/listar")
    public Iterable<Aluno> listar()
    {
        return alunoRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestBody Aluno aluno)
    {
        Aluno aux = new Aluno();
        //List<Curso> cursos = new ArrayList<>();
        
        //cursos = aluno.getCursos();
        aux.setAluno(aluno.getAluno());

       // aux.getCursos().addAll(cursos);

        return alunoRepositorio.save(aux);
    }

    @PostMapping("/cadastrar/{cursoId}") //coloca o aluno referente à algum curso.
    public Aluno adicionarAluno(@PathVariable Long cursoId, @RequestBody Aluno alunoRequest)
    {
        Aluno auxAluno = cursoRepositorio.findById(cursoId).map(curso -> {

            Long alunoId = alunoRequest.getCodigo();
            List<Aluno> lista_alunos = new ArrayList<>();

            //Se o aluno já existir
            if(alunoId != null)
            {
                Aluno _aluno = alunoRepositorio.findById(alunoId).get();
                lista_alunos.add(_aluno);

                curso.setAlunos(lista_alunos);
                cursoRepositorio.save(curso);

                return _aluno;
            }
            else
            {
                //Cria um novo aluno
                lista_alunos.add(alunoRequest);
                curso.setAlunos(lista_alunos);

                return alunoRepositorio.save(alunoRequest);
            }
        }).get();

        if(auxAluno != null)
            return auxAluno;
        else
            return null;
    }
}
