package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.Salas;
import com.projetopi.backend.entidades.TI;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TIDTO {

  private Integer idEscola;
  private Integer temComputador;
  private Integer temEquipamentoImpressora;
  private Integer qtEquipamentoMultimidia;
  private Integer temDesktopAluno;
  private Integer qtDesktopAluno;
  private Integer temInternetAlunos;
  private Integer temInternetAdministrativo;
  private Integer temInternetAprendizagem;
  public TIDTO(TI entity) {
    this.idEscola = entity.getId();
    this.temComputador = entity.getTemComputador();
    this.temEquipamentoImpressora = entity.getTemEquipamentoImpressora();
    this.qtEquipamentoMultimidia = entity.getQtEquipamentoMultimidia();
    this.temDesktopAluno = entity.getTemDesktopAluno();
    this.qtDesktopAluno = entity.getQtDesktopAluno();
    this.temInternetAlunos = entity.getTemInternetAlunos();
    this.temInternetAdministrativo = entity.getTemInternetAdministrativo();
    this.temInternetAprendizagem = entity.getTemInternetAprendizagem();
  }
}
