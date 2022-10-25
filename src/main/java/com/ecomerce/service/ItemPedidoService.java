package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.ItemPedido;
import com.ecomerce.repositories.ItemPedidoRepository;

public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository repositorio;
	
	public List<ItemPedido> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<ItemPedido> obterPorId(Long id){
		
		Optional<ItemPedido> optItemPedido = repositorio.findById(id);
		
		if(optItemPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o itemPedido " + id);
		}
		
		return optItemPedido;
	}
	
	public ItemPedido atualizar(Long id, ItemPedido itemPedido) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		itemPedido.setIdItemPedido(id);
		return repositorio.save(itemPedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public ItemPedido cadastrar(ItemPedido itemPedido) {
		
		itemPedido.setIdItemPedido(null);		
		return itemPedido = repositorio.save(itemPedido);
	}
}
