import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class App {

	static Collection<Conta> rep = new ArrayList<Conta>();
	static Collection<Login> rep2 = new ArrayList<Login>();

	public static void main(String[] args) {
		int opcao = 0;
		boolean condicao = false;
		Scanner s = new Scanner(System.in);

		Login admin = new Login("admin", "admin", "rua admin", "admin");
		rep2.add(admin);

		while (condicao == false) {
			condicao = login();
		}

		while (opcao != 9) {
			System.out.println("\nSistema Bancário Tabajara\n");
			System.out.println("Digite a sua opção:");
			System.out.println("1 - Cadastrar conta");
			System.out.println("2 - Consultar conta");
			System.out.println("3 - Alterar conta");
			System.out.println("4 - Remover conta");
			System.out.println("5 - Exibir todas as contas");
			System.out.println("6 - Cadastrar login");
			System.out.println("7 - Consultar logins");
			System.out.println("8 - Alterar login");

			System.out.println("9 - Sair do sistema");
			System.out.print("Sua opção: ");

			opcao = s.nextInt();
			switch (opcao) {
				case 1: // cadastrar conta
					inserirConta();
					break;
				case 2: // consultar conta
					consultarConta();
					break;
				case 3: // alterar conta
					alterarConta();
					break;
				case 4: // remover conta
					removerConta();
					break;
				case 5: // Exibe todas as contas
					exibirTodasAsContas();
					break;
				case 6: // Exibe todas as contas
					cadastrarLogin();
					break;
				case 7: // Exibe todas as contas
					consultarLogin();
					break;
				case 8:
					alterarLogin();
					break;
			}
			try {
				Thread.sleep(3000);
			}

			catch (Exception e) {
				e.printStackTrace();
			}

		}
		// encerramento do programa...
		System.out.println("Tchau...");
	}

	public static String Leia(String param) {
		java.io.DataInputStream dado_lido;
		String stemporario = "";
		try {
			dado_lido = new java.io.DataInputStream(System.in);
			stemporario = dado_lido.readLine();
		} catch (Exception e) {
		}
		return stemporario;
	}

	public static void consultarConta() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		String numero = s.next();
		boolean encontrado = false;
		Iterator<Conta> i = rep.iterator();
		while (i.hasNext()) {
			Conta c = i.next();
			if (c.getNumero().equals(numero)) {
				System.out.println("Dados da conta: ");
				System.out.println("Numero da conta: " + c.getNumero());
				System.out.println("Nome do cliente: " + c.getNome());
				System.out.println("Saldo da conta : " + c.getSaldo());
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		}

	}

	public static void inserirConta() {
		String numero = "", nome = "", cpf = "", endereco = "", agencia = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente dono da conta:");
		cpf = s.next();
		System.out.println("Digite o nome do cliente dono da conta:");
		nome = Leia(nome);
		System.out.println("Digite o endereço do cliente dono da conta:");
		endereco = Leia(endereco);
		System.out.println("Digite o número da conta:");
		numero = s.next();
		System.out.println("Digite o número da agência:");
		agencia = s.next();
		System.out.println("Digite o saldo inicial da conta:");
		double saldo = s.nextDouble();
		Conta c = new Conta(cpf, nome, endereco, numero, agencia, saldo);
		if (rep.add(c))
			System.out.println("conta inserida com sucesso.");
		else
			System.out
					.println("A conta não pôde ser inserida, o repositório pode estar cheio ou essa conta já existe no sistema");
	}

	public static void alterarConta() {
		String numero = "", nome = "", cpf = "", endereco = "", agencia = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente dono da conta:");
		cpf = s.next();
		System.out.println("Digite o nome do cliente dono da conta:");
		nome = Leia(nome);
		System.out.println("Digite o endereço do cliente dono da conta:");
		endereco = Leia(endereco);
		System.out.println("Digite o número da conta:");
		numero = s.next();
		System.out.println("Digite o número da agência:");
		agencia = s.next();
		System.out.println("Digite o saldo inicial da conta:");
		double saldo = s.nextDouble();
		Conta c = new Conta(cpf, nome, endereco, numero, agencia, saldo);
		boolean encontrado = false;
		Iterator<Conta> i = rep.iterator();
		while (i.hasNext()) {
			Conta c2 = i.next();
			if (c2.getNumero().equals(numero)) {
				i.remove();
				rep.add(c);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		} else
			System.out.println(" Conta alterada.");
	}

	public static void removerConta() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o número da conta:");
		String numero = s.next();
		boolean encontrado = false;
		Iterator<Conta> i = rep.iterator();
		while (i.hasNext()) {
			Conta c = i.next();
			if (c.getNumero().equals(numero)) {
				i.remove();
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Conta não localizada");
		} else {
			System.out.println("Conta removida.");
		}
	}

	public static void exibirTodasAsContas() {
		int contador = 0;
		Iterator<Conta> i = rep.iterator();
		System.out.println("Contas armazenadas: ");
		while (i.hasNext()) {
			System.out.println("----------------------------------------------");
			Conta c = i.next();
			System.out.println("Numero da conta: " + c.getNumero());
			System.out.println("Nome do cliente: " + c.getNome());
			System.out.println("Saldo da conta : " + c.getSaldo());
			contador = contador + 1;

		}
		System.out.println("----------------------------------------------");
		System.out.println("total de contas armazenadas: " + contador);
	}

	public static boolean login() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o login (cpf):");
		String cpf = s.next();
		System.out.println("Digite a senha:");
		String senha = s.next();
		boolean encontrado = false;
		Iterator<Login> i = rep2.iterator();
		while (i.hasNext()) {
			Login c = i.next();
			if (c.getCpf().equals(cpf) && c.getSenha().equals(senha)) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Login não localizado");
		}

		return encontrado;
	}

	public static void cadastrarLogin() {
		String cpf = "", nome = "", endereco = "", senha = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o cpf do usuario dono do login:");
		cpf = s.next();
		System.out.println("Digite o nome do usuario dono do login:");
		nome = Leia(nome);
		System.out.println("Digite o endereço do usuario dono do login:");
		endereco = Leia(endereco);
		System.out.println("Digite a senha para efetuar login:");
		senha = s.next();
		Login c = new Login(cpf, nome, endereco, senha);
		if (rep2.add(c))
			System.out.println("login inserido com sucesso.");
		else
			System.out
					.println("O login não pôde ser inserido, o repositório pode estar cheio ou essa conta já existe no sistema");
	}

	public static void consultarLogin() {
		int contador = 0;
		Iterator<Login> i = rep2.iterator();
		System.out.println("Logins armazenados: ");
		while (i.hasNext()) {
			System.out.println("----------------------------------------------");
			Login c = i.next();
			System.out.println("Numero de CPF: " + c.getCpf());
			System.out.println("Nome do usuário: " + c.getNome());
			//Remover a linha de senha
			System.out.println("Senha do usuário: " + c.getSenha());
			contador = contador + 1;

		}
		System.out.println("----------------------------------------------");
		System.out.println("total de logins armazenados: " + contador);
	}

	public static void alterarLogin() {
		String cpf = "", nome = "", endereco = "", senha = "";
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o cpf do usuario dono do login:");
		cpf = s.next();
		System.out.println("Digite o novo nome do usuario dono do login:");
		nome = Leia(nome);
		System.out.println("Digite o novo endereço do usuario dono do login:");
		endereco = Leia(endereco);
		System.out.println("Digite a nova senha para efetuar login:");
		senha = s.next();
		Login c = new Login(cpf, nome, endereco, senha);
		boolean encontrado = false;
		Iterator<Login> i = rep2.iterator();
		while (i.hasNext()) {
			Login c2 = i.next();
			if (c2.getCpf().equals(cpf)) {
				i.remove();
				rep2.add(c);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Login não localizado");
		} else
			System.out.println("Login alterado.");
	}
}
