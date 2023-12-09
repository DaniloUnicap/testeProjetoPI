package com.projetopi.backend.dtos;

import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.entidades.LixoEsgoto;
import com.projetopi.backend.entidades.Matricula;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {

  private Integer idEscola;
  private Integer qtMatriculaBasica;
  private Integer qtMatriculaInfantil;
  private Integer qtMatriculaInfantilCreche;
  private Integer qtMatriculaInfantilPre;
  private Integer qtMatriculaFundamental;

  public MatriculaDTO(Matricula entity) {
    this.idEscola = entity.getId();
    this.qtMatriculaBasica = entity.getQtMatriculaBasica();
    this.qtMatriculaInfantil = entity.getQtMatriculaInfantil();
    this.qtMatriculaInfantilCreche = entity.getQtMatriculaInfantilCreche();
    this.qtMatriculaInfantilPre = entity.getQtMatriculaInfantilPre();
    this.qtMatriculaFundamental = entity.getQtMatriculaFundamental();
  }
}
