package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;


public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
			//Criar objeto da Classe Conta p/ testar
		
		Conta c1 = new Conta(1, 123, 1, "Daffy Duck", 200000.00f);
		c1.visualizar();
		System.out.println("Exibir o Saldo: " + c1.getSaldo());
		c1.setSaldo(300000.00f);
		c1.visualizar();
		c1.sacar(410000.00f);
		c1.visualizar();
		c1.depositar(6000.00f);
		c1.visualizar();
		
		//criar obj Conta COrrente p/ testar
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Felipe", 100000.00f, 2000.00f);
		cc1.visualizar();
		cc1.sacar(101000.00f);
		cc1.visualizar();
		cc1.depositar(2000.00f);
		cc1.visualizar();
		
		//criar obj Conta Poupança p/ testar

		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Vitor Nascimento", 3000.00f, 12);
		cp1.visualizar();
		cp1.sacar(1000.00f);
		cp1.visualizar();
		cp1.depositar(2000.00f);
		cp1.visualizar();
		
		while(true) {
			
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO PERNALONGA                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			opcao = leia.nextInt();
			
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Pernalonga - O que é que há, velhinho?");
				sobre();
				leia.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
			
                break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
		}
			
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN);
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Gercidio Valeriano - Generation Turma 68 - gercidio@gmail.com");
		System.out.println("github.com/Gercidio");
		System.out.println("*********************************************************");
		System.out.println(Cores.TEXT_RESET);
	}
}
