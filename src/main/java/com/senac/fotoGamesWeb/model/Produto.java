/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.model;



import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

/**
 *
 * @author breno
 */

@Entity 
@Data 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING) 
@DiscriminatorValue("Base") 
public class Produto {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Identificador único do usuarios
    
    private String nome_produto;
    
    private String fabricante;
    private String categoria; // Informações básicas (Nome, fabricante e categoria)
    private int garantia; // Garantia do produto
    private double valor; // Valor do produto

     public String getPlataforma() {
        return null; // padrão: quem não é Jogo não tem plataforma
    }
     
     public String getCor() {
        return null; // padrão: quem não é Jogo não tem plataforma
    }

}
