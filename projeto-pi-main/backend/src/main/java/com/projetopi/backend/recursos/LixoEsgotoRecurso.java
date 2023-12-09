package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.FuncionariosDTO;
import com.projetopi.backend.dtos.LixoEsgotoDTO;
import com.projetopi.backend.entidades.LixoEsgoto;
import com.projetopi.backend.repositorios.LixoEsgotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lixo_esgoto")
public class LixoEsgotoRecurso {

  @Autowired
  private LixoEsgotoRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<LixoEsgotoDTO>> listar() {
    List<LixoEsgoto> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new LixoEsgotoDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<LixoEsgotoDTO> encontrarRegistro(@PathVariable int id) {
    Optional<LixoEsgoto> resultado = repositorio.findById(id);
    LixoEsgoto entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new LixoEsgotoDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<LixoEsgotoDTO>> encontrarLixoEsgotoEscolaPublica() {
    List<LixoEsgotoDTO> resultado = repositorio.listarLixoEsgotoEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<LixoEsgotoDTO>> encontrarLixoEsgotoEscolaPrivada() {
    List<LixoEsgotoDTO> resultado = repositorio.listarLixoEsgotoEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }
}
