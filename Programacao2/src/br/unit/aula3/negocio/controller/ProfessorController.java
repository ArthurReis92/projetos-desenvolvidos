package br.unit.aula3.negocio.controller;

import java.util.List;

import br.unit.aula3.dao.ProfessorDao;
import br.unit.aula3.negocio.model.Endereco;
import br.unit.aula3.negocio.model.Professor;

public class ProfessorController {
	ProfessorDao professorDao;

	public ProfessorController() {
		professorDao = new ProfessorDao();
	}
	
	public void inserir(String nome, long cpf, String logradouro, int titulacao) {
		Professor professor = new Professor();
		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);

		professor.setCpf(cpf);
		professor.setNome(nome);
		professor.setTitulacao(TitulacaoUtil.definirTitulacao(titulacao));
		professor.setEndereco(endereco);

		if (professorDao.consultar(cpf) == null) {
			if ((professor.getTitulacao() != Titulacao.DOUTOR) || (professorDao.retornarTotalDoutor() < 1)) {
				professorDao.inserir(professor);
				System.out.println("Professor cadastrado com sucesso!");
			} else {
				System.out.println("O quadro de Doutores está cheio!");
			}
		} else {
			System.out.println("Professor já está cadastrado!");
		}

	}

	public List<Professor> retornarTodos() {
		if (professorDao == null) {
			System.out.println("Não há professores cadastrados");
			return null;
		} else {
			return professorDao.retornarTodos();
		}
	}

	public void atualizar(String nome, long cpf, String logradouro, int titulacao, long cpfAlterado) {
		Professor professor = new Professor();
		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);

		professor.setCpf(cpf);
		professor.setNome(nome);
		professor.setEndereco(endereco);
		professor.setTitulacao(TitulacaoUtil.definirTitulacao(titulacao));

		if(professorDao.consultar(cpf) != null) {
			professorDao.atualizar(cpfAlterado, professor);
		} else {
			System.out.println("Esse professor não existe para ser modificado");
		}
	}

	public Professor consultar(long cpf) {
		return professorDao.consultar(cpf);
	}

	public void remover(long cpf) {
		if (professorDao.consultar(cpf) != null) {
			professorDao.remover(cpf);
		} else {
			System.out.println("Professor não pode ser removido pois não está cadastrado");
		}
	}

}
