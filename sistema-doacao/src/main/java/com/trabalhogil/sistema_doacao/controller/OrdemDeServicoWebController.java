package com.trabalhogil.sistema_doacao.controller;

import com.trabalhogil.sistema_doacao.repository.ClienteRepository;
import com.trabalhogil.sistema_doacao.repository.OrdemDeServicoRepository;
import com.trabalhogil.sistema_doacao.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/os")
public class OrdemDeServicoWebController {

    @Autowired
    private OrdemDeServicoRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

}
