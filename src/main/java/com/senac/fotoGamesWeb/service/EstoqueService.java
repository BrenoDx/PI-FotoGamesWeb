/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.Estoque;
import com.senac.fotoGamesWeb.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class EstoqueService {
    @Autowired
    EstoqueRepository estoqueRepository;
    
    public Estoque cadastrarEstoque(Estoque estoque){
        return estoqueRepository.save(estoque);
    }
    
    public List<Estoque> listarEstoque(){
        List<Estoque> lista = estoqueRepository.findAll();
        return lista;
    }
}
