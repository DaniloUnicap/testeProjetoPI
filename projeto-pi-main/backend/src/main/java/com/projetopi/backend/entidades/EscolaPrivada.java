package com.projetopi.backend.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "escolaprivada")
public class EscolaPrivada {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JoinColumn(name = "co_entidade")
  private Escola escola;

  @Column(name = "no_entidade")
  private String nomeEscola;

  @Embedded
  private Endereco endereco;
}
