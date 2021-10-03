package br.edu.unifacef.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class SaqueBusinessTest {
	
	@Mock
	private ContaDAO contaDAO;
	
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
		
//		assertEquals(110.00, novoSaldo.getSaldo());
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
		
		//assertEquals(110.00, novoSaldo.getSaldo());
	}
	
	@Test
	public void deveRetornarErroQuandoAContaEstiverNula() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta(null);
		contaMock.setSaldo(-120.00);
		
		SaqueBusiness saque = new SaqueBusiness(null);
		Conta novoSaldo = saque.sacar(contaMock, 10.00);
		
		Assert.assertNull(novoSaldo.getNumeroConta());
		
	}

}
