package com.aula.service;

import org.springframework.stereotype.Service;

import com.aula.model.Produto;
import com.aula.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public boolean verificaDisponibilidade(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() && produto.get().getQuantidade() > 0;
    }

    public void diminuirQuantidade(Long id, int quantidade) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);
    }
    
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
