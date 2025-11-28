package com.talentotech.projectoFinal.controller;


import com.talentotech.projectoFinal.dto.PedidoDTO;
import com.talentotech.projectoFinal.service.IPedidoService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {


  @Autowired
  private IPedidoService pedidoService;

  @GetMapping
  public ResponseEntity<List<PedidoDTO>> listarPedido() {
    return ResponseEntity.ok(pedidoService.listarPedido());
  }

  /**
   * Crea un pedido usando directamente PedidoDTO en la request (opción simple, sin request separado).
   * Se espera que el DTO traiga la información
   *
   */
  @PostMapping
  public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO dto) {
    PedidoDTO created = pedidoService.crearPedido(dto);
    return ResponseEntity.created(URI.create("/api/ventas/" + created.getId()))
        .body(created);
  }

  @PutMapping("/{id}")
  public PedidoDTO editar(@PathVariable Long id, @RequestBody PedidoDTO dto) {


    return pedidoService.editarPedido(id, dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    pedidoService.eliminarPedido(id);
    return ResponseEntity.noContent().build();
  }


}
