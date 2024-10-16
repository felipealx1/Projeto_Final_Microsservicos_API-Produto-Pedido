package com.aula.dto;

import java.time.LocalDate;
import com.aula.enums.PedidoStatus;
import com.aula.model.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

public record PedidoDto(

		Long id,
		Long produtoId,
		String endereco,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		LocalDate dataPedido,
		PedidoStatus pedidoStatus

		) {

	public PedidoDto(Pedido pedido){
		this(pedido.getId(), pedido.getProdutoId(), pedido.getEndereco(), pedido.getDataPedido(),
				pedido.getPedidoStatus());
	}
	
}
