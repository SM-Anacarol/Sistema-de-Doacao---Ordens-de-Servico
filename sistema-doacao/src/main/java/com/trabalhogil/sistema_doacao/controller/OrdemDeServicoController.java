package com.trabalhogil.sistema_doacao.controller;

import com.trabalhogil.sistema_doacao.model.Cliente;
import com.trabalhogil.sistema_doacao.model.OrdemDeServico;
import com.trabalhogil.sistema_doacao.model.Tecnico;
import com.trabalhogil.sistema_doacao.repository.ClienteRepository;
import com.trabalhogil.sistema_doacao.repository.OrdemDeServicoRepository;
import com.trabalhogil.sistema_doacao.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/os")
@CrossOrigin(origins = "*")
public class OrdemDeServicoController {

    @Autowired
    private OrdemDeServicoRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @GetMapping
    public List<OrdemDeServico> listarTodos() {
        return osRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeServico> buscarPorId(@PathVariable Long id) {
        return osRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // Criar OS - recebe JSON com descricao, clienteId e opcionalmente tecnicoId
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody CriarOSRequest req) {
        Optional<Cliente> cOpt = clienteRepository.findById(req.clienteId);
        if (cOpt.isEmpty()) return ResponseEntity.badRequest().body("clienteId inválido");

        OrdemDeServico os = new OrdemDeServico();
        os.setDescricao(req.descricao);
        os.setStatus("ABERTA");
        os.setCliente(cOpt.get());
        if (req.quantidadeDoacoes != null && req.quantidadeDoacoes < 0) {
            return ResponseEntity.badRequest().body("quantidadeDoacoes inválida");
        }
        os.setQuantidadeDoacoes(req.quantidadeDoacoes);

        if (req.tecnicoId != null) {
            Optional<Tecnico> tOpt = tecnicoRepository.findById(req.tecnicoId);
            if (tOpt.isEmpty()) return ResponseEntity.badRequest().body("tecnicoId inválido");
            os.setTecnico(tOpt.get());
        }

        OrdemDeServico salvo = osRepository.save(os);
        return ResponseEntity.ok(salvo);
    }

    // Atualizar status da OS
    @PutMapping("/{id}/status")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long id, @RequestBody StatusRequest req) {
        Optional<OrdemDeServico> osOpt = osRepository.findById(id);
        if (osOpt.isEmpty()) return ResponseEntity.notFound().build();
        OrdemDeServico os = osOpt.get();
        os.setStatus(req.status);
        osRepository.save(os);
        // Aqui podemos acionar o Observer mais tarde
        return ResponseEntity.ok(os);
    }



    // Relatório simples por status
    @GetMapping("/status/{status}")
    public List<OrdemDeServico> porStatus(@PathVariable String status) {
        return osRepository.findByStatus(status);
    }

    // Deletar OS
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<OrdemDeServico> osOpt = osRepository.findById(id);
        if (osOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        osRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // DTOs simples como classes estáticas (Jackson mapeia automaticamente)
    public static class CriarOSRequest {
        public String descricao;
        public Long clienteId;
        public Long tecnicoId;
        public Integer quantidadeDoacoes;
    }

    public static class StatusRequest {
        public String status;
    }
}
