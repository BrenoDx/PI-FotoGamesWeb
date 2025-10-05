/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.Acesso;
import com.senac.fotoGamesWeb.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class AcessoService {
    
    @Autowired
    AcessoRepository acessoRepository;
    
    public Acesso getAcessoByID(Integer Acesso){
        return acessoRepository.findById(Acesso).orElse(null);
    }
    
}
