package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Funcionarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EscolaDTO {

  private Integer idEscola;
  private String nome;
}
