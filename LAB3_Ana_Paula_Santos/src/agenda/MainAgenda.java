package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n"+
						"(A)dicionar Favorito\n" +
						"(RF)Remove Favorito\n" + 
						"(T)ags\n" +
						"(RT)emove Tag\n" + 
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			favoritos(agenda);
			break;
		case "A":
			adicionaFavoritos(agenda, scanner);
			break;
		case "RF":
			removeFavorito(agenda, scanner);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "RT":
			removeTag(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição do contato na lista de favoritos> ");
		int posicaoFavorito = scanner.nextInt();
		agenda.removeFavorito(posicaoFavorito);
		scanner.nextLine();
	}

	/**
	 * Remove uma tag de um contato.
	 * 
	 * @param agenda A agenda de contatos que está sendo manipulada
	 * @param scanner para capturar o contato e a posição da tag.
	 */
	private static void removeTag(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosição da Tag> ");
		int posicaoTag = scanner.nextInt();
		agenda.removeTag(contato, posicaoTag);
		scanner.nextLine();
		
	}
	
	

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println((i + 1) + " - " + contatos[i].getNome());
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		String contato = agenda.getContato(posicao);
	
		if (agenda.verifica(posicao)) {
			System.out.println("\nDados do contato:\n" + "❤️ "+ contato);
			scanner.nextLine();}
		else {
			System.out.println("\nDados do contato:\n" + contato);
			scanner.nextLine();}
			}



	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nPosição na agenda> ");
		String posicao = scanner.nextLine().trim();
		int posicao1 = Integer.parseInt(posicao);
		
		if (posicao1 > 0 && posicao1 < 101) { 
			System.out.print("\nNome> ");
			String nome = scanner.nextLine().trim();
			
			if (nome.isEmpty()) {
				System.out.println("Nome inválido, cadastro negado");
				
			}else {
				System.out.print("\nSobrenome> ");
				String sobrenome = scanner.nextLine().trim();
				
				System.out.print("\nTelefone> ");
				String telefone = scanner.nextLine().trim();
				
				if (telefone.isEmpty()) {
					System.out.println("Telefone inválido, cadastro negado");
					
				}else {
					agenda.cadastraContato(posicao1, nome, sobrenome, telefone);
					if (agenda.confirmacaoDeCadastro()) {
						System.out.println("Cadastro realizado!");
					}else {
						System.out.println("Contato já está cadastrado!");
					}
				}
	   }
		}else {
			System.out.println("Posição inválida!");
		}
}	
	/**
	 * Imprime a lista de favoritos.
	 * 
	 * @param agenda a agenda.
	 */
	private static void favoritos(Agenda agenda) {
		System.out.println("\nLista de favoritos: ");
		String[] favoritos = agenda.getContatosFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println((i + 1) + " - " + favoritos[i]);
			}
		
	}
	}
	/**
	 * Adiciona um contato da agenda na lista de favoritos.
	 * 
	 * @param agenda A agenda
	 * @param scanner Scanner para capturar a entrada
	 */
	private static void adicionaFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		agenda.adicionaFavoritos(contato, posicao);
		if(agenda.confirmacaoDeCadastro()) {
			System.out.println("Contato favoritado na posição " + (posicao) + "!");
			scanner.nextLine();
		}else {
			System.out.println("Contato já está favoritado!");
			scanner.nextLine();
		}
	}
		
	
	/**
	 * Adiciona tags aos contatos da agenda
	 * 
	 * @param agenda A agenda
	 * @param scanner Scanner para capturar a entrada
	 */
	
	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato (s)> ");
		String contato = scanner.nextLine();
		System.out.print("\nTag> ");
		String tag = scanner.nextLine();
		System.out.print("\nPosição tag> ");
		int posicaoTag = scanner.nextInt();
		agenda.adicionarTag(contato, tag, posicaoTag);
		scanner.nextLine();

		
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
