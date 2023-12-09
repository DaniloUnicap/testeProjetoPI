package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.SalasDTO;
import com.projetopi.backend.dtos.TIDTO;
import com.projetopi.backend.entidades.Salas;
import com.projetopi.backend.entidades.TI;
import com.projetopi.backend.repositorios.SalasRepositorio;
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
@RequestMapping("/ti")
public class TIRecurso {

  @Autowired
  private TIRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<TIDTO>> listar() {
    List<TI> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new TIDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<TIDTO> encontrarRegistro(@PathVariable int id) {
    Optional<TI> resultado = repositorio.findById(id);
    TI entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new TIDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<TIDTO>> encontrarLixoEsgotoEscolaPublica() {
    List<TIDTO> resultado = repositorio.listarTIEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<TIDTO>> encontrarLixoEsgotoEscolaPrivada() {
    List<TIDTO> resultado = repositorio.listarTIEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }

}
