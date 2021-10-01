package br.edu.unifacef.business;

import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Conta;

public class ClienteBusiness {
private ClienteDAO clienteDAO;
	
	public ClienteBusiness(ClienteDAO dao) {
		this.clienteDAO = dao;
	}
	
	public Cliente salvar(Cliente cliente) {
		
		if(cliente == null || cliente.getNome().isEmpty())
			throw new RuntimeException("Nome requerido");
		
		if(cliente.getNome().isEmpty())
			throw new RuntimeException("Nome requerido");
		
		if(cliente.getTelefone().isEmpty())
			throw new RuntimeException("Telefone requerido");
		
		if(cliente.getCpf().isEmpty())
			throw new RuntimeException("CPF requerido");
		
		if(cliente.getScoreSerasa() == null)
			throw new RuntimeException("Score Serasa requerido");
		
		if(cliente.getConta() == null)
			throw new RuntimeException("Conta requerido");
		
		return this.clienteDAO.salvar(cliente);
	}
}
