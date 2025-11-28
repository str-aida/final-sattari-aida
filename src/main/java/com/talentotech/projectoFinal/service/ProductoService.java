package com.talentotech.projectoFinal.service;

import com.talentotech.projectoFinal.dto.ProductoDTO;
import com.talentotech.projectoFinal.exception.NotFoundException;
import com.talentotech.projectoFinal.mapper.Mapper;
import com.talentotech.projectoFinal.model.Producto;
import com.talentotech.projectoFinal.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

 //injection de dependencia
  @Autowired
  private ProductoRepository repo;
//.

  //findAll nos devuelve un Producto, pero tenemos ProductoDTO entonces usamos stream y
  //mapper (programación funcional)
  @Override
  public List<ProductoDTO> listarProductos(){
    return repo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public ProductoDTO editarProducto(Long id, ProductoDTO productoDto) {
    Producto prod =repo.findById(id)
        .orElseThrow(()-> new NotFoundException("No encontramos el producto"));
    prod.setNombre(productoDto.getNombre());
    prod.setCategoria(productoDto.getCategoria());
    prod.setCantidad(productoDto.getCantidad());
    prod.setPrecio(productoDto.getPrecio());
    prod.setDescripcion(productoDto.getDescripcion());
    return Mapper.toDTO(repo.save(prod));
  }

  @Override
  public ProductoDTO crearProducto(ProductoDTO productoDto) {
    Producto prod = Producto.builder()
        .nombre(productoDto.getNombre())
        .categoria(productoDto.getCategoria())
        .precio(productoDto.getPrecio())
        .cantidad(productoDto.getCantidad())
        .descripcion(productoDto.getDescripcion())
        .build();
    return Mapper.toDTO(repo.save(prod));
  }

  @Override
  public void eliminarProducto(Long id) {
    if(!repo.existsById(id)){
      throw new NotFoundException("No encontramos el producto");

    }
    repo.deleteById(id);
  }
}
