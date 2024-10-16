package com.aula.dto;

import com.aula.model.Produto;

public record ProdutoDto(
		
		Long id,
		String nome,
		Integer quantidade,
		String descricao,
		Double preco
		
		) {
	
	public ProdutoDto(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getQuantidade(), 
				produto.getDescricao(), produto.getPreco());
	}

}
