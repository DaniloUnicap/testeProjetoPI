package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.EscolaPrivadaDTO;
import com.projetopi.backend.dtos.EscolaPublicaDTO;
import com.projetopi.backend.repositorios.EscolaPrivadaRepositorio;
import com.projetopi.backend.repositorios.EscolaPublicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escolas_privadas")
public class EscolaPrivadaRecurso {

  @Autowired
  private EscolaPrivadaRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<EscolaPrivadaDTO>> listar() {
    List<EscolaPrivadaDTO> resultado = repositorio.listarEscolasPrivadas();
    return ResponseEntity.ok(resultado);
  }
}
