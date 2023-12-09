package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.RecursosBasicos;
import com.projetopi.backend.entidades.TI;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecursosBasicosDTO {

  private Integer idEscola;
  private Integer temAguaPotavel;
  private Integer temAguaInexistente;
  private Integer temEnergiaRedePublica;

  public RecursosBasicosDTO(RecursosBasicos entity) {
    this.idEscola = entity.getId();
    this.temAguaPotavel = entity.getTemAguaPotavel();
    this.temAguaInexistente = entity.getTemAguaInexistente();
    this.temEnergiaRedePublica = entity.getTemEnergiaRedePublica();
  }
}
