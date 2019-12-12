package br.unit.aula3.negocio.model;

import br.unit.aula3.negocio.controller.Titulacao;

public class Professor {
	private String nome;
	private long cpf;
	private Endereco endereco;
	private Titulacao titulacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Titulacao getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cpf ^ (cpf >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return " - Nome: " + nome + " \n - CPF: " + cpf+ " \n - Titulacao: " + titulacao + " \n - Endereco: " + endereco + "\n------------------";
	}
	
	
}
