package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.dto.CategoriaResponseDTO;
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
			throw new ResourceNotFoundException("Não foi possivel encontrar a categoria " + id);
		}
		
		return optCategoria;
	}
	
	public Categoria atualizar(Long id, Categoria categoria) {
		
		
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
	
	public CategoriaResponseDTO converterEntityToDTO(Categoria categoria) {
		CategoriaResponseDTO CategoriaResponseDTO = new CategoriaResponseDTO();
		CategoriaResponseDTO.setIdCategoria(categoria.getIdCategoria());
		CategoriaResponseDTO.setDescricaoCategoria(categoria.getDescricao());
		CategoriaResponseDTO.setNomeCategoria(categoria.getNome());
		return CategoriaResponseDTO;
	}

	public Categoria converterDTOToEntity(CategoriaResponseDTO categoriaResponseDTO) {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(categoriaResponseDTO.getIdCategoria());
		categoria.setDescricao(categoriaResponseDTO.getDescricaoCategoria());
		categoria.setNome(categoriaResponseDTO.getNomeCategoria());
		return categoria;
	}
}
