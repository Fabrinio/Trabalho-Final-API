package com.ecomerce.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;




@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column(nullable = false)
	@NotBlank(message = "O nome é obrigatório")
	@Email(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
	private String email;
	
	@Column(name = "nome_completo")
	@NotBlank(message = "O nome é obrigatório")
	@Length(min = 3, max = 35, message = "O nome deverá ter no máximo {max} caracteres")
	private String nomeCompleto;
	
	@Column(name = "cpf")
	@NotBlank(message = "O cpf é obrigatório")
	private String cpf;

	@Column(name = "telefone")
	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;
	
	@Column(name = "data_nascimento")
	@NotNull(message = "A data do pedido é obrigatória")
	@JsonFormat(shape = Shape.STRING, pattern= "dd/MM/yyyy")
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNascimento;
	}

	public void setDataNasc(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
}
