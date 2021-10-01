package br.edu.unifacef.business;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Conta;

public class DepositoBusiness {
	private ContaDAO contaDAO;

	public DepositoBusiness(ContaDAO dao) {
		this.contaDAO = dao;
	}
	
	public Conta deposito(Conta conta, Double valor ) {
		if(conta == null ) 
			throw new RuntimeException("Conta n�o encontrada.");
		
		conta.setSaldo(conta.getSaldo() + valor);
		
		return this.contaDAO.alterar(conta);
	}
}
