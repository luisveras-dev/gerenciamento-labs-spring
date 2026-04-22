package com.veras.gerenciamentolabs.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_laboratorios")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;

    @Column(nullable = false, length = 50)
    private String status; // ativo ou em manutenção

    @Column(columnDefinition = "TEXT")
    private String recursos;

    public Laboratorio() {
    }

    public Laboratorio(String nome, Integer capacidade, String status, String recursos) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.status = status;
        this.recursos = recursos;
    }

    public Long getId() { return  id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade;}

    public String getStatus() {return status; }
    public void setStatus(String status) {this.status = status; }

    public String getRecursos() { return recursos; }
    public void setRecursos(String recursos) { this.recursos = recursos; }

}
