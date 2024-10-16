package com.aula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aula.dto.PedidoDto;
import com.aula.model.Pedido;
import com.aula.service.PedidoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/pedidos",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {
    private final PedidoService pedidoService;

    
    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoDto pedidoDto) {
        Pedido pedido = pedidoService.create(pedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Pedido> confirmar(@PathVariable Long id) {
        pedidoService.confirmarPedido(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Pedido> cancelar(@PathVariable Long id) {
        pedidoService.cancelarPedido(id);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
