/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author breno
 */
@RestController
public class APIController {

    @Autowired
    ClienteService clienteService;
    @Autowired
    ProdutoService produtoService;
    @Autowired
    VendaService vendaService;
    @Autowired
    EstoqueService estoqueService;
    @Autowired
    VendaProdutoService vendaprodutoService;

    @PostMapping("/cadastrarCliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        var clienteNovo = clienteService.cadastrarCliente(cliente);
        return new ResponseEntity<>(clienteNovo, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarProduto")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        System.out.print(produto);
        var produtoNovo = produtoService.cadastrarProduto(produto);
        return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarEstoque")
    public ResponseEntity<Estoque> cadastrarEstoque(@RequestBody Estoque estoque) {
        var estoqueNovo = estoqueService.cadastrarEstoque(estoque);
        return new ResponseEntity<>(estoqueNovo, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarVenda")
    public ResponseEntity<Venda> cadastrarVenda(@RequestBody Venda venda) {
        var novaVenda = vendaService.cadastrarVenda(venda);
        return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
    }

    @PostMapping("/cadastrarVP")
    public ResponseEntity<VendaProduto> cadastrarVP(@RequestBody VendaProduto vp) {
        int produtoId = vp.getProduto().getId();
        Produto produtoGerenciado = produtoService.getProdutoByID(produtoId);
        vp.setProduto(produtoGerenciado);
        var novoVp = vendaprodutoService.cadastrar(vp);
        return new ResponseEntity<>(novoVp, HttpStatus.CREATED);
    }

    @GetMapping("/listarCliente")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> lista = clienteService.listarCliente();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/listarVendaProduto")
    public ResponseEntity<List<VendaProduto>> listarVP() {
        List<VendaProduto> lista = vendaprodutoService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/listarCliente/{id}")
    public ResponseEntity<Cliente> listarId(@PathVariable Integer id) {
        Cliente cliente = clienteService.getClienteByID(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/listarProduto")
    public ResponseEntity<List<Produto>> listarProduto() {
        List<Produto> lista = produtoService.listarProduto();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/listarVenda")
    public ResponseEntity<List<Venda>> listarVenda() {
        List<Venda> lista = vendaService.listarVenda();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/listarEstoque")
    public ResponseEntity<List<Estoque>> listarEstoque() {
        List<Estoque> lista = estoqueService.listarEstoque();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
