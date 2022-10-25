package com.ecomerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecomerce.dto.CepDTO;
import com.ecomerce.dto.EnderecoResponseDTO;
import com.ecomerce.model.Endereco;
import com.ecomerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;

	public List<EnderecoResponseDTO> findAllEndereco() {
		List<Endereco> listaEnderecoEntity = enderecoRepository.findAll();
		List<EnderecoResponseDTO> listaEnderecoResponseDTO = new ArrayList<>();

		for (Endereco endereco : listaEnderecoEntity) {
			listaEnderecoResponseDTO.add(converterEntityToDTO(endereco));
		}

		return listaEnderecoResponseDTO;
	}

	public EnderecoResponseDTO findEnderecoById(Integer id) {
		return enderecoRepository.findById(id).isPresent() ? converterEntityToDTO(enderecoRepository.findById(id).get())
				: null;
	}

	public EnderecoResponseDTO saveEndereco(EnderecoResponseDTO enderecoDTO) {
		Endereco endereco = enderecoRepository.save(ConverteDTOToEntidade(enderecoDTO));
		return converterEntityToDTO(endereco);
	}

	public EnderecoResponseDTO updateEndereco(EnderecoResponseDTO enderecoDTO) {
		Endereco endereco = enderecoRepository.save(ConverteDTOToEntidade(enderecoDTO));
		return converterEntityToDTO(endereco);
	}

	public void deleteEnderecoById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).get();
		enderecoRepository.delete(endereco);
	}

	public Endereco ConverteDTOToEntidade(EnderecoResponseDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		endereco.setBairroEndereco(enderecoDTO.getBairroEndereco());
		endereco.setCepEndereco(enderecoDTO.getCepEndereco());
		endereco.setCidadeEndereco(enderecoDTO.getCidadeEndereco());
		endereco.setComplemetnoEndereco(enderecoDTO.getComplemetnoEndereco());
		endereco.setIdEndereco(enderecoDTO.getIdEndereco());
		endereco.setNumeroEndereco(enderecoDTO.getNumeroEndereco());
		endereco.setRuaEndereco(enderecoDTO.getRuaEndereco());
		endereco.setUfEndereco(enderecoDTO.getUfEndereco());
		return endereco;
	}

	public EnderecoResponseDTO converterEntityToDTO(Endereco endereco) {
		EnderecoResponseDTO enderecoDTO = new EnderecoResponseDTO();
		enderecoDTO.setBairroEndereco(endereco.getBairroEndereco());
		enderecoDTO.setCepEndereco(endereco.getCepEndereco());
		enderecoDTO.setCidadeEndereco(endereco.getCidadeEndereco());
		enderecoDTO.setComplemetnoEndereco(endereco.getComplemetnoEndereco());
		enderecoDTO.setIdEndereco(endereco.getIdEndereco());
		enderecoDTO.setNumeroEndereco(endereco.getNumeroEndereco());
		enderecoDTO.setRuaEndereco(endereco.getRuaEndereco());
		enderecoDTO.setUfEndereco(endereco.getUfEndereco());
		return enderecoDTO;
	}
	public CepDTO consultarCepDTO(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json";
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
        CepDTO cepDTO = restTemplate.getForObject(uri, CepDTO.class, params);
		return cepDTO;

	}
	 
	
	public Endereco CepDTOParaEndereco(CepDTO cepDTO) {
		Endereco endereco = new Endereco();
		endereco.setCepEndereco(cepDTO.getCep());
		endereco.setBairroEndereco(cepDTO.getBairro());
		endereco.setComplemetnoEndereco(cepDTO.getComplemento());
		endereco.setUfEndereco(cepDTO.getUf());
		endereco.setCidadeEndereco(cepDTO.getCidade());
		endereco.setRuaEndereco(cepDTO.getLogradouro());

		return endereco;
	}
	
	public EnderecoResponseDTO CepDTOParaEnderecoResponseDTO(CepDTO cepDTO) {
		EnderecoResponseDTO endereco = new EnderecoResponseDTO();
		endereco.setCepEndereco(cepDTO.getCep());
		endereco.setBairroEndereco(cepDTO.getBairro());
		endereco.setComplemetnoEndereco(cepDTO.getComplemento());
		endereco.setUfEndereco(cepDTO.getUf());
		endereco.setCidadeEndereco(cepDTO.getCidade());
		endereco.setRuaEndereco(cepDTO.getLogradouro());

		return endereco;
	}

	public EnderecoResponseDTO saveCep(String cep, EnderecoResponseDTO enderecoDTO) {
		Endereco cepEnd = CepDTOParaEndereco(consultarCepDTO(cep));
		cepEnd.setNumeroEndereco(enderecoDTO.getNumeroEndereco());
		cepEnd.setComplemetnoEndereco(enderecoDTO.getComplemetnoEndereco());
		return converterEntityToDTO(enderecoRepository.save(cepEnd));
	}
}