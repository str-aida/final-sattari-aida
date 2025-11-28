package com.talentotech.projectoFinal.dto;

import com.talentotech.projectoFinal.model.PedidoProducto;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {

  private Long id;
  private LocalDate fecha;
  private String estado;
//detalles de venta:
  private List<PedidoProductoDTO> detalle;

  private Double total;
}
