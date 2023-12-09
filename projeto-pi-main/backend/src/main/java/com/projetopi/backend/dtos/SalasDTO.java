package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.Matricula;
import com.projetopi.backend.entidades.Salas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalasDTO {

  private Integer idEscola;
  private Integer temAuditorio;
  private Integer temBanheiro;
  private Integer temBiblioteca;
  private Integer temCozinha;
  private Integer temLaboratorioCiencias;
  private Integer temInformatica;
  private Integer temRefeitorio;
  private Integer temSalaDiretoria;
  private Integer temSalaProfessor;
  private Integer temSecretaria;

  public SalasDTO(Salas entity) {
    this.idEscola = entity.getId();
    this.temAuditorio = entity.getTemAuditorio();
    this.temBanheiro = entity.getTemBanheiro();
    this.temBiblioteca = entity.getTemBiblioteca();
    this.temCozinha = entity.getTemCozinha();
    this.temLaboratorioCiencias = entity.getTemLaboratorioCiencias();
    this.temInformatica = entity.getTemInformatica();
    this.temRefeitorio = entity.getTemRefeitorio();
    this.temSalaDiretoria = entity.getTemSalaDiretoria();
    this.temSalaProfessor = entity.getTemSalaProfessor();
    this.temSecretaria = entity.getTemSecretaria();
  }
}
