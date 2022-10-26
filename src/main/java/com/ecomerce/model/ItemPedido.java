package com.ecomerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long idItemPedido;

	@Column(name = "quantidade")
	@NotNull(message = "O campo está vazio")
	private Long quantidade;

	@Column(name = "preco_venda")
	private Double precoVenda;

	@Column(name = "percentual_desconto")
	private Double percentualDesconto;

	@Column(name = "valor_bruto")
	private Double valorBruto;

	@Column(name = "valor_liquido")
	private Double valorLiquido;

	@ManyToOne 
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private Produto produto;


	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public String toString() {
		return "Produto = " + produto.getNome() + "<br>"
				+ "Quantidade = " + quantidade + "<br>"
				+ "Preco Venda = R$" + String.format("%.2f", precoVenda) + "<br>"
				+ "Valor Bruto Pedido = R$" + String.format("%.2f", valorBruto) + "<br>" 
				+ "Percentual Desconto = " + percentualDesconto + "%<br>"				  
				+ "Valor Liquido Pedido = R$" + String.format("%.2f", valorLiquido) + "<br>";
	}
}
