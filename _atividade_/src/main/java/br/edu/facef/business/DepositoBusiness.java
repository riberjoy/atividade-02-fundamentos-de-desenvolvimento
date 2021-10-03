package br.edu.facef.business;

import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Conta;

public class DepositoBusiness {
	private ContaDAO contaDAO;

	public DepositoBusiness(ContaDAO dao) {
		this.contaDAO = dao;
	}
	
	public Conta deposito(Conta conta, Double valor ) {
		if(conta == null ) 
			throw new RuntimeException("Conta não encontrada.");
		
		conta.setSaldo(conta.getSaldo() + valor);
		
		return this.contaDAO.alterar(conta);
	}
}
