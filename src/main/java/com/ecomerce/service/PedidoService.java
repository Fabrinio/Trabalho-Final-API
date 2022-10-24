package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Pedido;
import com.ecomerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repositorio;
	
	public List<Pedido> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Pedido> obterPorId(Long id){
		
		Optional<Pedido> optPedido = repositorio.findById(id);
		
		if(optPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o pedido " + id);
		}
		
		return optPedido;
	}
	
	public Pedido atualizar(Long id, Pedido pedido) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		pedido.setIdPedido(id);
		return repositorio.save(pedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public Pedido cadastrar(Pedido pedido) {
		
		pedido.setIdPedido(null);		
		return pedido = repositorio.save(pedido);
	}
}
