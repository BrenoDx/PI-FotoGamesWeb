/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senac.fotoGamesWeb.model.Cliente;
import com.senac.fotoGamesWeb.model.Estoque;
import com.senac.fotoGamesWeb.model.Produto;
import com.senac.fotoGamesWeb.model.Venda;
import com.senac.fotoGamesWeb.model.VendaProduto;
import com.senac.fotoGamesWeb.service.ClienteService;
import com.senac.fotoGamesWeb.service.EstoqueService;
import com.senac.fotoGamesWeb.service.ProdutoService;
import com.senac.fotoGamesWeb.service.VendaProdutoService;
import com.senac.fotoGamesWeb.service.VendaService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author breno
 */
@Controller
public class VendaController {
    @Autowired
    VendaService vendaService;
    @Autowired
    VendaProdutoService vpService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    EstoqueService estoqueService;
    
    
    @GetMapping("/venda")
    public String pagVenda(Model model){
        model.addAttribute("vendaProduto", vpService.listar());
        return "salesListing";
    }
    
    @GetMapping("/venda/formulario")
    public String pagCadastro(){
        return "sale";
    }
    @GetMapping("/venda/produto/{nome}")
    @ResponseBody
    public Produto getProdutoByNome(@PathVariable String nome){
        List<Estoque> lista = estoqueService.listarEstoque();
        Produto produtoEncontrado = new Produto();
        for(Estoque e : lista){
            if(e.getProduto().getNome_produto().equalsIgnoreCase(nome)){
                produtoEncontrado.setId(e.getProduto().getId());
                produtoEncontrado.setNome_produto(e.getProduto().getNome_produto());
                produtoEncontrado.setValor(e.getProduto().getValor());
                return produtoEncontrado;
            }
        }
        return null;
    }
    @PostMapping("/venda/efetuar")
    public String efetuarVenda(@RequestBody Map<String, Object> dadosVenda) {
       try{
           ObjectMapper mapper = new ObjectMapper();
           Venda venda = mapper.convertValue(dadosVenda.get("venda"), Venda.class);
           Cliente cliente = mapper.convertValue(dadosVenda.get("cliente"), Cliente.class);
           List<VendaProduto> vendaProdutos = ((List<?>) dadosVenda.get("vendaProdutos"))
                   .stream()
                   .map(obj -> mapper.convertValue(obj, VendaProduto.class))
                   .collect(Collectors.toList());
           
           
           Cliente clienteCadastrado = clienteService.getClienteByID(cliente.getId());
           if(clienteCadastrado != null){
               venda.setCliente(clienteCadastrado);
               vendaService.cadastrarVenda(venda);
               
               for(VendaProduto vp : vendaProdutos){
                   vp.setVenda(venda);
                   vpService.cadastrar(vp);
               }
           } else {
               venda.setCliente(clienteService.cadastrarCliente(cliente));
               vendaService.cadastrarVenda(venda);
               for(VendaProduto vp : vendaProdutos){
                   vp.setVenda(venda);
                   vpService.cadastrar(vp);
               }
           }
       }catch(Exception e){
           e.printStackTrace();
       }
        
        // 3. Redirecionar
        return "redirect:/venda"; // Redireciona para uma página de sucesso
    }
}
