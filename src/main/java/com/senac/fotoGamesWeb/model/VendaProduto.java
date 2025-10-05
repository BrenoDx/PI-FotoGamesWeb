/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author breno
 */
@Entity
@Table(name = "venda_produto")
@Data
public class VendaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Identificador único.

    private double valor_total; // Valor total da venda

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda; // Chave estrangeira venda

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto; // Chave estrageira produto
}
