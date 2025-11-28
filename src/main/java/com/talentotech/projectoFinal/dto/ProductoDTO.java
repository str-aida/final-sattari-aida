package com.talentotech.projectoFinal.dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
  private Long id;
  private String nombre;
  private String descripcion;
  private Long cantidad;
  private Double precio;
  private String categoria;

}
