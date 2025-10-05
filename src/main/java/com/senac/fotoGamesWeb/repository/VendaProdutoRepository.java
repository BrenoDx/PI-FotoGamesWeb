/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.fotoGamesWeb.repository;

import com.senac.fotoGamesWeb.model.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author breno
 */
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Integer>{
    
}
