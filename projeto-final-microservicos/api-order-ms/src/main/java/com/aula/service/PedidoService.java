package com.aula.service;

import com.aula.dto.PedidoDto;
import com.aula.enums.PedidoStatus;
import com.aula.model.Pedido;
import com.aula.repository.PedidoRepository;
import com.aula.external.ProdutoClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProdutoClient produtoClient;

    public Pedido create(PedidoDto pedidoDto) {
        
        if (produtoClient.verificaDisponibilidade(pedidoDto.produtoId())) {
            
            produtoClient.decrementarQuantidade(pedidoDto.produtoId(), 1);

            
            Pedido pedido = new Pedido();
            pedido.setProdutoId(pedidoDto.produtoId());
            pedido.setEndereco(pedidoDto.endereco());
            pedido.setDataPedido(pedidoDto.dataPedido());
            pedido.setPedidoStatus(PedidoStatus.CRIADO);

            log.info("Pedido criado com sucesso para o produto ID: {}", pedidoDto.produtoId());
            return pedidoRepository.save(pedido);
        } else {
            
            log.error("Produto não disponível para o ID: {}", pedidoDto.produtoId());
            throw new RuntimeException("Produto não disponível");
        }
    }


    public void confirmarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setPedidoStatus(PedidoStatus.CONFIRMADO); 
        pedidoRepository.save(pedido);
    }

    public void cancelarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setPedidoStatus(PedidoStatus.CANCELADO); 
        pedidoRepository.save(pedido);
    }
    
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }
    
    public void deletePedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
        log.info("Pedido com ID: {} foi deletado com sucesso", id);
    }

    
}
