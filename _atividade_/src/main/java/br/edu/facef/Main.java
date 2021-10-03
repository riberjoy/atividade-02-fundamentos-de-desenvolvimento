package br.edu.facef;

import br.edu.facef.business.ClienteBusiness;
import br.edu.facef.business.ContaBusiness;
import br.edu.facef.business.DepositoBusiness;
import br.edu.facef.business.SaqueBusiness;
import br.edu.facef.dao.ClienteDAO;
import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Conta;

public class Main {

	public static void main(String[] args) {

		System.out.println("*");
		System.out.println("*");
		
		System.out.println("Segundo trabalho da disciplina de Fundamentos de Desenvolvimento");

		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		System.out.println("------- Salvar conta -------");
		Conta novaConta = new Conta();
		novaConta.setAgencia("1234");
		novaConta.setNumeroConta("12346-78");
		novaConta.setSaldo(500.00);		
		ContaBusiness contaBusiness = new ContaBusiness(new ContaDAO());
		Conta contaSalvo = contaBusiness.salvar(novaConta);
		System.out.println("Conta criada: " + contaSalvo);
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		
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
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		
		System.out.println("------- Realizar deposito -------");
		System.out.println("Valor atual da conta: " + contaSalvo.getSaldo());
		DepositoBusiness novoDeposito = new DepositoBusiness(new ContaDAO());
		Double saldoDeposito = 200.50;
		System.out.println("Valor para deposito: " + saldoDeposito);
		Conta novoValorDeposito = novoDeposito.deposito(contaSalvo, saldoDeposito);
		System.out.println("Deposito realizado com sucesso, valor em conta: " + novoValorDeposito.getSaldo());
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		
		System.out.println("------- Realizar Saque -------");
		System.out.println("Valor atual da conta: " + contaSalvo.getSaldo());
		SaqueBusiness novoSaque = new SaqueBusiness(new ContaDAO());
		Double saldoSaque = 150.00;
		System.out.println("Valor do saque: " + saldoSaque);
		Conta novoValor = novoSaque.sacar(contaSalvo, saldoSaque);
		System.out.println("Saque realizado com sucesso, valor em conta: " + novoValor.getSaldo());
		System.out.println("*");
		System.out.println("*");
		System.out.println("*");
		
		System.out.println("------- Realizar Emprestimo -------");
		System.out.println("Valor atual da conta: " + contaSalvo.getSaldo());
		DepositoBusiness novoEmprestimo = new DepositoBusiness(new ContaDAO());
		Double saldoEmprestimo = 5000.00;
		System.out.println("Valor do emprestimo: " + saldoEmprestimo);
		Conta novoValorConta = novoEmprestimo.deposito(contaSalvo, saldoEmprestimo);
		System.out.println("Empretimo realizado com sucesso, novo valor em conta: " + novoValorConta.getSaldo());
	}
}
