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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;



@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@JsonFormat(shape = Shape.STRING, pattern= "dd/MM/yyyy")
	@Column(name = "data_pedido")
	@NotNull(message = "O campo está vazio")
	private Date dataPedido;
	
	@JsonFormat(shape = Shape.STRING, pattern= "dd/MM/yyyy")
	@Column(name = "data_entrega")
	@NotNull(message = "O campo está vazio")
	private Date dataEntrega;
	
	@JsonFormat(shape = Shape.STRING, pattern= "dd/MM/yyyy")
	@Column(name = "data_envio")
	@NotNull(message = "O campo está vazio")
	private Date dataEnvio;

	@JsonFormat(shape = Shape.STRING, pattern= "dd/MM/yyyy")
	@Column(name = "status")
	@NotNull(message = "O campo está vazio")
	private String status;

	@OneToMany(targetEntity = ItemPedido.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_pedido")
	private List<ItemPedido> itemPedido;

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
		return itemPedido;
	}

	public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
		this.itemPedido = itemPedidoList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
