package com.projetopi.backend.recursos;

import com.projetopi.backend.dtos.FuncionariosDTO;
import com.projetopi.backend.dtos.TIDTO;
import com.projetopi.backend.entidades.Funcionarios;
import com.projetopi.backend.entidades.Salas;
import com.projetopi.backend.entidades.TI;
import com.projetopi.backend.repositorios.FuncionariosRepositorio;
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
@RequestMapping("/funcionarios")
public class FuncionariosRecurso {

  @Autowired
  private FuncionariosRepositorio repositorio;

  @GetMapping
  public ResponseEntity<List<FuncionariosDTO>> listar() {
    List<Funcionarios> resultado = repositorio.findAll();
    return ResponseEntity.ok(resultado.stream().map(entity -> new FuncionariosDTO(entity)).toList());
  }

  @GetMapping("{id}")
  public ResponseEntity<FuncionariosDTO> encontrarRegistro(@PathVariable int id) {
    Optional<Funcionarios> resultado = repositorio.findById(id);
    Funcionarios entity =  resultado.orElseThrow(() -> new RuntimeException("Não foi encontrado o recurso"));

    return ResponseEntity.ok(new FuncionariosDTO(entity));
  }

  @GetMapping("/escolas_publicas")
  public ResponseEntity<List<FuncionariosDTO>> encontrarFuncionariosEscolaPublica() {
    List<FuncionariosDTO> resultado = repositorio.listarFuncionariosEscolaPublica();
    return ResponseEntity.ok(resultado);
  }

  @GetMapping("/escolas_privadas")
  public ResponseEntity<List<FuncionariosDTO>> encontrarFuncionariosEscolaPrivada() {
    List<FuncionariosDTO> resultado = repositorio.listarFuncionariosEscolaPrivada();
    return ResponseEntity.ok(resultado);
  }
}
