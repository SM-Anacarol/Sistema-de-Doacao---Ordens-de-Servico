package com.trabalhogil.sistema_doacao.model;

import jakarta.persistence.*;

@Entity
public class OrdemDeServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    // Quantidade de itens/doações vinculadas à OS
    private Integer quantidadeDoacoes = 0;

    private String status; // pode ser "ABERTA" ou "FECHADA"

    // Relação: muitas OS podem estar ligadas a 1 cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Relação: muitas OS podem estar ligadas a 1 técnico
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Integer getQuantidadeDoacoes() {
        return quantidadeDoacoes;
    }

    public void setQuantidadeDoacoes(Integer quantidadeDoacoes) {
        this.quantidadeDoacoes = quantidadeDoacoes;
    }
}
