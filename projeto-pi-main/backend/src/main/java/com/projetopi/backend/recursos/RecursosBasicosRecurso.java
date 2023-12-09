package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.MatriculaDTO;
import com.projetopi.backend.dtos.RecursosBasicosDTO;
import com.projetopi.backend.dtos.TIDTO;
import com.projetopi.backend.entidades.RecursosBasicos;
import com.projetopi.backend.entidades.TI;
import com.projetopi.backend.repositorios.RecursosBasicosRepositorio;
import com.projetopi.backend.repositorios.TIRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recursos_basicos")
public class RecursosBasicosRecurso {

  @Autowired
  private RecursosBasicosRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<RecursosBasicosDTO>> listar() {
    List<RecursosBasicos> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new RecursosBasicosDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<RecursosBasicosDTO> encontrarRegistro(@PathVariable int id) {
    Optional<RecursosBasicos> resultado = repositorio.findById(id);
    RecursosBasicos entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new RecursosBasicosDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<RecursosBasicosDTO>> encontrarLixoEsgotoEscolaPublica() {
    List<RecursosBasicosDTO> resultado = repositorio.listarRecursosBasicosEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<RecursosBasicosDTO>> encontrarLixoEsgotoEscolaPrivada() {
    List<RecursosBasicosDTO> resultado = repositorio.listarRecursosBasicosEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }
}
