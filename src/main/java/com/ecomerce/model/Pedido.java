package com.ecomerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@Column(name = "data_pedido")
	private Date dataPedido;
	
	@Column(name = "data_entrega")
	private Date dataEntrega;
	
	@Column(name = "data_envio")
	private Date dataEnvio;

	@Column(name = "status")
	private String status;

	@OneToMany(targetEntity = ItemPedido.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_pedido")
	private List<ItemPedido> itemPedidoList;

	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;
	
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

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemPedido> getItemPedidoList() {
		return itemPedidoList;
	}

	public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
		this.itemPedidoList = itemPedidoList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
