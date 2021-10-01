package br.edu.unifacef.dao;

import br.edu.unifacef.model.Cliente;

public class ClienteDAO {
	public Cliente salvar(final Cliente cliente) {
		cliente.setId(1234L);
		return cliente;
	}
}
