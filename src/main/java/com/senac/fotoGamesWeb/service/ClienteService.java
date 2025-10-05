/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.fotoGamesWeb.service;

import com.senac.fotoGamesWeb.model.Cliente;
import com.senac.fotoGamesWeb.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author breno
 */
@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
    public Cliente cadastrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }
    
    public List<Cliente> listarCliente(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }
    
    public Cliente getClienteByID(Integer clienteId){
        return clienteRepository.findById(clienteId).orElse(null);
    }
    
}
