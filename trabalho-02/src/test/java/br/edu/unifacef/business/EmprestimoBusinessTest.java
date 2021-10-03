package br.edu.unifacef.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class EmprestimoBusinessTest {

	
	private ContaDAO contaDAO;
	
	@Test
	public void deveConcederEmprestimoComSucesso() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(670);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(contaMock);
		
		EmprestimoBusiness emprestimo = new EmprestimoBusiness(new ContaDAO());
		Conta novoSaldo = emprestimo.solicitarEmprestimo(contaMock, clienteMock, 500.00);
		System.out.println("Novo saldo: "+novoSaldo.getSaldo());
//		assertEquals(620.00, novoSaldo.getSaldo());	
	}
	
	@Test
	public void naoDeveConcederEmprestimoParaClienteComScoreSerasaBaixo() {
		
		Conta contaMock = new Conta();
		contaMock.setId(1L);
		contaMock.setAgencia("111");
		contaMock.setNumeroConta("121");
		contaMock.setSaldo(120.00);
		
		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(99);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(contaMock);
		
		EmprestimoBusiness emprestimo = new EmprestimoBusiness(contaDAO);
		Conta novoSaldo = emprestimo.solicitarEmprestimo(contaMock, clienteMock, 500.00);
		
		assertEquals(new Double(620.00), novoSaldo.getSaldo());	
	}
	
	@Test
	public void deveRetornarErroAoPassarContaNula() {
		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(99);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(null);
		
		EmprestimoBusiness emprestimo = new EmprestimoBusiness(contaDAO);
		Conta novoSaldo = emprestimo.solicitarEmprestimo(null, clienteMock, 500.00);
		Assert.assertNull(novoSaldo.getNumeroConta());
	}
}
