package br.unit.aula3.dao;

import java.util.ArrayList;
import java.util.List;

import br.unit.aula3.negocio.model.Aluno;

public class AlunoDao {
	private List<Aluno> alunos;

	public AlunoDao() {
		alunos = new ArrayList<>();
	}

	public void inserir(Aluno aluno) {
		alunos.add(aluno);
	}

	public Aluno consultar(long matricula) {

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula() == matricula) {
				return aluno;
			}
		}
		return null;
	}

	public int contarAlunos() {
		return alunos.size();
	}

	public void remover(long matricula) {
		alunos.remove(consultar(matricula));
	}

	public List<Aluno> buscarTodos() {
		return alunos;
	}

	public List<Aluno> retornarTodos() {
		return alunos;
	}

	public void atualizar(long matriculaAlterado, Aluno aluno) {
		alunos.set(alunos.indexOf(consultar(matriculaAlterado)), aluno);		
	}

}
