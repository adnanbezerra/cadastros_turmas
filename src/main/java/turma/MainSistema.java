package turma;

import java.util.Scanner;

/**
 * Interface com o menu de texto e os métodos que tratam de fazer o código funcionar.
 * 
 * @author Adnan Bezerra
 */
public class MainSistema {
    
    public static void main(String[] args) {
        ControladorGrupo controle = new ControladorGrupo();
        AlunoRepository repositorio = new AlunoRepository();
        Scanner scanner = new Scanner(System.in);
        Questões contaQuestões = new Questões();
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, repositorio, scanner, controle, contaQuestões);
		}
    }

    /**
     * O menu a ser rodado na linha de comando do sistema, que mostra a interface básica do código.
     * 
     * @param scanner para registrar as entradas do usuário
     * @return a String do menu do sistema
     */
    private static String menu(Scanner scanner) {
        System.out.print(
                "\n---\nMENU\n" + 
                        "(C)adastrar Aluno\n" + 
                        "(E)xibir Aluno\n" + 
                        "(N)ovo Grupo\n" +
                        "(A)locar aluno no Grupo e Verificar Pertinência a Grupos\n" +
                        "(R)egistrar Aluno que Respondeu\n" + 
                        "(I)mprimir Alunos que Responderam\n" +
                        "(O)xe, e a contagem dos grupos com restrição de curso?\n" +
                        "(S)im, quero fechar o programa!\n" + 
                        "\n" + 
                        "Opção> ");
        return scanner.nextLine().toUpperCase();
    }

    /**
     * Método que computa qual o comando que foi inserido pelo usuário no começo do código.
     * 
     * @param opcao é a entrada dada pelo usuário
     * @param repositorio o AlunoRepository que está sendo tratado no código
     * @param scanner para registrar as escolhas do usuário
     * @param controle o ControladorGrupo que está sendo tratado no código
     * @param contaQuestões o contador de Questões que está sendo tratado no código
     */
    private static void comando(String opcao, AlunoRepository repositorio, Scanner scanner, ControladorGrupo controle, Questões contaQuestões) {
		switch (opcao) {
		case "C":
			cadastraAluno(repositorio, scanner);
			break;
		case "E":
			exibirAluno(repositorio, scanner);
			break;
		case "N":
			registrarGrupo(scanner, controle);
			break;
		case "A":
			alocarPertinenciaGrupo(scanner,  controle, repositorio);
			break;
		case "R":
			registrarRespondeu(scanner, repositorio, contaQuestões);
			break;
		case "I":
			exibirResponderam(contaQuestões);
			break;
        case "O":
            contagemRestricao(controle, scanner);
            break;
        case "S":
            System.exit(0);
            break;
		default:
			System.out.println("Opção inválida!");
		}
	}

    /**
     * Método que é responsável por contar quantos grupos têm restrição para um determinado curso.
     * 
     * @param controle o ControladorGrupo que está sendo tratado no código
     * @param scanner para registrar as escolhas do usuário
     */
    private static void contagemRestricao(ControladorGrupo controle, Scanner scanner) {
        System.out.print("Curso: ");
        String curso = scanner.nextLine().toUpperCase();
        System.out.print(controle.contagemRestricao(curso));
    }

    /**
     * Método que é responsável por exibir uma lista de quantos e quais alunos resolveram questões
     * 
     * @param contaQuestões o contador de Questões que está sendo tratado no código
     */
    private static void exibirResponderam(Questões contaQuestões){
        System.out.println(contaQuestões.toString());
    }

    private static void registrarRespondeu(Scanner scanner, AlunoRepository repositorio, Questões contaQuestões) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        if(repositorio.testeExiste(matricula)){
            Aluno bixote = repositorio.getAluno(matricula);
            contaQuestões.registraAluno(bixote);
            System.out.println("ALUNO REGISTRADO!");
        } else {
            System.out.println("Aluno não cadastrado.");
        }
    }

    private static void alocarPertinenciaGrupo(Scanner scanner, ControladorGrupo controle, AlunoRepository repositorio){
        System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
        String trem = scanner.nextLine().toUpperCase();
        switch(trem) {
            case("A"):
            alocarGrupo(scanner, controle, repositorio);
            break;
            case("P"):
            pertinenciaGrupo(scanner, controle, repositorio);
            break;
        }
    }

    /**
     * Método responsável por testar se um aluno está presente em um grupo
     * 
     * @param scanner para registrar as entradas do usuário
     * @param controle o ControladorGrupo que está sendo tratado no código
     * @param repositorio o AlunoRepository que está sendo tratado no código
     */
    private static void pertinenciaGrupo(Scanner scanner, ControladorGrupo controle, AlunoRepository repositorio){
        System.out.print("Grupo: ");
        String grupo = scanner.nextLine().toUpperCase();
        System.out.print("Aluno: ");
        String matricula = scanner.nextLine();
        if(controle.testeExiste(grupo)){
            if(controle.testeCadastro(matricula, grupo)){
                System.out.println("ALUNO PERTENCE AO GRUPO");
            } else {
                System.out.println("ALUNO NÃO PERTENCE AO GRUPO");
            }
        } else {
            System.out.println("GRUPO NÃO CADASTRADO");
        }
    }

    /**
     * Método responsável por alocar um aluno dentro de um grupo.
     * 
     * @param scanner para registrar as escolhas do usuário
     * @param controle o ControladorGrupo que está sendo tratado no código
     * @param repositorio o AlunoRepository que está sendo tratado no código
     */
    private static void alocarGrupo(Scanner scanner, ControladorGrupo controle, AlunoRepository repositorio) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Grupo: ");
        String nomeGrupo = scanner.nextLine().toUpperCase();
        Grupo grupo = controle.getGrupo(nomeGrupo);
        if(repositorio.testeExiste(matricula)){
            if(controle.testeExiste(nomeGrupo)){
                Aluno bixote = repositorio.getAluno(matricula);
                if(bixote.getCurso().equals(grupo.getCurso())){
                    controle.alocarAluno(bixote, nomeGrupo);
                    System.out.println("ALUNO ALOCADO!"); 
                } else {
                    System.out.println("GRUPO COM RESTRIÇÃO DE CURSO");
                }
            } else {
                System.out.println("Grupo não cadastrado.");
            }
        } else {
            System.out.println("Aluno não cadastrado.");
        }
    }

    /**
     * Método responsável por criar um novo grupo e cadastrá-lo no ControladorGrupo.
     * 
     * @param scanner para registrar as entradas do usuário
     * @param controle o ControladorGrupo que está sendo tratado no código
     */
    private static void registrarGrupo(Scanner scanner, ControladorGrupo controle){
        System.out.print("Grupo: ");
        String nome = scanner.nextLine().toUpperCase();
        System.out.print("Restrição? ");
        String restrição = scanner.nextLine();
        if(controle.testeExiste(nome)){
            System.out.println("GRUPO JÁ CADASTRADO!");
        } else {
            controle.cadastraGrupo(nome, restrição);
            System.out.println("CADASTRO REALIZADO!");
        }
    }

    /**
     * Método responsável por exibir um aluno já cadastrado no AlunoRepository a partir de sua matrícula.
     * 
     * @param repositorio o AlunoRepository que está sendo tratado no código
     * @param scanner para registrar as entradas do usuário
     */
    private static void exibirAluno(AlunoRepository repositorio, Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        boolean existe = repositorio.testeExiste(matricula);
        if(existe){
            Aluno bixote = repositorio.getAluno(matricula);
            System.out.print(bixote.toString());
        } else {
            System.out.print("Aluno não cadastrado.");
        }
    }

    /**
     * Método responsável por cadastrar um aluno no AlunoRepository
     * 
     * @param repositorio o AlunoRepository que está sendo tratado no código
     * @param scanner para registrar as entradas do usuário
     */
    private static void cadastraAluno(AlunoRepository repositorio, Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        boolean existe = repositorio.testeExiste(matricula);
        if(existe){
            System.out.print("MATRÍCULA JÁ CADASTRADA!");
        } else{
            Aluno aluno = new Aluno(matricula, nome, curso);
            repositorio.cadastraAluno(aluno);
            System.out.println("CADASTRO REALIZADO!");
        }
    }
}