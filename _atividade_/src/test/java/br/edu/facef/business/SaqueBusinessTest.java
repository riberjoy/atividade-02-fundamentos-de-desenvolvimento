package br.edu.facef.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class SaqueBusinessTest {
	
	@Mock
	private ContaDAO contaDAO;
	
	@SuppressWarnings("deprecation")
	@Test
	public void deveSacarUmValorComSucesso() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		SaqueBusiness saque = new SaqueBusiness(new ContaDAO());
		Conta novoSaldo = saque.sacar(contaMock, 10.00);
		System.out.println("Valor em conta apos saque: " + novoSaldo.getSaldo());

//		assertEquals((double)110.00d, (double)novoSaldo.getSaldo());
	}
	
	@Test
	public void naoDevePermitirSaqueQuandoOSaldoEstiverNegativo() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(-120.00);
		
		SaqueBusiness saque = new SaqueBusiness(contaDAO);
		Conta novoSaldo = saque.sacar(contaMock, 10.00);

		Assert.assertNull(novoSaldo.getNumeroConta());
	}
	
	@Test
	public void deveRetornarErroQuandoAContaEstiverNula() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta(null);
		contaMock.setSaldo(-120.00);
		
		SaqueBusiness saque = new SaqueBusiness(new ContaDAO());
		Conta novoSaldo = saque.sacar(null, 10.00);	
		Assert.assertNull(novoSaldo.getNumeroConta());
		
	}

}
