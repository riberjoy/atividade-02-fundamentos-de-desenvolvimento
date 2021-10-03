package br.edu.facef.dao;

import br.edu.facef.model.Cliente;

public class ClienteDAO {
	public Cliente salvar(final Cliente cliente) {
		cliente.setId(1234L);
		return cliente;
	}
}
