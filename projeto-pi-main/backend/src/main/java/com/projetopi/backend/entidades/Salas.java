package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "salas")
public class Salas {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "in_auditorio")
  private Integer temAuditorio;

  @Column(name = "in_banheiro")
  private Integer temBanheiro;

  @Column(name = "in_biblioteca")
  private Integer temBiblioteca;

  @Column(name = "in_cozinha")
  private Integer temCozinha;

  @Column(name = "in_laboratorio_ciencias")
  private Integer temLaboratorioCiencias;

  @Column(name = "in_laboratorio_informatica")
  private Integer temInformatica;

  @Column(name = "in_refeitorio")
  private Integer temRefeitorio;

  @Column(name = "in_sala_diretoria")
  private Integer temSalaDiretoria;

  @Column(name = "in_sala_professor")
  private Integer temSalaProfessor;

  @Column(name = "in_secretaria")
  private Integer temSecretaria;
}
