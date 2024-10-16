package com.aula.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "api-product-ms")
public interface ProdutoClient {
    @PostMapping(path ="/produtos/{id}/verificaDisponibilidade",
    			consumes = MediaType.APPLICATION_JSON_VALUE,
    			produces = MediaType.APPLICATION_JSON_VALUE)
    boolean verificaDisponibilidade(@PathVariable Long id);
    
    @PutMapping(path ="/produtos/{id}/diminuir",
    			consumes = MediaType.APPLICATION_JSON_VALUE,
    			produces = MediaType.APPLICATION_JSON_VALUE)
    void decrementarQuantidade(@PathVariable Long id, @RequestParam int quantidade);
}
