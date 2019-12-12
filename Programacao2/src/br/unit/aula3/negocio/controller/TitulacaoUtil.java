package br.unit.aula3.negocio.controller;

public class TitulacaoUtil {

	public static Titulacao definirTitulacao(int titulacao) {

		switch (titulacao) {
		case 1:
			return Titulacao.GRADUADO;
		case 2:
			return Titulacao.ESPECIALISTA;
		case 3:
			return Titulacao.MESTRE;
		case 4:
			return Titulacao.DOUTOR;
		default:
			System.out.println("Titulação inválida");
			return null;
		}
	}
}
