package bigeschi.com.projeto.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bigeschi.com.projeto.onetoone.models.Cargo;
import bigeschi.com.projeto.onetoone.repository.CargoRepository;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping("/listar")
    public Iterable<Cargo> listar()
    {
        return cargoRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public Cargo cadastrar(@RequestBody Cargo cargo)
    {
        return cargoRepository.save(cargo);
    }
}
