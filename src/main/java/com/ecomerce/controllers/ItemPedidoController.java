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

import com.ecomerce.model.ItemPedido;
import com.ecomerce.service.ItemPedidoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("/api/itempedido")
@Tag(name = "Item Pedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoService servico;

	@GetMapping("/buscar")
	public ResponseEntity<List<ItemPedido>> obterTodos() {

		List<ItemPedido> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ItemPedido> obterPorId(@PathVariable Long id) {

		Optional<ItemPedido> optCasa = servico.obterPorId(id);
		return ResponseEntity.ok(optCasa.get()); // 200
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<ItemPedido> cadastrar(@RequestBody ItemPedido itemItemPedido) {
		itemItemPedido = servico.cadastrar(itemItemPedido);
		return new ResponseEntity<>(itemItemPedido, HttpStatus.CREATED); // 201
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<ItemPedido> atualizar(@PathVariable Long id, @RequestBody ItemPedido itemItemPedido) {
		return ResponseEntity.ok(servico.atualizar(id, itemItemPedido)); // 200
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
