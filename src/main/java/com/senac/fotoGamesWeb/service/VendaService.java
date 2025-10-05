/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.Venda;
import com.senac.fotoGamesWeb.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class VendaService {
    @Autowired
    VendaRepository vendaRepository;
    
    public Venda cadastrarVenda(Venda venda){
        vendaRepository.save(venda);
        return venda;
    }
    
    public List<Venda> listarVenda(){
        List<Venda> lista = vendaRepository.findAll();
        return lista;
    }
}
