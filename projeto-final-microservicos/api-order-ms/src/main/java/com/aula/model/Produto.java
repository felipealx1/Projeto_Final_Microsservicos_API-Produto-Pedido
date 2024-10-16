package com.aula.model;

import com.aula.dto.ProdutoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int quantidade; 
    private double preco;
    
    public static Produto fromDto(ProdutoDto produtoDto){
    	return new Produto(null, produtoDto.nome(), produtoDto.descricao(), 
    			produtoDto.quantidade(), produtoDto.preco());
    }
    
}
