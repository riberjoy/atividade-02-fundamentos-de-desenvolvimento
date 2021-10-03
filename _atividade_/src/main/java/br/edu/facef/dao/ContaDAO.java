package br.edu.facef.dao;

import br.edu.facef.model.Conta;

public class ContaDAO {
	public Conta salvar(final Conta conta) {
		conta.setId(1234L);
		return conta;
	}
	
	public Conta alterar(final Conta conta) {
		//Salvando na base de dados 
		return conta;
	}
}
