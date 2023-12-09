package com.projetopi.backend.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

  @Column(name = "ds_endereco")
  private String nomeEndereco;

  @Column(name = "no_bairro")
  private String bairro;

  @Column(name = "co_cep")
  private Integer cep;

  @Column(name = "nu_endereco")
  private Integer numeroEndereco;

  @Column(name = "nu_telefone")
  private Integer numeroTelefone;
}
