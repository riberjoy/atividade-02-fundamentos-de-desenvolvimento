package br.edu.unifacef.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.unifacef.dao.ClienteDAO;
import br.edu.unifacef.dao.ContaDAO;
import br.edu.unifacef.model.Cliente;
import br.edu.unifacef.model.Conta;

@RunWith(MockitoJUnitRunner.class)
public class ClienteBusinessTest {

	@Mock
	private ClienteDAO clienteDAO;
	
	
	private ContaDAO contaDAO;
	
	@Test
	public void deveSalvarClienteComSucesso() {
		
		Conta contaMock = new Conta();
		contaMock.setId(100L);
		contaMock.setAgencia("0003");
		contaMock.setNumeroConta("020369854");
		contaMock.setSaldo(250.00);
		
		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(670);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(contaMock);
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Maria Silva");
		novoCliente.setScoreSerasa(680);
		novoCliente.setCpf("11111111111");
		novoCliente.setTelefone("(16)99999-9999");
		novoCliente.setConta(contaMock);
		
		Mockito.when(clienteDAO.salvar(novoCliente)).thenReturn(clienteMock);
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(clienteDAO);
		
		Cliente clienteSalvo = clienteBusiness.salvar(novoCliente);
		
		System.out.println(clienteSalvo);
		
		assertEquals(new Long(123), clienteSalvo.getId());
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveSalvarClienteComNomeVazio() {
		
		Conta contaMock = new Conta();
		contaMock.setId(100L);
		contaMock.setAgencia("0003");
		contaMock.setNumeroConta("020369854");
		contaMock.setSaldo(250.00);
		
		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(670);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(contaMock);
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(null);
		novoCliente.setScoreSerasa(680);
		novoCliente.setCpf("11111111111");
		novoCliente.setTelefone("(16)99999-9999");
		novoCliente.setConta(contaMock);
		
		Mockito.when(clienteDAO.salvar(clienteMock)).thenReturn(novoCliente).thenThrow(RuntimeException.class);
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(clienteDAO);
		
		Cliente clienteSalvo = clienteBusiness.salvar(novoCliente);
		
		System.out.println(clienteSalvo);
		
		assertEquals(null, clienteSalvo.getNome());
	}
	
	@Test(expected = RuntimeException.class)
	public void naoDeveSalvarClienteSemConta() {
		

		Cliente clienteMock = new Cliente();
		clienteMock.setId(123L);
		clienteMock.setNome("Maria Silva");
		clienteMock.setScoreSerasa(670);
		clienteMock.setCpf("11111111111");
		clienteMock.setTelefone("(16)99999-9999");
		clienteMock.setConta(null);
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome(null);
		novoCliente.setScoreSerasa(680);
		novoCliente.setCpf("11111111111");
		novoCliente.setTelefone("(16)99999-9999");
		novoCliente.setConta(null);
		
		Mockito.when(clienteDAO.salvar(novoCliente)).thenReturn(clienteMock).thenThrow(RuntimeException.class);
		
		ClienteBusiness clienteBusiness = new ClienteBusiness(clienteDAO);
		
		Cliente clienteSalvo = clienteBusiness.salvar(novoCliente);
		
		System.out.println(clienteSalvo);
		
		assertEquals(null, clienteSalvo.getConta());
	}
}
