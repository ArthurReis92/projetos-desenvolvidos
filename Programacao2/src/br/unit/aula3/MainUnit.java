package br.unit.aula3;

import java.util.Scanner;

import br.unit.aula3.negocio.controller.AlunoController;
import br.unit.aula3.negocio.controller.ProfessorController;
import br.unit.aula3.negocio.model.Aluno;
import br.unit.aula3.negocio.model.Professor;

public class MainUnit {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);

		AlunoController alunoController = new AlunoController();
		ProfessorController professorController = new ProfessorController();

		char resp;
		do {
			System.out.println("Digite um dos números abaixo para executar uma das operações: "
					+ "\n 1 - Portal de alunos" + "\n 2 - Portal de professores");
			int n = leitor.nextInt();

			switch (n) {
			case 1:

				do {
					System.out.println("Digite um dos números abaixo para executar uma das operações: "
							+ "\n 1 - Cadastrar novos alunos" + "\n 2 - Imprimir todos alunos cadastrados"
							+ "\n 3 - Modificar dados de um aluno cadastrado" + "\n 4 - Remover aluno cadastrado"
							+ "\n 5 - Consultar dados de algum aluno cadastrado");
					int m = leitor.nextInt();

					switch (m) {
					case 1:

						do {
							System.out.println("Digite matricula, nome e logradouro nesta ordem: ");

							long matricula = leitor.nextLong();
							leitor.nextLine();
							String nome = leitor.nextLine();
							String logradouro = leitor.nextLine();

							alunoController.inserir(matricula, nome, logradouro);

							System.out.println("Deseja cadastrar mais algum aluno? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("---------Alunos Cadastrados---------");
						System.out.println("------------------------------------");
						for (Aluno aluno : alunoController.retornarTodos()) {
							System.out.println(aluno);
						}
						break;

					case 3:

						do {

							System.out.println("Digite os novos dados de matricula, nome e logradouro (nesta ordem): ");

							long matricula = leitor.nextLong();
							leitor.nextLine();
							String nome = leitor.nextLine();
							String logradouro = leitor.nextLine();

							System.out.println("Digite a matrícula do aluno que você quer alterar: ");
							long matriculaAlterado = leitor.nextLong();

							alunoController.atualizar(matricula, nome, logradouro, matriculaAlterado);

							System.out.println("Deseja modificar mais algum aluno cadastrado? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite a matrícula do aluno que deseja remover");
							long matricula = leitor.nextLong();
							alunoController.remover(matricula);
							System.out.println("Deseja remover mais algum aluno cadastrado? (s/n)");
							resp = leitor.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:

						do {
							System.out.println("Digite a matrícula do aluno para realizar a consulta");
							long matricula = leitor.nextLong();

							System.out.println(alunoController.consultar(matricula));

							System.out.println("Deseja consultar mais algum aluno cadastrado? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					default:
						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("Deseja retornar ao menu de alunos? (s/n)");
					resp = leitor.next().charAt(0);
				} while (resp == 's');
				break;

			case 2:

				do {
					System.out.println("Digite um dos números abaixo para executar uma das operações: "
							+ "\n 1 - Cadastrar novos professores" + "\n 2 - Imprimir todos professores cadastrados"
							+ "\n 3 - Modificar dados de professor cadastrado" + "\n 4 - Remover professor cadastrado"
							+ "\n 5 - Consultar dados de algum professor cadastrado");
					int m = leitor.nextInt();

					switch (m) {
					case 1:

						do {
							System.out.println("Digite cpf, nome, titulação e logradouro (nesta ordem): ");

							long cpf = leitor.nextLong();
							leitor.nextLine();
							String nome = leitor.nextLine();
							int titulacao = leitor.nextInt();
							leitor.nextLine();
							String logradouro = leitor.nextLine();

							try {
								professorController.inserir(nome, cpf, logradouro, titulacao);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							System.out.println("Deseja cadastrar mais algum professor? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					case 2:
						System.out.println("---------Professores Cadastrados---------");
						System.out.println("------------------------------------");
						for (Professor professor : professorController.retornarTodos()) {
							System.out.println(professor);
						}
						break;

					case 3:

						do {

							System.out.println(
									"Digite os novos dados de cpf, nome, titulação e logradouro (nesta ordem): ");

							long cpf = leitor.nextLong();
							leitor.nextLine();
							String nome = leitor.nextLine();
							int titulacao = leitor.nextInt();
							leitor.nextLine();
							String logradouro = leitor.nextLine();

							System.out.println("Digite o cpf do professor que você quer alterar: ");
							long cpfAlterado = leitor.nextLong();

							professorController.atualizar(nome, cpf, logradouro, titulacao, cpfAlterado);

							System.out.println("Deseja modificar mais algum professor cadastrado? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					case 4:

						do {
							System.out.println("Digite cpf do professor que deseja remover");
							long cpf = leitor.nextLong();
							professorController.remover(cpf);
							System.out.println("Deseja remover mais algum professor cadastrado? (s/n)");
							resp = leitor.next().charAt(0);
						} while (resp == 's');
						break;

					case 5:
						do {
							System.out.println("Digite cpf do professor para realizar a consulta");
							long cpf = leitor.nextLong();

							System.out.println(professorController.consultar(cpf));

							System.out.println("Deseja consultar mais algum professor cadastrado? (s/n)");
							resp = leitor.next().charAt(0);

						} while (resp == 's');
						break;

					default:

						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("Deseja retornar ao menu de professores? (s/n)");
					resp = leitor.next().charAt(0);
				} while (resp == 's');
				break;

			}

			System.out.println("Deseja retornar ao menu Principal? (s/n)");
			resp = leitor.next().charAt(0);
		} while (resp == 's');
		leitor.close();

	}

}
