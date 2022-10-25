package com.ecomerce.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProdutoRequestDTO {

	
	private String nomeProduto;

	private String descricao;

	private Long qtdEstoqueProduto;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastroProduto;

	private Double valorUnitarioProduto;

	private String nomeImagemProduto;

	private CategoriaResponseDTO categoriaResponseDTO;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQtdEstoqueProduto() {
		return qtdEstoqueProduto;
	}

	public void setQtdEstoqueProduto(Long qtdEstoqueProduto) {
		this.qtdEstoqueProduto = qtdEstoqueProduto;
	}

	public Date getDataCadastroProduto() {
		return dataCadastroProduto;
	}

	public void setDataCadastroProduto(Date dataCadastroProduto) {
		this.dataCadastroProduto = dataCadastroProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public String getNomeImagemProduto() {
		return nomeImagemProduto;
	}

	public void setNomeImagemProduto(String nomeImagemProduto) {
		this.nomeImagemProduto = nomeImagemProduto;
	}

	public CategoriaResponseDTO getCategoriaResponseDTO() {
		return categoriaResponseDTO;
	}

	public void setCategoriaResponseDTO(CategoriaResponseDTO categoriaResponseDTO) {
		this.categoriaResponseDTO = categoriaResponseDTO;
	}

	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}
	
	

}
