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

import com.ecomerce.model.Cliente;
import com.ecomerce.service.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/cliente")
@Tag(name = "Cliente")
public class ClienteController {
	@Autowired
	private ClienteService servico;
	
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Cliente>> obterTodos(){
		
		List<Cliente> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Cliente> obterPorId(@PathVariable Long id){
		
		Optional<Cliente> optCasa = servico.obterPorId(id);
		return ResponseEntity.ok(optCasa.get()); // 200
	}
	
	@PostMapping("/cadastrar") 
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		cliente = servico.cadastrar(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(servico.atualizar(id, cliente)); // 200
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
