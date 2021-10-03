package br.edu.unifacef.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class ContaBusinessTest {

	@Mock
	private ContaDAO contaDAO;
	
	@Test
	public void deveSalvarUmaContaComSucesso() {
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Mockito.when(contaDAO.salvar(contaMock)).thenReturn(contaMock);
		
		ContaBusiness contaBusiness = new ContaBusiness(contaDAO);
		
		Conta contaSalva = contaBusiness.salvar(contaMock);
		
		System.out.println(contaSalva);
		
		assertEquals(new Long(1L), contaSalva.getId());
	}
	
	
	@Test
	public void deveAtualizarAAgenciaDeUmaContaComSucesso() {
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Conta novaConta = new Conta();
		contaMock.setAgencia("235");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Mockito.when(contaDAO.salvar(contaMock)).thenReturn(novaConta);
		
		ContaBusiness contaBusiness = new ContaBusiness(contaDAO);
		
		Conta contaAtualizada = contaBusiness.alterar(contaMock);
		
		System.out.println(contaAtualizada);
		
		assertEquals("235", contaAtualizada.getAgencia());
	}
	
	@Test(expected = RuntimeException.class)
	public void deveRetornarErroAoAlterarUmaConta() {
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Conta novaConta = new Conta();
		novaConta.setAgencia(null);
		novaConta.setNumeroConta("121");
		novaConta.setSaldo(120.00);
		
		Mockito.when(contaDAO.salvar(contaMock)).thenThrow(RuntimeException.class);
		
		ContaBusiness contaBusiness = new ContaBusiness(contaDAO);
		
		Conta contaAtualizada = contaBusiness.alterar(contaMock);
		
		System.out.println(contaAtualizada);
		
		assertEquals("235", contaAtualizada.getAgencia());
	}
}
