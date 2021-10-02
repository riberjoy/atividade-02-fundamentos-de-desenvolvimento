package br.edu.unifacef.business;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Conta;

public class ContaBusiness {
	private ContaDAO contaDAO;

	public ContaBusiness(ContaDAO dao) {
		this.contaDAO = dao;
	}
	
	public Conta salvar(Conta conta) {
		if(conta == null )
			throw new RuntimeException("Nenhuma conta encontrada");
		
		if(conta.getNumeroConta().isEmpty())
			throw new RuntimeException("Numero da conta encontrada");
		
		if(conta.getAgencia().isEmpty())
			throw new RuntimeException("Agencia da conta encontrada");
		
		return this.contaDAO.salvar(conta);
	}
	
	public Conta alterar(Conta conta) {
		
		if(conta == null )
			throw new RuntimeException("Nenhuma conta encontrada");
		
		if(conta.getNumeroConta().isEmpty())
			throw new RuntimeException("Numero da conta encontrada");
		
		if(conta.getAgencia().isEmpty())
			throw new RuntimeException("Agencia da conta encontrada");
			 
		return this.contaDAO.alterar(conta);
	}
}
