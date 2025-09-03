package com.trabalhogil.sistema_doacao.repository;
import com.trabalhogil.sistema_doacao.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}