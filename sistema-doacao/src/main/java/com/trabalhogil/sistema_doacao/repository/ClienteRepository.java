package com.trabalhogil.sistema_doacao.repository;
import com.trabalhogil.sistema_doacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}