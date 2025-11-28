package com.talentotech.projectoFinal.controller;


import com.talentotech.projectoFinal.dto.ProductoDTO;
import com.talentotech.projectoFinal.service.IProductoService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

  @Autowired
  private IProductoService productoService;

  @GetMapping
  public ResponseEntity<List<ProductoDTO>> listarProductos() {
    return ResponseEntity.ok(productoService.listarProductos());
  }


  @PostMapping
  public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO dto) {
    ProductoDTO creado = productoService.crearProducto(dto);

    return ResponseEntity.created(URI.create("/api/productos" + creado.getId())).body(creado);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductoDTO> editarProducto (@PathVariable Long id,
      @RequestBody ProductoDTO dto) {
    return ResponseEntity.ok(productoService.editarProducto(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarProducto (@PathVariable Long id) {
    productoService.eliminarProducto(id);
    return ResponseEntity.noContent().build();
  }
}
