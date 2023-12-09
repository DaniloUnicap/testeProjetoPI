package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.FuncionariosDTO;
import com.projetopi.backend.dtos.LixoEsgotoDTO;
import com.projetopi.backend.entidades.LixoEsgoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LixoEsgotoRepositorio extends JpaRepository<LixoEsgoto, Integer> {
  @Query("SELECT new com.projetopi.backend.dtos.LixoEsgotoDTO(obj) " +
          "FROM LixoEsgoto obj " +
          "JOIN obj.escola.escolaPublica")
  List<LixoEsgotoDTO> listarLixoEsgotoEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.LixoEsgotoDTO(obj) " +
          "FROM LixoEsgoto obj " +
          "JOIN obj.escola.escolaPrivada")
  List<LixoEsgotoDTO> listarLixoEsgotoEscolaPrivada();
}
