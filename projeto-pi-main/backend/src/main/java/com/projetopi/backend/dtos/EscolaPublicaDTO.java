package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Endereco;
import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.EscolaPublica;
import com.projetopi.backend.entidades.Funcionarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EscolaPublicaDTO {

  private Integer idEscola;
  private String nomeEscola;

  public EscolaPublicaDTO(EscolaPublica entity) {
    this.idEscola = entity.getId();
    this.nomeEscola = entity.getNomeEscola();
  }
}
