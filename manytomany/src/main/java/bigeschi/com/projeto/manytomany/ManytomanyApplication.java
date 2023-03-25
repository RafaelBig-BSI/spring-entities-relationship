package bigeschi.com.projeto.manytomany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bigeschi.com.projeto.manytomany.models.Aluno;
import bigeschi.com.projeto.manytomany.models.Curso;
import bigeschi.com.projeto.manytomany.repository.AlunoRepositorio;
import bigeschi.com.projeto.manytomany.repository.CursoRepositorio;

import java.util.*;

@SpringBootApplication
public class ManytomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner mappingDemo(AlunoRepositorio ar, CursoRepositorio cr) {
		return args -> {

			// Criar um aluno
			Aluno aluno = new Aluno();
			aluno.setAluno("Rafael");

			// Cadastrar na tabela alunos
			ar.save(aluno);

			// Criar três cursos
			Curso c1 = new Curso();
			c1.setCurso("Java - Spring Boot");

			Curso c2 = new Curso();
			c2.setCurso("C# - ASP.NET Core");

			Curso c3 = new Curso();
			c3.setCurso("JS - React");

			// Cadastrar os cursos na tabela cursos
			cr.saveAll(Arrays.asList(c1, c2, c3));

			// Adicionar os primeiro e o terceiro curso no aluno
			aluno.getCursos().addAll(Arrays.asList(c1, c3));

			// Atualizar a lista de cursos do aluno
			ar.save(aluno);
		};
	}*/
}
