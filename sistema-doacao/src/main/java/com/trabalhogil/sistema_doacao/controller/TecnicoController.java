package com.trabalhogil.sistema_doacao.controller;

import com.trabalhogil.sistema_doacao.model.Tecnico;
import com.trabalhogil.sistema_doacao.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@CrossOrigin(origins = "*")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<Tecnico> listar() {
        return tecnicoRepository.findAll();
    }

    @PostMapping
    public Tecnico criar(@RequestBody Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }
}
