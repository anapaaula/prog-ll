package LAB4;

import java.util.Scanner;

public class MainControle {
	public static void main(String[] args) {
		ControleDeAlunos controle = new ControleDeAlunos();
		
		Scanner scanner = new Scanner(System.in);
	    String opcao = "";
		
		while (true) {
			opcao = menu(scanner);
			comando(opcao,scanner, controle);
			
		}
	}
	
	private static String menu(Scanner scanner) {
    	System.out.println(
    			 "\nMENU\n"+
    			 "****\n"+
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n"+
						"(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" + 
						"(I)mprimir Alunos que Responderam\n" +
						"(O)lha� quais Grupos o Aluno T�.\n" + 
						"(S)im, quero Fechar o Programa!\n" +
				 "****\n" +
						"\nOp��o> ");
        
        return scanner.nextLine().toUpperCase(); 
    }
    
	private static void comando(String opcao, Scanner scanner, ControleDeAlunos controle) {
		if (opcao == null) {
			throw new NullPointerException("op��o nula");
		}else if (opcao.isBlank()) {
			throw new IllegalArgumentException("op��o vazia");
			
		}
		switch (opcao) {
		case "C":
			cadastrarAluno(scanner, controle);
			break;
		case "E":
			exibirAluno(scanner, controle);
			break;
		case "N":
			novoGrupo(scanner,controle);
			break;
		case "A":
			alocarVerificarAlunosNoGrupo(scanner,controle);
			break;
		case "R":
			registrarAlunoRespondeu(scanner,controle);
			break;
		case "I":
			imprimirAlunosResponderam(scanner,controle);
			break;
		case "O":
			quaisGruposDoAluno(scanner,controle);
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("Op��o inv�lida!");
		}
	}
  
	private static void cadastrarAluno(Scanner scanner, ControleDeAlunos controle) {
		System.out.print("\nMatr�cula> ");
		String matricula = scanner.nextLine().trim();
		if (matricula.isBlank()) {
			System.out.println("Matr�cula vazia.");
		}else {
			System.out.print("\nNome> ");
			String nome = scanner.nextLine().trim();
			if (nome.isBlank()) {
				System.out.println("Nome vazio.");
			}else {
				System.out.print("\nCurso> ");
				String curso = scanner.nextLine().trim();
				if(curso.isBlank()) {
					System.out.println("Curso vazio.");
				}else {
					if (controle.cadastrarAluno(nome,matricula,curso)) {
						System.out.println("CADASTRO REALIZADO!");
					}else {
						System.out.println("MATR�CULA J� CADASTRADA!");
						}
				}
			
			}
		}
	}
	
	private static void exibirAluno(Scanner scanner, ControleDeAlunos controle) {
		System.out.print("\nMatr�cula> ");
		String matricula = scanner.nextLine().trim();
		System.out.println(controle.exibirAluno(matricula));
	}
	
	private static void novoGrupo(Scanner scanner,ControleDeAlunos controle) {
		System.out.print("\nGrupo> ");
		String grupo = scanner.nextLine().trim();
		if (grupo.isBlank()) {
			System.out.println("Grupo vazio.");
		}else {
			System.out.print("\nTamanho> ");
			String tamanho = scanner.nextLine().trim();
			if (controle.novoGrupo(grupo, tamanho)) {
				System.out.println("CADASTRO REALIZADO!");
			}else {
				System.out.println("GRUPO J� CADASTRADO!");
			}
	}
	}
	
	
	private static void alocarVerificarAlunosNoGrupo(Scanner scanner, ControleDeAlunos controle) {
		System.out.print("\n(A)locar Aluno ou (P)ertin�ncia a Grupo?> ");
		String escolha = scanner.nextLine().trim();
		if (escolha.equals("A")|| escolha.equals("a")) {
			System.out.print("\nMatr�cula> ");
			String matricula = scanner.nextLine().trim();
			System.out.print("\nGrupo> ");
			String grupo = scanner.nextLine().trim();
			System.out.println(controle.alocarAlunoNoGrupo(matricula, grupo)); 
			
		}else if (escolha.equals("P")|| escolha.equals("p")) {
			System.out.print("\nGrupo> ");
			String grupo = scanner.nextLine().trim();
			System.out.print("\nAluno> ");
			String aluno = scanner.nextLine().trim();
			System.out.println(controle.alunoPertenceAoGrupo(grupo, aluno));
			
		}else {
			System.out.println("Op��o inv�lida!");
		}
	}
	
	private static void registrarAlunoRespondeu(Scanner scanner,ControleDeAlunos controle) {
		System.out.print("\nMatr�cula> ");
		String matricula = scanner.nextLine().trim();
		if(controle.registrarAlunoRespondeu(matricula)) {
			System.out.println("ALUNO REGISTRADO!");
		}else {
			System.out.println("ALUNO N�O CADASTRADO.");
		}
	}
	
	private static void imprimirAlunosResponderam(Scanner scanner,ControleDeAlunos controle) {
		System.out.println(controle.imprimirAlunosResponderam());
	}
	
	private static void quaisGruposDoAluno(Scanner scanner, ControleDeAlunos controle) {
		System.out.print("\nAluno> ");
		String matricula = scanner.nextLine().trim();
		System.out.println(controle.quaisGruposDoAluno(matricula));
	}
	
	private static void sair() {
		System.out.println("Programa finalizado!");
		System.exit(0);
	}
}

	

	