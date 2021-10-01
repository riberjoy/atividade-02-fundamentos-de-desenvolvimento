package br.edu.unifacef.business;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Conta;

public class EmprestimoBusiness {
	private ContaDAO contaDAO;
	
	public EmprestimoBusiness(ContaDAO dao) {
		this.contaDAO = dao;
	}
	
	public Conta solicitarEmprestimo(Conta conta, Cliente cliente ) {
		if(conta == null)
			throw new RuntimeException("Conta requerido.");
		if(cliente == null)
			throw new RuntimeException("Cliente requerido.");
		if(cliente.getScoreSerasa() < 100 )
			throw new RuntimeException("Emprestimo indisponível");
		
		return this.contaDAO.alterar(conta);
	}
}
