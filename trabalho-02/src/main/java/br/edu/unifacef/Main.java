package br.edu.unifacef;

import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Conta;
import br.edu.unifacef.business.ClienteBusiness;
import br.edu.unifacef.business.ContaBusiness;
import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.dao.ContaDAO;

public class Main {

	public static void main(String[] args) {

		System.out.println("Segundo trabalho da disciplina de Fundamentos de Desenvolvimento");
	
		System.out.println("------- Salvar conta -------");
		Conta novaConta = new Conta();
		novaConta.setAgencia("1234");
		novaConta.setNumeroConta("12346-78");
		novaConta.setSaldo(500.00);
		
		ContaBusiness contaBusiness = new ContaBusiness(new ContaDAO());
		Conta contaSalvo = contaBusiness.salvar(novaConta);
		System.out.println("Conta criada: " + contaSalvo);
		
		System.out.println("------- Salvar cliente -------");
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Maria Oliveira");
		novoCliente.setCpf("123.456.789-12");
		novoCliente.setTelefone("(11) 1111-1111");
		novoCliente.setScoreSerasa(100);
		novoCliente.setConta(contaSalvo);
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(new ClienteDAO());
		Cliente clienteSalvo = clienteBusiness.salvar(novoCliente);
		System.out.println("Cliente salvo: " + clienteSalvo);
	}
}
