package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.MatriculaDTO;
import com.projetopi.backend.dtos.RecursosBasicosDTO;
import com.projetopi.backend.entidades.RecursosBasicos;
import com.projetopi.backend.entidades.TI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursosBasicosRepositorio extends JpaRepository<RecursosBasicos, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.RecursosBasicosDTO(obj) " +
          "FROM RecursosBasicos obj " +
          "JOIN obj.escola.escolaPublica")
  List<RecursosBasicosDTO> listarRecursosBasicosEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.RecursosBasicosDTO(obj) " +
          "FROM RecursosBasicos obj " +
          "JOIN obj.escola.escolaPrivada")
  List<RecursosBasicosDTO> listarRecursosBasicosEscolaPrivada();
}
