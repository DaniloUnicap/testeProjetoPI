package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.EscolaDTO;
import com.projetopi.backend.dtos.EscolaPublicaDTO;
import com.projetopi.backend.entidades.EscolaPublica;
import com.projetopi.backend.repositorios.EscolaPublicaRepositorio;
import com.projetopi.backend.repositorios.EscolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escolas_publicas")
public class EscolaPublicaRecurso {

  @Autowired
  private EscolaPublicaRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<EscolaPublicaDTO>> listar() {
    List<EscolaPublicaDTO> resultado = repositorio.listarEscolasPublicas();
    return ResponseEntity.ok(resultado);
  }
}
