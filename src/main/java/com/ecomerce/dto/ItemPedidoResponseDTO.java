package com.ecomerce.dto;

public class ItemPedidoResponseDTO {
	private Long idItemPedido;
	private Long quantidadeItemProduto;
	private Double precoVendaItemPedido;
	private Double percentualDescontoItemPedido;
	private Double valorBrutoItemPedido;
	private Double valorLiquidoItemPedido;
	private PedidoResponseDTO pedidoResponseDTO ;
	private ProdutoResponseDTO produdoResponseDTO ;
	public Long getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Long getQuantidadeItemProduto() {
		return quantidadeItemProduto;
	}
	public void setQuantidadeItemProduto(Long quantidadeItemProduto) {
		this.quantidadeItemProduto = quantidadeItemProduto;
	}
	public Double getPrecoVendaItemPedido() {
		return precoVendaItemPedido;
	}
	public void setPrecoVendaItemPedido(Double precoVendaItemPedido) {
		this.precoVendaItemPedido = precoVendaItemPedido;
	}
	public Double getPercentualDescontoItemPedido() {
		return percentualDescontoItemPedido;
	}
	public void setPercentualDescontoItemPedido(Double percentualDescontoItemPedido) {
		this.percentualDescontoItemPedido = percentualDescontoItemPedido;
	}
	public Double getValorBrutoItemPedido() {
		return valorBrutoItemPedido;
	}
	public void setValorBrutoItemPedido(Double valorBrutoItemPedido) {
		this.valorBrutoItemPedido = valorBrutoItemPedido;
	}
	public Double getValorLiquidoItemPedido() {
		return valorLiquidoItemPedido;
	}
	public void setValorLiquidoItemPedido(Double valorLiquidoItemPedido) {
		this.valorLiquidoItemPedido = valorLiquidoItemPedido;
	}
	public PedidoResponseDTO getPedidoResponseDTO() {
		return pedidoResponseDTO;
	}
	public void setPedidoResponseDTO(PedidoResponseDTO pedidoResponseDTO) {
		this.pedidoResponseDTO = pedidoResponseDTO;
	}
	public ProdutoResponseDTO getProdudoResponseDTO() {
		return produdoResponseDTO;
	}
	public void setProdudoResponseDTO(ProdutoResponseDTO produdoResponseDTO) {
		this.produdoResponseDTO = produdoResponseDTO;
	}
	

}
