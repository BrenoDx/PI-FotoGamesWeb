/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

/**
 *
 * @author breno
 */
@Entity
@Data
@DiscriminatorValue("Jogo")
public class Jogo extends Produto{
    private String plataforma;
    
    @Override
    public String getPlataforma() {
        return plataforma;
    }
}
