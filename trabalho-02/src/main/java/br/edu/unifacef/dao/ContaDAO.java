package br.edu.unifacef.dao;

import br.edu.unifacef.model.Conta;

public class ContaDAO {
	public Conta salvar(final Conta conta) {
		conta.setId(1234L);
		return conta;
	}
	
	public Conta alterar(final Conta conta) {
		conta.setSaldo(500.00);
		return conta;
	}
}
