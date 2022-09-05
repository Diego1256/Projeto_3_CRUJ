package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarPessoa() {

		try {

			System.out.println("\n **** CADASTRO DE PESSOA *** \n");
			Pessoa pessoa = new Pessoa();

			System.out.print("Informe o nome da pessoa.........:");
			pessoa.setNome(scanner.nextLine());

			System.out.print("Informe o CPF da pessoa.........:");
			pessoa.setCpf(scanner.nextLine());

			System.out.print("Informe o Email da pessoa.........:");
			pessoa.setEmail(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.create(pessoa);

			System.out.println("\nPessoa cadastrada com sucesso!!");

		}

		catch (IllegalArgumentException e) {
			System.out.println("Erro na validação " + e.getMessage());
		}

		catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void atualizarPessoa() {

		try {

			System.out.println("\n *** ATUALIZAÇÃO DE PESSOA *** \n");

			System.out.print("Informe o id da pessoa.......: ");
			Integer id = Integer.parseInt(scanner.nextLine());

			// consultando no banco de dados a pessoa através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(id);

			// verificar se pessoa foi encontrado
			if (pessoa != null) {

				System.out.print("Informe o nome da pessoa.....: ");
				pessoa.setNome(scanner.nextLine());

				System.out.print("Informe o cpf da pessoa......: ");
				pessoa.setCpf(scanner.nextLine());

				System.out.print("Informe o email da pessoa....: ");
				pessoa.setEmail(scanner.nextLine());

				// atualizando no banco de dados
				pessoaRepository.update(pessoa);

				System.out.println("\nPessoa atualizada com sucesso.");
			} else {
				System.out.println("\nPessoa não encontrada. ID inválido.");
			}
		} catch (IllegalArgumentException e) {

			System.out.println("\nErro de validação: " + e.getMessage());
		} catch (Exception e) {

			System.out.println("\nErro: " + e.getMessage());
		}

	}

	public void excluirPessoa() {
		try {

			System.out.println("\n *** EXCLUSÃO DE PESSOA *** \n");

			System.out.print("Informe o id da pessoa.......: ");
			Integer id = Integer.parseInt(scanner.nextLine());

			// consultando no banco de dados a pessoa através do id
			PessoaRepository pessoaRepository = new PessoaRepository();
			Pessoa pessoa = pessoaRepository.findById(id);

			// verificando se a pessoa foi encontrada
			if (pessoa != null) {

				// excluindo pessoa no banco de dados
				pessoaRepository.delete(pessoa.getIdPessoa());

				System.out.println("\nPessoa excluída com sucesso.");
			} else {
				System.out.println("\nPessoa não encontrada. ID inválido.");
			}
		} catch (Exception e) {

			System.out.println("\nErro: " + e.getMessage());
		}
	}

	public void consultarPessoas() {
		try {
			System.out.println("\n *** CONSULTA DE PESSOAS *** \n");

			PessoaRepository pessoaRepository = new PessoaRepository();
			List<Pessoa> lista = pessoaRepository.findAll();

			for (Pessoa pessoa : lista) {
				System.out.println("Id da Pessoa....: " + pessoa.getIdPessoa());
				System.out.println("Nome............: " + pessoa.getNome());
				System.out.println("Email...........: " + pessoa.getEmail());
				System.out.println("Cpf.............: " + pessoa.getCpf());
				System.out.println("...");

			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
