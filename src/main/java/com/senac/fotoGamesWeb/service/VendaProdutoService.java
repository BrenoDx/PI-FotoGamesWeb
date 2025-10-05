/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.VendaProduto;
import com.senac.fotoGamesWeb.repository.VendaProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class VendaProdutoService {
    @Autowired
    VendaProdutoRepository vendaprodutoRepository;
    
    public VendaProduto cadastrar(VendaProduto vendaProduto){
        vendaprodutoRepository.save(vendaProduto);
        return vendaProduto;
    }
    
    public List<VendaProduto> listar(){
        List<VendaProduto> lista = vendaprodutoRepository.findAll();
        return lista;
    }
}
