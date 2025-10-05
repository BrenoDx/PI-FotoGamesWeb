/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.Produto;
import com.senac.fotoGamesWeb.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
    
    public Produto cadastrarProduto(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }
    
    
    public List<Produto> listarProduto(){
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }
    
    public Produto getProdutoByID(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }
    public Optional<Produto> buscarPorNome(String nomeProduto) {
        return produtoRepository.buscarProdutoPorNome(nomeProduto);
    }
}
