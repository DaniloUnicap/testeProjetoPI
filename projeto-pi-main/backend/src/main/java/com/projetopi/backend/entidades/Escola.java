package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "escola")
public class Escola {

  @Id
  @EqualsAndHashCode.Include
  @Column(name = "co_entidade")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "tp_dependencia")
  private Dependencia dependencia;

  @OneToOne(mappedBy = "escola")
  private EscolaPublica escolaPublica;

  @OneToOne(mappedBy = "escola")
  private EscolaPrivada escolaPrivada;
}
