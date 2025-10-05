/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.controller;

import com.senac.fotoGamesWeb.model.Acessorio;
import com.senac.fotoGamesWeb.model.Estoque;
import com.senac.fotoGamesWeb.model.Jogo;
import com.senac.fotoGamesWeb.model.Produto;
import com.senac.fotoGamesWeb.service.EstoqueService;
import com.senac.fotoGamesWeb.service.ProdutoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author breno
 */
@Controller
public class EstoqueController {
    @Autowired
    EstoqueService estoqueService;
    @Autowired
    ProdutoService produtoService;
    
    
    @GetMapping("/estoque")
    public String pagEstoque(Model model){
        model.addAttribute("estoque", estoqueService.listarEstoque());
        return "stockListing";
    }
    
    @GetMapping("/estoque/formulario")
    public String pagCadastro(){
        return "stock";
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> buscarPorNome(@PathVariable String nome) {
        Optional<Produto> produto = produtoService.buscarPorNome(nome.trim());

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/estoque/cadastrar")
    public String cadastrarProduto(@RequestParam String tipoProduto, @RequestParam String nomeProduto, @RequestParam int qntd,
            @RequestParam String fabricante, @RequestParam double valor, @RequestParam int garantia, @RequestParam(required = false) String cor,
            @RequestParam(required=false) String plataforma){
            
        Produto produto = new Produto();
        switch(tipoProduto){
            case "Jogo":
                Jogo jogo = new Jogo();
                jogo.setNome_produto(nomeProduto);
                jogo.setCategoria("Jogo");
                jogo.setFabricante(fabricante);
                jogo.setGarantia(garantia);
                jogo.setPlataforma(plataforma);
                jogo.setValor(valor);
                
                produto = jogo;
                break;
             
            case "Acessorio":
                Acessorio acessorio = new Acessorio();
                acessorio.setNome_produto(nomeProduto);
                acessorio.setCategoria("Acessório");
                acessorio.setFabricante(fabricante);
                acessorio.setGarantia(garantia);
                acessorio.setCor(cor);
                acessorio.setValor(valor);
                
                produto = acessorio;
                break;
            
            case "Hardware":
            default:
                
                produto.setNome_produto(nomeProduto);
                produto.setFabricante(fabricante);
                produto.setCategoria("Hardware");
                produto.setValor(valor);
                produto.setGarantia(garantia);
                
                break;
        }
        produtoService.cadastrarProduto(produto);
        
        Estoque estoque = new Estoque();
        estoque.setQuantidade(qntd);
        estoque.setProduto(produto);
        
        estoqueService.cadastrarEstoque(estoque);
        return "redirect:/estoque";    
    }
}

