package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "funcionarios")
public class Funcionarios {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "in_prof_servicos_gerais")
  private Integer temProfissionalServicosGerais;

  @Column(name = "qt_prof_servicos_gerais")
  private Integer qtProfissionaisServicosGerais;

  @Column(name = "in_prof_alimentacao")
  private Integer temProfissionalAlimentacao;

  @Column(name = "qt_prof_alimentacao")
  private Integer qtProfissionalAlimentacao;

  @Column(name = "in_prof_gestao")
  private Integer temProfissionalGestao;

  @Column(name = "qt_prof_gestao")
  private Integer qtProfissionalGestao;
}
