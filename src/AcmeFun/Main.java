package AcmeFun;

import java.util.Scanner;

public class Main {

	public Gerenciador gerenciador;

	public static void main(String[] args) {

		Main main = new Main();
		main.gerenciador = new Gerenciador();
		// iniciar();
		// executar();
	}

	public void iniciar(){
		// carregar os dados]
		// login
	}

	public void executarAdmin(){

	}
	public void executarCliente(){

	}

	public void exibeLogin(){

	}
	public void exibeMenuAdmin(){
		Scanner in = new Scanner(System.in);
		int menu;

		do {
			System.out.println("MENU");
			System.out.println("1- Cadastrar novo cliente");
			System.out.println("2- Cadastrar novo entretenimento");
			System.out.println("3- Consultar acessos mensais ");
			System.out.println("4- Simular carga de dados");
			System.out.println("0- Sair");

			menu = Integer.parseInt(in.nextLine());
			switch (menu) {
				case 1:
					break;

				case 2:
					break;

				case 3:
					break;

				case 4:
					break;

				case 0:
					System.out.println("Sistema Finalizado");
					break;
			}
		} while (menu != 0);
	}

	public void exibeMenuCliente(){
		Scanner in = new Scanner(System.in);
		int menu;

		do {
			System.out.println("MENU");
			System.out.println("1- Consultar catálogo de entretenimento");
			System.out.println("2- Acessar entretenimento");
			System.out.println("3- Consultar cobrança mensal");
			System.out.println("0- Sair");

			menu = Integer.parseInt(in.nextLine());
			switch (menu) {
				case 1:
					break;

				case 2:
					break;

				case 3:
					break;

				case 0:
					System.out.println("Sistema Finalizado");
					break;
			}
		} while (menu != 0);
	}

}