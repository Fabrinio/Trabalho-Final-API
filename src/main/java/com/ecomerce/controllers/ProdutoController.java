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

import com.ecomerce.model.Produto;
import com.ecomerce.service.ProdutoService;

@RestController 
@RequestMapping("/api/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService servico;

	@GetMapping("/buscar")
	public ResponseEntity<List<Produto>> obterTodos() {

		List<Produto> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Produto> obterPorId(@PathVariable Long id) {

		Optional<Produto> optCasa = servico.obterPorId(id);
		return ResponseEntity.ok(optCasa.get()); // 200
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
		produto = servico.cadastrar(produto);
		return new ResponseEntity<>(produto, HttpStatus.CREATED); // 201
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
		return ResponseEntity.ok(servico.atualizar(id, produto)); // 200
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}

