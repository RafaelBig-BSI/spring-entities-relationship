package bigeschi.com.projeto.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigeschi.com.projeto.onetoone.models.Colaborador;
import bigeschi.com.projeto.onetoone.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping("/listar")
    public Iterable<Colaborador> listar()
    {
        return colaboradorRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public Colaborador cadastrar(@RequestBody Colaborador colaborador)
    {
        return colaboradorRepository.save(colaborador);
    }
}
