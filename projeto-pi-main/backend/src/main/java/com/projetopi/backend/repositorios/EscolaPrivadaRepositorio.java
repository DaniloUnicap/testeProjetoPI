package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.EscolaPrivadaDTO;
import com.projetopi.backend.dtos.EscolaPublicaDTO;
import com.projetopi.backend.entidades.Dependencia;
import com.projetopi.backend.entidades.EscolaPrivada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaPrivadaRepositorio extends JpaRepository<EscolaPrivada, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.EscolaPrivadaDTO(obj.id, obj.nomeEscola) " +
          "FROM EscolaPrivada obj")
  List<EscolaPrivadaDTO> listarEscolasPrivadas();
}
