package com.ecomerce.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.model.Categoria;
import com.ecomerce.service.CategoriaService;


@RestController 
@RequestMapping("/api/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService servico;
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Categoria>> obterTodos(){
		
		List<Categoria> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Categoria> obterPorId(@PathVariable Long id){
		
		Optional<Categoria> optCasa = servico.obterPorId(id);
		return ResponseEntity.ok(optCasa.get()); // 200
	}
	
	@PostMapping("/cadastrar") 
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {
		categoria = servico.cadastrar(categoria);
		return new ResponseEntity<>(categoria, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
		return ResponseEntity.ok(servico.atualizar(id, categoria)); // 200
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
