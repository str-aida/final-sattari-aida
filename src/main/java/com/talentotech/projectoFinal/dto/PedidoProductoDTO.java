package com.talentotech.projectoFinal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoProductoDTO {

private Long id;
private String nombreProd;
private Integer cantidadProd;
private Double precio;
private Double subTotal;
}
