package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.EscolaDTO;
import com.projetopi.backend.entidades.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EscolaRepositorio extends JpaRepository<Escola, Integer> {

  @Query("(SELECT new com.projetopi.backend.dtos.EscolaDTO(obj.id, obj.escolaPublica.nomeEscola) "+
          "FROM Escola obj) " +
          "UNION ALL " +
          "(SELECT new com.projetopi.backend.dtos.EscolaDTO(obj.id, obj.escolaPublica.nomeEscola) " +
          "FROM Escola obj)"
  )
  List<EscolaDTO> listarEscolasComIdENome();
}
