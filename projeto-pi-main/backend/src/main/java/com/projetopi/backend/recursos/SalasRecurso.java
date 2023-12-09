package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.MatriculaDTO;
import com.projetopi.backend.dtos.RecursosBasicosDTO;
import com.projetopi.backend.dtos.SalasDTO;
import com.projetopi.backend.entidades.Matricula;
import com.projetopi.backend.entidades.Salas;
import com.projetopi.backend.repositorios.MatriculaRepositorio;
import com.projetopi.backend.repositorios.SalasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalasRecurso {

  @Autowired
  private SalasRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<SalasDTO>> listar() {
    List<Salas> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new SalasDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<SalasDTO> encontrarRegistro(@PathVariable int id) {
    Optional<Salas> resultado = repositorio.findById(id);
    Salas entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new SalasDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<SalasDTO>> encontrarLixoEsgotoEscolaPublica() {
    List<SalasDTO> resultado = repositorio.listarSalasEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<SalasDTO>> encontrarLixoEsgotoEscolaPrivada() {
    List<SalasDTO> resultado = repositorio.listarSalasEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }
}
