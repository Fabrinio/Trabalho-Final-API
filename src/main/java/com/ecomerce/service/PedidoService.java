package com.ecomerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.MensagemEmail;
import com.ecomerce.model.Pedido;
import com.ecomerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repositorio;
	@Autowired
	private EmailService emailService;
	
	public List<Pedido> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Pedido> obterPorId(Long id){
		
		Optional<Pedido> optPedido = repositorio.findById(id);
		
		if(optPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o pedido " + id);
		}
		
		return optPedido;
	}
	
	public Pedido atualizar(Long id, Pedido pedido) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		pedido.setIdPedido(id);
		return repositorio.save(pedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
public Pedido cadastrar(Pedido pedido) {
		
		var destinatarios = new ArrayList<String>();
		destinatarios.add("itsfabrinio@gmail.com");
		
		String mensagem = "<h1 style=\"color:red; text-align: center\">  Pedido feito com sucesso! 😍😍😍😍😍😍</h1>" + "<p style=\"text-align: center\">Seu pedido está " + pedido.getStatus() +
				" e logo estará na sua casa!</p> " + "<p <p style=\"text-align: center\">A previsão de entrega é "+pedido.getDataEntrega()+"</p>";
		
		MensagemEmail email = new MensagemEmail(
				"Pedido feito com sucesso!",
				mensagem, 
				"turma05serratec@gmail.com",
				destinatarios);
		
		emailService.enviar(email);
		
		return pedido = repositorio.save(pedido);
	}
}
