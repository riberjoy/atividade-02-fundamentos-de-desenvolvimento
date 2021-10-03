package br.edu.facef.business;

import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Conta;

public class EmprestimoBusiness {
	private ContaDAO contaDAO;
	
	public EmprestimoBusiness(ContaDAO dao) {
		this.contaDAO = dao;
	}
	
	public Conta solicitarEmprestimo(Conta conta, Cliente cliente, Double valor ) {
		if(conta == null)
			return new Conta();
//			throw new RuntimeException("Conta requerido.");
		if(cliente == null)
			return new Conta();
//			throw new RuntimeException("Cliente requerido.");
		if(cliente.getScoreSerasa() < 100 ) {
			return new Conta();
//			throw new RuntimeException("Emprestimo indisponível");
		}else {
			conta.setSaldo(conta.getSaldo() + valor);
		}
		return this.contaDAO.alterar(conta);
	}
}
