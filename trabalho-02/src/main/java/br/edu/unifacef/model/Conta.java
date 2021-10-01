package br.edu.unifacef.model;

public class Conta {
	
	private Long id;
	
	private String numeroConta;
	
	private Double saldo;
	
	private String agencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", agencia=" + agencia + "]";
	}
}
