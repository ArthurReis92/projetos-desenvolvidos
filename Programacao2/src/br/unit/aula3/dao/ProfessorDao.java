package br.unit.aula3.dao;

import java.util.ArrayList;
import java.util.List;

import br.unit.aula3.negocio.controller.Titulacao;
import br.unit.aula3.negocio.model.Professor;

public class ProfessorDao {
	private List<Professor> professores;

	public ProfessorDao() {
		professores = new ArrayList<>();
	}

	public void inserir(Professor professor) {
		professores.add(professor);
	}

	public Professor consultar(long cpf) {

		for (Professor professor : professores) {
			if (professor.getCpf() == cpf) {
				return professor;
			}
		}
		return null;
	}

	public int retornarTotalDoutor() {
		int qtdDoutor = 0;
		for (Professor professor : professores) {
			if (professor.getTitulacao() == Titulacao.DOUTOR) {
				qtdDoutor++;
			}
		}
		return qtdDoutor;
	}

	public List<Professor> retornarTodos() {
		return professores;
	}

	public void remover(long cpf) {
		professores.remove(consultar(cpf));
	}

	public int qtdTotalProfessor() {
		return professores.size();
	}

	public void atualizar(long cpfAlterado, Professor prof) {
		professores.set(professores.indexOf(consultar(cpfAlterado)), prof);
	}

}
