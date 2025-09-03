package com.trabalhogil.sistema_doacao.repository;

import com.trabalhogil.sistema_doacao.model.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {
    List<OrdemDeServico> findByStatus(String status);
}