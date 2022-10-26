package com.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.dto.ItemPedidoResponseDTO;
import com.ecomerce.exception.ResourceNotFoundException;
import com.ecomerce.model.ItemPedido;
import com.ecomerce.model.Pedido;
import com.ecomerce.repositories.ItemPedidoRepository;
@Service
public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository repositorio;
	
	public List<ItemPedido> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<ItemPedido> obterPorId(Long id){
		
		Optional<ItemPedido> optItemPedido = repositorio.findById(id);
		
		if(optItemPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar o itemPedido " + id);
		}
		
		return optItemPedido;
	}
	
	public ItemPedido atualizar(Long id, ItemPedido itemPedido) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		itemPedido.setIdItemPedido(id);
		return repositorio.save(itemPedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	public ItemPedido cadastrar(ItemPedido itemPedido) {
		
		itemPedido.setIdItemPedido(null);		
		return itemPedido = repositorio.save(itemPedido);
	}
	
	public ItemPedido ConverteDTOToEntidade(ItemPedidoResponseDTO itemPedidoDTO) {
        ItemPedido itemPedido = new ItemPedido();
        Pedido pedido = new Pedido();
        pedido.setIdPedido(itemPedidoDTO.getIdItemPedido());
        itemPedido.setIdItemPedido(itemPedidoDTO.getIdItemPedido());
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidadeItemProduto());
        itemPedido.setPrecoVenda(itemPedidoDTO.getPrecoVendaItemPedido());
        itemPedido.setPercentualDesconto(itemPedidoDTO.getPercentualDescontoItemPedido());
        itemPedido.setValorBruto(itemPedidoDTO.getValorBrutoItemPedido());
        itemPedido.setValorLiquido(itemPedidoDTO.getValorLiquidoItemPedido());   
        System.out.println("Parou aqui" + itemPedido.getProduto().getIdProduto());
        return itemPedido;
    }

    public ItemPedidoResponseDTO converterEntityToDTO(ItemPedido itemPedido) {
        ItemPedidoResponseDTO itemPedidoDTO = new ItemPedidoResponseDTO();
        itemPedidoDTO.setIdItemPedido(itemPedido.getIdItemPedido());
        itemPedidoDTO.setQuantidadeItemProduto(itemPedido.getQuantidade());
        itemPedidoDTO.setPrecoVendaItemPedido(itemPedido.getPrecoVenda());
        itemPedidoDTO.setPercentualDescontoItemPedido(itemPedido.getPercentualDesconto());
        itemPedidoDTO.setValorBrutoItemPedido(itemPedido.getValorBruto());
        itemPedidoDTO.setValorLiquidoItemPedido(itemPedido.getValorLiquido());

        return itemPedidoDTO;
    }
}

