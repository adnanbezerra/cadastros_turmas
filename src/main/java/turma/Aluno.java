package turma;

/**
 * Classe que é responsável por criar um objeto Aluno e controlá-lo.
 * 
 * @author Adnan Bezerra
 */
public class Aluno {

    /**
     * String responsável por registrar qual a matrícula do aluno.
     */
    private String matricula;

    /**
     * String responsável por registrar qual o nome do aluno.
     */
    private String nome;

    /**
     * String responsável por registrar qual o curso do aluno.
     */
    private String curso;

    /**
     * Construtor da classe Aluno, que irá criar um aluno novo.
     * 
     * @param matricula a matrícula a ser relacionada ao aluno.
     * @param nome o seu respectivo nome.
     * @param curso o curso que ele faz.
     */
    public Aluno(String matricula, String nome, String curso){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Método getter para o nome de um determinado aluno.
     * 
     * @return o nome do aluno.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Método getter para obter a matrícula de um determinado aluno.
     * 
     * @return a matrícula do aluno.
     */
    public String getMatricula(){
        return this.matricula;
    }

    /**
     * Método getter para obter o curso ligado a algum determinado aluno.
     * 
     * @return o curso no qual ele foi cadastrado.
     */
    public String getCurso(){
        return this.curso;
    }

    /**
     * Override no método toString que retorna uma String contendo as informações de um aluno.
     * 
     * @return uma string que representa o aluno.
     */
    @Override
    public String toString(){
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }
    
    /**
     * Override do método equals para testar a partir da matrícula se um aluno já está
     * cadastrado ou não.
     * 
     * @param bixote O aluno a ser comparado.
     * @return O resultado do teste de igualdade.
     */
    public boolean equals(Aluno bixote){
        boolean equals = false;
        if(this.matricula.equals(bixote.getMatricula())){
            equals = true;
        } else {
            equals = false;
        }
        return equals;
    }

    /**
     * Override no método hashCode para que a chave hash passe a ser apenas relacionada à matrícula do aluno.
     */
    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}
