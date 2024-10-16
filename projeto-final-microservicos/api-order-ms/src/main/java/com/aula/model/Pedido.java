package com.aula.model;

import java.time.LocalDate;

import com.aula.dto.PedidoDto;
import com.aula.enums.PedidoStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private Long produtoId;
	 
	 private String endereco;

	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	 private LocalDate dataPedido;

	 @Enumerated(EnumType.STRING)
	 private PedidoStatus pedidoStatus;
	 
	 public static Pedido fromDto(PedidoDto pedidoDto) {
		 return new Pedido(null, pedidoDto.produtoId(), pedidoDto.endereco(),
				 pedidoDto.dataPedido(), pedidoDto.pedidoStatus());
	 }
}
