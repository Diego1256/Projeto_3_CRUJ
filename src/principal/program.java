package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class program {
	public static void main(String[] args) {
		PessoaController pessoaController = new PessoaController();
		Scanner scanner = new Scanner(System.in);
		try {

			System.out.println("(1) Cadastrar pessoa");
			System.out.println("(2) Atualizar pessoa");
			System.out.println("(3) Excluir pessoa");
			System.out.println("(4) Consultar pessoa");

			System.out.println("\nEscolha a opção desejada:");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {

			case 1:
				pessoaController.cadastrarPessoa();
				break;

			case 2:
				pessoaController.atualizarPessoa();
				break;

			case 3:
				pessoaController.excluirPessoa();
				break;

			case 4:
				pessoaController.consultarPessoas();
				break;

			default:
				System.out.println("\nOpção Inválida");
			}

		}

		catch (Exception e) {

			System.out.println("\nErro: " + e.getMessage());

		} finally {
			System.out.println("\n Deseja continuar, se digite (S) se não digite (N)");
			String opcao = scanner.nextLine();
			
			if(opcao.equalsIgnoreCase("S")) {
				main(args); //recursividade
			}
			else {
				System.out.println("\nFIM DO PROGRAMA!");
			}

		}
	}

}
