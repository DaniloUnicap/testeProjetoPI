package com.projetopi.backend.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "escolapublica")
public class EscolaPublica {

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
