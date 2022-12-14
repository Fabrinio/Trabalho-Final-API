package com.ecomerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;

	@Column(name = "cep")
	@NotBlank(message = "O cep é obrigatório")
	@Length(min = 8, max = 9, message = "O cep deverá ter no minímo 3 {mim} caracteres e no máximo {max}")
	private String cepEndereco;

	@Column(name = "rua")
	@Length(min = 3, max = 35, message = "A rua deverá ter no minímo 3 {mim} caracteres")
	private String ruaEndereco;

	@Column(name = "bairro")
	@NotBlank(message = "O bairro é obrigatório")
	private String bairroEndereco;

	@Column(name = "cidade")
	private String cidadeEndereco;

	@Column(name = "numero")
	private Long numeroEndereco;

	@Column(name = "complemento")
	private String complementoEndereco;

	@Column(name = "uf")
	@NotBlank(message = "A uf é obrigatória")
	@Length(min = 2, max = 2, message = "A UF deverá ter 2 caracteres")
	private String ufEndereco;

	
	@OneToMany(mappedBy = "endereco")
	@JsonIgnore
	private List<Cliente> clienteList;

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public Long getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Long numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getUfEndereco() {
		return ufEndereco;
	}

	public void setUfEndereco(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}
}
