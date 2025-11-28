package com.talentotech.projectoFinal.service;

import com.talentotech.projectoFinal.dto.ProductoDTO;
import java.util.List;

public interface IProductoService {

  List<ProductoDTO> listarProductos();
  ProductoDTO editarProducto(Long id , ProductoDTO productoDto );
  ProductoDTO crearProducto (ProductoDTO productoDto);
  void eliminarProducto(Long id);

}
