package br.edu.facef.business;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.facef.dao.ContaDAO;
import br.edu.facef.model.Cliente;
import br.edu.facef.model.Conta;

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
		
		Assert.assertEquals("121", novoSaldo.getNumeroConta());
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
		
		Assert.assertNull(novoSaldo.getNumeroConta());
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
