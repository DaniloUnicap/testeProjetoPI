package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.FuncionariosDTO;
import com.projetopi.backend.entidades.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionariosRepositorio extends JpaRepository<Funcionarios, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.FuncionariosDTO(obj) " +
          "FROM Funcionarios obj " +
          "JOIN obj.escola.escolaPublica")
  List<FuncionariosDTO> listarFuncionariosEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.FuncionariosDTO(obj) " +
          "FROM Funcionarios obj " +
          "JOIN obj.escola.escolaPrivada")
  List<FuncionariosDTO> listarFuncionariosEscolaPrivada();
}

