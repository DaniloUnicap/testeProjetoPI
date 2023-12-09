package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.Funcionarios;
import com.projetopi.backend.entidades.TI;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionariosDTO {

  private Integer idEscola;
  private Integer temProfissionalServicosGerais;
  private Integer qtProfissionaisServicosGerais;
  private Integer temProfissionalAlimentacao;
  private Integer qtProfissionalAlimentacao;
  private Integer temProfissionalGestao;
  private Integer qtProfissionalGestao;

  public FuncionariosDTO(Funcionarios entity) {
    this.idEscola = entity.getId();
    this.temProfissionalServicosGerais = entity.getTemProfissionalServicosGerais();
    this.qtProfissionaisServicosGerais = entity.getQtProfissionaisServicosGerais();
    this.temProfissionalAlimentacao = entity.getTemProfissionalAlimentacao();
    this.qtProfissionalAlimentacao = entity.getQtProfissionalAlimentacao();
    this.temProfissionalGestao = entity.getTemProfissionalGestao();
    this.qtProfissionalGestao = entity.getQtProfissionalGestao();
  }
}
