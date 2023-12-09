package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.LixoEsgotoDTO;
import com.projetopi.backend.dtos.MatriculaDTO;
import com.projetopi.backend.entidades.LixoEsgoto;
import com.projetopi.backend.entidades.Matricula;
import com.projetopi.backend.repositorios.LixoEsgotoRepositorio;
import com.projetopi.backend.repositorios.MatriculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaRecurso {

  @Autowired
  private MatriculaRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<MatriculaDTO>> listar() {
    List<Matricula> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new MatriculaDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<MatriculaDTO> encontrarRegistro(@PathVariable int id) {
    Optional<Matricula> resultado = repositorio.findById(id);
    Matricula entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new MatriculaDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<MatriculaDTO>> encontrarLixoEsgotoEscolaPublica() {
    List<MatriculaDTO> resultado = repositorio.listarMatriculaEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<MatriculaDTO>> encontrarLixoEsgotoEscolaPrivada() {
    List<MatriculaDTO> resultado = repositorio.listarMatriculaEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }
}
