package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.RecursosBasicosDTO;
import com.projetopi.backend.dtos.SalasDTO;
import com.projetopi.backend.entidades.Matricula;
import com.projetopi.backend.entidades.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalasRepositorio extends JpaRepository<Salas, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.SalasDTO(obj) " +
          "FROM Salas obj " +
          "JOIN obj.escola.escolaPublica")
  List<SalasDTO> listarSalasEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.SalasDTO(obj) " +
          "FROM Salas obj " +
          "JOIN obj.escola.escolaPrivada")
  List<SalasDTO> listarSalasEscolaPrivada();
}
