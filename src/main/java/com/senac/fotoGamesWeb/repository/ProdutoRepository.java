/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.fotoGamesWeb.repository;

import com.senac.fotoGamesWeb.model.Produto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author breno
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    @Query("SELECT p FROM Produto p WHERE p.nome_produto = :nome")
    Optional<Produto> buscarProdutoPorNome(@Param("nome") String nomeProduto);
}
