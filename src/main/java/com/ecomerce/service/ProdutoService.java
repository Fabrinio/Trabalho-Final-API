package com.ecomerce.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Produto;
import com.ecomerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repositorio;
	
	@Autowired
	CategoriaService categoriaService;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<Produto> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Produto> obterPorId(Long id){
		
		Optional<Produto> optProduto = repositorio.findById(id);
		
		if(optProduto.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o produto " + id);
		}
		
		return optProduto;
	}
	
	public Produto atualizar(Long id, Produto produto) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		produto.setIdProduto(id);
		return repositorio.save(produto);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public Produto cadastrar(Produto produto) {
		
		produto.setIdProduto(null);		
		return produto = repositorio.save(produto);
	}
}

