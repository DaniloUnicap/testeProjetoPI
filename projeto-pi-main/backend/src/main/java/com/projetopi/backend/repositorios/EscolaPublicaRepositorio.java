package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.EscolaPublicaDTO;
import com.projetopi.backend.entidades.EscolaPublica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaPublicaRepositorio extends JpaRepository<EscolaPublica, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.EscolaPublicaDTO(obj.id, obj.nomeEscola) " +
          "FROM EscolaPublica obj")
  List<EscolaPublicaDTO> listarEscolasPublicas();
}
