package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.EscolaDTO;
import com.projetopi.backend.entidades.Escola;
import com.projetopi.backend.repositorios.EscolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaRecurso {

  @Autowired
  private EscolaRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<EscolaDTO>> listar() {
    List<EscolaDTO> resultado = repositorio.listarEscolasComIdENome();
    return ResponseEntity.ok(resultado);
  }
}
