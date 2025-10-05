/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.controller;


import com.senac.fotoGamesWeb.model.Cliente;
import com.senac.fotoGamesWeb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author breno
 */
@Controller
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente")
    public String pagCliente(Model model){
        model.addAttribute("cliente", clienteService.listarCliente());
        return "client";
    }
    
    @GetMapping("/cliente/{id}")
    @ResponseBody
    public Cliente clienteId(@PathVariable int id){
        return clienteService.getClienteByID(id);
    }
}
