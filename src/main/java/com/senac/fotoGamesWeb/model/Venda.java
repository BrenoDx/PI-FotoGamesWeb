/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author breno
 */
@Entity
@Data
public class Venda {
    private Date data; // Data da venda
    private String form_pagamento; // Forma de pagamento
    
    @Id
    @Column(name="nf")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nf; // Nota Fiscal e como identificador único
    
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente; // Chave estrageira cliente

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaProduto> itens = new ArrayList<>();

    public double getValorTotal() {
        return itens.stream().mapToDouble(VendaProduto::getValor_total).sum();
    }
}
