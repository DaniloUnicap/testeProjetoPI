package com.projetopi.backend.repositorios;

import com.projetopi.backend.dtos.SalasDTO;
import com.projetopi.backend.dtos.TIDTO;
import com.projetopi.backend.entidades.TI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TIRepositorio extends JpaRepository<TI, Integer> {

  @Query("SELECT new com.projetopi.backend.dtos.TIDTO(obj) " +
          "FROM TI obj " +
          "JOIN obj.escola.escolaPublica")
  List<TIDTO> listarTIEscolaPublica();

  @Query("SELECT new com.projetopi.backend.dtos.TIDTO(obj) " +
          "FROM TI obj " +
          "JOIN obj.escola.escolaPrivada")
  List<TIDTO> listarTIEscolaPrivada();
}
