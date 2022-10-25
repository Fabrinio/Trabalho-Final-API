package com.ecomerce.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class PedidoResponseDTO {
private Long idPedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEntregaPedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEnvioPedido;
	
	private Boolean statusPedido;
	
	private ClienteResponseDTO clienteResponseDTO;
	
	private List<ItemPedidoResponseDTO> itemPedidoList;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntregaPedido() {
		return dataEntregaPedido;
	}

	public void setDataEntregaPedido(Date dataEntregaPedido) {
		this.dataEntregaPedido = dataEntregaPedido;
	}

	public Date getDataEnvioPedido() {
		return dataEnvioPedido;
	}

	public void setDataEnvioPedido(Date dataEnvioPedido) {
		this.dataEnvioPedido = dataEnvioPedido;
	}

	public Boolean getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(Boolean statusPedido) {
		this.statusPedido = statusPedido;
	}

	public ClienteResponseDTO getClienteResponseDTO() {
		return clienteResponseDTO;
	}

	public void setClienteResponseDTO(ClienteResponseDTO clienteResponseDTO) {
		this.clienteResponseDTO = clienteResponseDTO;
	}

	public List<ItemPedidoResponseDTO> getItemPedidoList() {
		return itemPedidoList;
	}

	public void setItemPedidoList(List<ItemPedidoResponseDTO> itemPedidoList) {
		this.itemPedidoList = itemPedidoList;
	}


}
