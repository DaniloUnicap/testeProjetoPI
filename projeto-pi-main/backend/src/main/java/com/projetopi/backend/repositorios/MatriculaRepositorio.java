package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.MatriculaDTO;
import com.projetopi.backend.entidades.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.MatriculaDTO(obj) " +
          "FROM Matricula obj " +
          "JOIN obj.escola.escolaPublica")
  List<MatriculaDTO> listarMatriculaEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.MatriculaDTO(obj) " +
          "FROM Matricula obj " +
          "JOIN obj.escola.escolaPrivada")
  List<MatriculaDTO> listarMatriculaEscolaPrivada();
}
