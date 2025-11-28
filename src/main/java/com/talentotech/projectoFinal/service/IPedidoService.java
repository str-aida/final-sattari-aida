package com.talentotech.projectoFinal.service;

import com.talentotech.projectoFinal.dto.PedidoDTO;
import java.util.List;

public interface IPedidoService {
  List<PedidoDTO> listarPedido();
  PedidoDTO editarPedido(Long id , PedidoDTO pedidoDto );
  PedidoDTO crearPedido (PedidoDTO pedidoDto);
  void eliminarPedido(Long id);


}
