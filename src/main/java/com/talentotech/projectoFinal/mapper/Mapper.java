package com.talentotech.projectoFinal.mapper;

import com.talentotech.projectoFinal.dto.PedidoDTO;
import com.talentotech.projectoFinal.dto.PedidoProductoDTO;
import com.talentotech.projectoFinal.dto.ProductoDTO;
import com.talentotech.projectoFinal.model.Pedido;
import com.talentotech.projectoFinal.model.PedidoProducto;
import com.talentotech.projectoFinal.model.Producto;
import java.util.stream.Collectors;

public class Mapper {


  //Mapeo de Producto a ProductoDTO
  public static ProductoDTO toDTO(Producto p) {
    if (p == null) return null;

    return ProductoDTO.builder()
        .id(p.getId())
        .nombre(p.getNombre())
        .descripcion(p.getDescripcion())
        .categoria(p.getCategoria())
        .precio(p.getPrecio())
        .cantidad(p.getCantidad())
        .build();
  }

  //mapeo de Pedido a PedidoDTO
  public static PedidoDTO toDTO(Pedido pedido) {
    if (pedido == null) return null;

    var detalle = pedido.getDetalle().stream().map(det ->
        PedidoProductoDTO.builder()
            .id(det.getProd().getId())
            .nombreProd(det.getProd().getNombre())
            .cantidadProd(det.getCantidad())
            .precio(det.getPrecio())
            .subTotal(det.getPrecio() * det.getCantidad())
            .build()
    ).collect(Collectors.toList());

    var total = detalle.stream()
        .map(PedidoProductoDTO::getSubTotal)
        .reduce(0.0, Double::sum);

    return PedidoDTO.builder()
        .id(pedido.getId())
        .fecha(pedido.getFecha())
        .estado(pedido.getEstado())
        .detalle(detalle)
        .total(total)
        .build();
  }


}