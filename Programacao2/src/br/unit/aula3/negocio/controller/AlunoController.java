package br.unit.aula3.negocio.controller;

import java.util.List;

import br.unit.aula3.dao.AlunoDao;
import br.unit.aula3.negocio.model.Aluno;
import br.unit.aula3.negocio.model.Endereco;


public class AlunoController {
	private AlunoDao alunoDao;

	public AlunoController() {
		alunoDao = new AlunoDao();
	}

	public void inserir(long matricula, String nome, String logradouro) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setEndereco(endereco);

		if (alunoDao.consultar(matricula) == null) {
			alunoDao.inserir(aluno);
			System.out.println("Aluno cadastrado com sucesso!");
		} else {
			System.out.println("Um aluno com essa matrícula já foi cadastrado!");
		}
	}

	public void remover(long matricula) {
		if (alunoDao.consultar(matricula) != null) {
			alunoDao.remover(matricula);
			System.out.println("Aluno removido com sucesso!");
		} else {
			System.out.println("O aluno não pode ser removido, pois não existe!");
		}
	}

	public List<Aluno> buscarTodos() {
		if (alunoDao.contarAlunos() > 0) {
			return alunoDao.buscarTodos();
		} else {
			return null;
		}
	}

	public List<Aluno> retornarTodos() {
		if (alunoDao == null) {
			System.out.println("Não há alunos cadastrados");
			return null;
		} else {
			return alunoDao.retornarTodos();
		}
	}

	public void atualizar(long matricula, String nome, String logradouro, long matriculaAlterado) {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);

		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setEndereco(endereco);
		
		if(alunoDao.consultar(matricula) != null) {
			alunoDao.atualizar(matriculaAlterado, aluno);
		} else {
			System.out.println("Esse aluno não existe para ser modificado");
		}
		
	}

	public Aluno consultar(long matricula) {
		return alunoDao.consultar(matricula);
	}
}
