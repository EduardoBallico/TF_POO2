package AcmeFun;
import AcmeFun.entretenimento.ListaEntretenimentos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BancoDeDados {

	public static ArrayList<ArrayList<String>> arrayDosEntretenimentos;
	public static ArrayList<ArrayList<String>> arrayDosClientes;
	public static ArrayList<ArrayList<String>> arrayDosAcessos;

	static String arquivoEntretenimento = "";
	static String arquivoCliente = "";
	static String arquivoAcesso = "";

	public static void carregaTudo() {

		File arq1 = new File(arquivoEntretenimento);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq1))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosEntretenimentos.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}

		File arq2 = new File(arquivoCliente);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq2))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosClientes.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}

		File arq3 = new File(arquivoAcesso);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq3))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosAcessos.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}

	}

	public static void carregaEntretenimentos(String arquivo) {
		File arq = new File(arquivo);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosEntretenimentos.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	public static void carregaClientes(String arquivo) {
		File arq = new File(arquivo);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosClientes.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	public static void carregaAcessos(String arquivo) {
		File arq = new File(arquivo);

		try (BufferedReader bReader = new BufferedReader(new FileReader(arq))){
			String dado;

			while((dado = bReader.readLine()) != null){
				ArrayList<String> array = new ArrayList<>();
				Collections.addAll(array, dado.split(";"));
				array.add(dado);

				arrayDosAcessos.add(array);
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

	public static void salvaTudo() {

		try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(arquivoEntretenimento))){
			for(ArrayList array : ListaEntretenimentos.){
				for (String s : array){
					bWriter.write(s + "\n");
				}
			}
		}
		catch (IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}

}
