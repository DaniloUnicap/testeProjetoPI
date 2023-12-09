package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "matricula")
public class Matricula {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "qt_mat_bas", nullable = false)
  private Integer qtMatriculaBasica;

  @Column(name = "qt_mat_inf", nullable = false)
  private Integer qtMatriculaInfantil;

  @Column(name = "qt_mat_inf_cre", nullable = false)
  private Integer qtMatriculaInfantilCreche;

  @Column(name = "qt_mat_inf_pre", nullable = false)
  private Integer qtMatriculaInfantilPre;

  @Column(name = "qt_mat_fund", nullable = false)
  private Integer qtMatriculaFundamental;

}
