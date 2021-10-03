package br.edu.facef.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class DepositoBusinessTest {
	
	
	@Mock
	private ContaDAO contaDAO;
	
	@Test
	public void deveRealizarDepositoComSucesso() {
		Conta contaMock = new Conta();
		contaMock.setId(100L);
		contaMock.setAgencia("0003");
		contaMock.setNumeroConta("020369854");
		contaMock.setSaldo(250.00);
		
		Double valor = 500.00;
	
		DepositoBusiness deposito = new DepositoBusiness(new ContaDAO());
		Conta conta = deposito.deposito(contaMock, valor);
		System.out.println("Novo valor em conta: " + conta.getSaldo());
		
		
	}
}
