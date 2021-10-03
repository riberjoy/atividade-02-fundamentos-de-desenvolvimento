package br.edu.facef.model;

public class Cliente {
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;
	
	private Integer scoreSerasa;
	
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getScoreSerasa() {
		return scoreSerasa;
	}

	public void setScoreSerasa(Integer scoreSerasa) {
		this.scoreSerasa = scoreSerasa;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", scoreSerasa="
				+ scoreSerasa + ", conta=" + conta + "]";
	}
}
