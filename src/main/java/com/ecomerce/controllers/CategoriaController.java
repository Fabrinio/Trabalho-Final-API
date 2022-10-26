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
import com.ecomerce.repositories.CategoriaRepository;
import com.ecomerce.service.CategoriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController 
@RequestMapping("/api/categoria")
@Tag(name = "Categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService servico;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/buscar")
	@ApiOperation(value="Lista todos os categoria", notes="Listagem de Categorias")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Retorna todos os categorias"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
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
