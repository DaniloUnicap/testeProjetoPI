package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ti")
public class TI {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "in_computador")
  private Integer temComputador;

  @Column(name = "in_equip_impressora")
  private Integer temEquipamentoImpressora;

  @Column(name = "qt_equip_multimidia")
  private Integer qtEquipamentoMultimidia;

  @Column(name = "in_desktop_aluno")
  private Integer temDesktopAluno;

  @Column(name = "qt_desktop_aluno")
  private Integer qtDesktopAluno;

  @Column(name = "in_internet_alunos")
  private Integer temInternetAlunos;

  @Column(name = "in_internet_administrativo")
  private Integer temInternetAdministrativo;

  @Column(name = "in_internet_aprendizagem")
  private Integer temInternetAprendizagem;
}
