package com.ecomerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.dto.CepDTO;
import com.ecomerce.dto.EnderecoResponseDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.Endereco;
import com.ecomerce.service.EnderecoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/enderecos")
@Tag(name = "Endereço")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping("/buscar")
	public ResponseEntity<List<EnderecoResponseDTO>> buscarTodos() {
		List<EnderecoResponseDTO> enderecoList = enderecoService.findAllEndereco();
		return new ResponseEntity<>(enderecoList, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<EnderecoResponseDTO> BuscarPorId(@PathVariable Long id) {
		EnderecoResponseDTO enderecoDTO = enderecoService.findEnderecoById(id);
		if (null == enderecoDTO)
			throw new ResourceNotFoundException("Não foi encontrado endereço com id: " + id + " pois não existe.");
		else
			return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
	}

	@PostMapping("/cadastrar") 
	public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
		endereco = enderecoService.cadastrar(endereco);
		return new ResponseEntity<>(endereco, HttpStatus.CREATED); // 201
	}

	@GetMapping("/atualizar")
	public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@RequestBody @Valid EnderecoResponseDTO enderecoDTO) {
		EnderecoResponseDTO enderecoAtualizado = enderecoService.findEnderecoById(enderecoDTO.getIdEndereco());
		if (null == enderecoAtualizado)
			throw new ResourceNotFoundException("Não foi possivel atualizar endereço com este id");
		else
			return new ResponseEntity<>(enderecoService.updateEndereco(enderecoDTO), HttpStatus.OK);
	}

	@GetMapping("/deletar")
	public ResponseEntity<String> deleteEndereco(@PathVariable Long id) {
		EnderecoResponseDTO enderecoAtualizado = enderecoService.findEnderecoById(id);
		if (null == enderecoAtualizado)
			throw new ResourceNotFoundException(
					"Não foi possivel deletar endereço com id: " + id + " pois não existe.");
		else
			enderecoService.deleteEnderecoById(id);
		return new ResponseEntity<>("Endereço deletado com sucesso!", HttpStatus.OK);
	}
	@GetMapping("{cep}")
	public ResponseEntity<CepDTO> consultarCep(@PathVariable String cep) {
		CepDTO cepDTO = enderecoService.consultarCepDTO(cep);
		return new ResponseEntity<>(cepDTO, HttpStatus.OK);
	}
	 public ResponseEntity<EnderecoResponseDTO> SalvarCep(@PathVariable String cep, EnderecoResponseDTO enderecoDTO) {
	    	
	    	EnderecoResponseDTO cepDTO = enderecoService.saveCep(cep,enderecoDTO);
	    	
	    	return new ResponseEntity<>(cepDTO, HttpStatus.OK);
	    }
}
