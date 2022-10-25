package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Cliente;
import com.ecomerce.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repositorio;
	
	public List<Cliente> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Cliente> obterPorId(Long id){
		
		Optional<Cliente> optCliente = repositorio.findById(id);
		
		if(optCliente.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o cliente " + id);
		}
		
		return optCliente;
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		cliente.setIdCliente(id);
		return repositorio.save(cliente);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
public Cliente cadastrar(Cliente cliente) {
		
		cliente.setIdCliente(null);		
		return cliente = repositorio.save(cliente);
	}
	
	
	
}
