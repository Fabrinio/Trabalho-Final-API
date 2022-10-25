package com.ecomerce.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteRequesteDTO {
	private String emailCliente;
	private String nomeCompletoCliente;
	private String cpfCliente;
	private String telefoneCliente;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimentoCliente;
	private Long idEndereco;
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getNomeCompletoCliente() {
		return nomeCompletoCliente;
	}
	public void setNomeCompletoCliente(String nomeCompletoCliente) {
		this.nomeCompletoCliente = nomeCompletoCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public Date getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}
	public void setDataNascimentoCliente(Date dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	} 

}
