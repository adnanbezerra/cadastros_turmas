package turma;

import java.util.HashSet;

/**
 * Classe que constrói o tipo Grupo, que registrará as informações de um determinado grupo.
 * 
 * @author Adnan Bezerra
 */
public class Grupo {

    /**
     * String que registra qual o curso requisitado para determinado grupo. Ela é inicializada como sendo "nenhum"
     * para o caso de não haver nenhum requisito de curso para o grupo.
     */
    private String cursoRequisitado = "nenhum";

    /**
     * String que registra qual o nome do grupo em questão.
     */
    private String nomeGrupo;

    /**
     * Conjunto com os membros de um determinado grupo.
     */
    private HashSet<Aluno> membros;

    /**
     * Construtor para o tipo grupo, que trata de criar um grupo dotado de nome e de restrição e que inicializa
     * o conjunto dos membros.
     * 
     * @param nome nome do grupo em questão
     * @param restrição qual o curso de restrição em questão
     */
    public Grupo(String nome, String restrição){
        membros = new HashSet<>();
        this.nomeGrupo = nome;
        this.cursoRequisitado = restrição;
    }

    /**
     * Método para cadastrar um aluno dentro de um grupo.
     * 
     * @param aluno o aluno a ser cadastrado.
     */
    public void cadastraNoGrupo(Aluno aluno){
        membros.add(aluno);
    }

    /**
     * Método getter para obter o nome de um grupo.
     * 
     * @return o nome do grupo.
     */
    public String getNome(){
        return this.nomeGrupo;
    }

    /**
     * Método getter para obter o curso requisitado de um grupo.
     * 
     * @return o curso requisitado
     */
    public String getCurso(){
        return this.cursoRequisitado;
    }

    /**
     * Método que testa se um determinado aluno está presente no grupo a ser testado.
     * 
     * @param matricula a matricula do aluno
     * @return o resultado do teste
     */
    public boolean estaNoGrupo(String matricula){
        boolean resultado = false;
        for(Aluno bixote : membros){
            if(matricula.equals(bixote.getMatricula())){
                resultado = true;
                break;
            }
        }
        return resultado;
    }
}