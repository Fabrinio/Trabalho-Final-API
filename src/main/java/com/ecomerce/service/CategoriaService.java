package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Categoria;
import com.ecomerce.repositories.CategoriaRepository;

@Service
public class CategoriaService  {
	@Autowired
	private CategoriaRepository repositorio;
	
	public List<Categoria> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Categoria> obterPorId(Long id){
		
		Optional<Categoria> optCategoria = repositorio.findById(id);
		
		if(optCategoria.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o categoria " + id);
		}
		
		return optCategoria;
	}
	
	public Categoria atualizar(Long id, Categoria categoria) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		categoria.setIdCategoria(id);
		return repositorio.save(categoria);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public Categoria cadastrar(Categoria categoria) {
		
		categoria.setIdCategoria(null);		
		return categoria = repositorio.save(categoria);
	}
}
