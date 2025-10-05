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
@DiscriminatorValue("Acessorio")
public class Acessorio extends Produto{
    private String cor;
    
    @Override
    public String getCor() {
        return cor;
    }
}
