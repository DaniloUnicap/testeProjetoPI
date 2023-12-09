package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "recursosbasicos")
public class RecursosBasicos {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "in_agua_potavel")
  private Integer temAguaPotavel;

  @Column(name = "in_agua_inexistente")
  private Integer temAguaInexistente;

  @Column(name = "in_energia_rede_publica")
  private Integer temEnergiaRedePublica;
}
