package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.EscolaPrivada;
import com.projetopi.backend.entidades.EscolaPublica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EscolaPrivadaDTO {

  private Integer idEscola;
  private String nomeEscola;

  public EscolaPrivadaDTO(EscolaPrivada entity) {
    this.idEscola = entity.getId();
    this.nomeEscola = entity.getNomeEscola();
  }
}
