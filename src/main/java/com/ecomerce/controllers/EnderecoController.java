package com.ecomerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.dto.CepDTO;
import com.ecomerce.dto.EnderecoResponseDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.service.EnderecoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereço")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	public ResponseEntity<List<EnderecoResponseDTO>> findAllEndereco() {
		List<EnderecoResponseDTO> enderecoList = enderecoService.findAllEndereco();
		return new ResponseEntity<>(enderecoList, HttpStatus.OK);
	}

	public ResponseEntity<EnderecoResponseDTO> findEnderecoById(@PathVariable Integer id) {
		EnderecoResponseDTO enderecoDTO = enderecoService.findEnderecoById(id);
		if (null == enderecoDTO)
			throw new ResourceNotFoundException("Não foi encontrado endereço com id: " + id + " pois não existe.");
		else
			return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
	}

	public ResponseEntity<EnderecoResponseDTO> saveEndereco(@RequestBody @Valid EnderecoResponseDTO enderecoDTO) {
		EnderecoResponseDTO novoEndereco = enderecoService.saveEndereco(enderecoDTO);
		return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
	}

	public ResponseEntity<EnderecoResponseDTO> updateEndereco(@RequestBody @Valid EnderecoResponseDTO enderecoDTO) {
		EnderecoResponseDTO enderecoAtualizado = enderecoService.findEnderecoById(enderecoDTO.getIdEndereco());
		if (null == enderecoAtualizado)
			throw new ResourceNotFoundException("Não foi possivel atualizar endereço com este id");
		else
			return new ResponseEntity<>(enderecoService.updateEndereco(enderecoDTO), HttpStatus.OK);
	}

	public ResponseEntity<String> deleteEndereco(@PathVariable Integer id) {
		EnderecoResponseDTO enderecoAtualizado = enderecoService.findEnderecoById(id);
		if (null == enderecoAtualizado)
			throw new ResourceNotFoundException(
					"Não foi possivel deletar endereço com id: " + id + " pois não existe.");
		else
			enderecoService.deleteEnderecoById(id);
		return new ResponseEntity<>("Endereço deletado com sucesso!", HttpStatus.OK);
	}

	public ResponseEntity<CepDTO> consultarCep(@PathVariable String cep) {
		CepDTO cepDTO = enderecoService.consultarCepDTO(cep);
		return new ResponseEntity<>(cepDTO, HttpStatus.OK);
	}
}
