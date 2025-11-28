package com.talentotech.projectoFinal.service;

import com.talentotech.projectoFinal.dto.PedidoDTO;
import com.talentotech.projectoFinal.dto.PedidoProductoDTO;
import com.talentotech.projectoFinal.mapper.Mapper;
import com.talentotech.projectoFinal.model.Pedido;
import com.talentotech.projectoFinal.model.PedidoProducto;
import com.talentotech.projectoFinal.model.Producto;
import com.talentotech.projectoFinal.repository.PedidoRepository;
import com.talentotech.projectoFinal.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements IPedidoService{

  @Autowired
  private PedidoRepository pedidoRepo;
  @Autowired
  private ProductoRepository prodRepo;

  @Override
  public List<PedidoDTO> listarPedido() {

    List<Pedido> pedidos=pedidoRepo.findAll();
    List<PedidoDTO> pedidoDto=new ArrayList<>();

    PedidoDTO dto;
    for(Pedido p : pedidos){
      dto= Mapper.toDTO(p);
      pedidoDto.add(dto);
    }
    return pedidoDto;
  }

  @Override
  public PedidoDTO editarPedido(Long id, PedidoDTO pedidoDto) {
//buscar si el pedido existe para actualizarla

    Pedido v = pedidoRepo.findById(id).orElse(null);
    if (v == null) throw new RuntimeException("No encontramos el pedido");

    if (pedidoDto.getFecha()!=null) {
      v.setFecha(pedidoDto.getFecha());
    }
    if(pedidoDto.getEstado()!=null) {
      v.setEstado(pedidoDto.getEstado());
    }

    if (pedidoDto.getTotal()!=null) {
      v.setTotal(pedidoDto.getTotal());
    }

    pedidoRepo.save(v);

    PedidoDTO ventaSalida = Mapper.toDTO(v);

    return ventaSalida;
  }

  @Override
  public PedidoDTO crearPedido(PedidoDTO pedidoDto) {
    //Validaciones
    if (pedidoDto == null) throw new RuntimeException("pedidoDto es null");
    if (pedidoDto.getDetalle() == null || pedidoDto.getDetalle().isEmpty())
      throw new RuntimeException("Debe incluir al menos un producto");

    //Crear el pedido
    Pedido vent = new Pedido();
    vent.setFecha(pedidoDto.getFecha());
    vent.setEstado(pedidoDto.getEstado());
    vent.setTotal(pedidoDto.getTotal());

    // La lista de detalles
    // --> Acá están los productos
    List<PedidoProducto> detalles = new ArrayList<>();
    Double totalCalculado = 0.0;

    for (PedidoProductoDTO detDTO : pedidoDto.getDetalle()) {
      // Buscar producto por id (tu detDTO usa id como id de producto)
      Producto p = prodRepo.findByNombre(detDTO.getNombreProd()).orElse(null);
      if (p == null)
      {throw new RuntimeException("Producto no encontrado: " + detDTO.getNombreProd());}

      //Crear detalle
      PedidoProducto detallePedido = new PedidoProducto();
      detallePedido.setProd(p);
      detallePedido.setPrecio(detDTO.getPrecio());
      detallePedido.setCantidad(detDTO.getCantidadProd());
      detallePedido.setPedido(vent);

      detalles.add(detallePedido);
      totalCalculado = totalCalculado+(detDTO.getPrecio()*detDTO.getCantidadProd());

    }
    //Seteamos la lista de detalle de Venta
    vent.setDetalle(detalles);

    //guardamos en la BD
    vent = pedidoRepo.save(vent);

    //Mapeo de salida
    PedidoDTO ventaSalida = Mapper.toDTO(vent);

    return ventaSalida;
  }

  @Override
  public void eliminarPedido(Long id) {
    Pedido p = pedidoRepo.findById(id).orElse(null);
    if (p == null) throw new RuntimeException("No encontramos el pedido");
    pedidoRepo.delete(p);

  }
}
