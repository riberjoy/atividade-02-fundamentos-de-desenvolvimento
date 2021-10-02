package br.edu.facef.busines;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.edu.facef.business.Calculos;

public class CalculosTest {
	
	private Calculos calculos;
	
	@Before
	public void init() {
		this.calculos = new Calculos();
	}

	@Test
	public void deveSomaNumerosPositivos() {
		Integer valor1 = 5;
		Integer valor2 = 10;
		Integer valorEsperado = 15;
		
		assertEquals(valorEsperado, this.calculos.somar(valor1, valor2));
		
	}
	
	@Test
	public void deveSomaNumerosNegativos() {
		Integer valor1 = -5;
		Integer valor2 = -10;
		Integer valorEsperado = -15;
		
		assertEquals(valorEsperado, this.calculos.somar(valor1, valor2));
		
	}

}
