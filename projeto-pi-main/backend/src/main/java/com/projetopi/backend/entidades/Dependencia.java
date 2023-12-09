package com.projetopi.backend.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "dependencia")
public class Dependencia {

  @Id
  @EqualsAndHashCode.Include
  private Integer id;

  @Column(nullable = false)
  private String dependencia;

}
