package turma;

import java.util.HashMap;

/**
 * Classe responsável por manipular o tipo Grupo e as suas interações com o sistema.
 * 
 * @author Adnan Bezerra
 */
public class ControladorGrupo {

    /**
     * O HashMap que é responsávle por armazenar os grupos. O nome do grupo é a chave, e o grupo em si
     * é o seu value.
     */
    private HashMap<String, Grupo> grupo;

    /**
     * O construtor da classe ControladoGrupo. Ele é responsável apenas por iniciar a classe.
     *
     */
    public ControladorGrupo(){
        grupo = new HashMap<>();
    }

    /**
     * Método responsável por cadastrar um novo grupo.
     * 
     * @param nome o nome do grupo a ser criado.
     * @param restrição a restrição de curso a ser adicionada. É opcional.
     */
    public void cadastraGrupo(String nome, String restrição){
        nome.toUpperCase();
        Grupo trem = new Grupo(nome, restrição);
        this.grupo.put(nome, trem);
    }

    /**
     * Testa se já existe um grupo com o nome citado pelo usuário.
     * 
     * @param nome o nome do grupo testado
     * @return o resultado do teste
     */
    public boolean testeExiste(String nome){
        return grupo.containsKey(nome);
    }
   
    /**
     * Método responsável por alocar um aluno dentro de um grupo.
     * 
     * @param aluno o aluno a ser alocado
     * @param nomeGrupo o seu respectivo grupo
     */
    public void alocarAluno(Aluno aluno, String nomeGrupo){
        for(Grupo trenzinho : this.grupo.values()){
            trenzinho.cadastraNoGrupo(aluno);
        }
    }

    /**
     * Método responsável por testar se um determinado aluno faz parte de um grupo.
     * 
     * @param matricula a matrícula do aluno em questão
     * @param nome o nome do grupo a ser tratado
     * @return o resultado do teste
     */
    public boolean testeCadastro(String matricula, String nome){
        boolean resultado = false;
        Grupo grupo = this.grupo.get(nome);
        if(grupo.estaNoGrupo(matricula)){
            resultado = true;
        }
        return resultado;
    }

    /**
     * Método que realiza a contagem de quantos grupos existem com determinada restrição de curso.
     * 
     * @param checagem o curso que deve ser comparado
     * @return o resultado da comparação
     */
    public String contagemRestricao(String checagem){
        int contador = 0;
        for(String chave : this.grupo.keySet()){
            String restricao = this.grupo.get(chave).getCurso().toUpperCase();
            if(restricao.equals(checagem.toUpperCase())){
                contador += 1;
            }
        }
        String saida = checagem.toLowerCase();
        String output = saida.substring(0, 1).toUpperCase() + saida.substring(1);
        return output + " " + contador;
    }

    /**
     * Método getter para coletar um grupo a partir de uma chave.
     * 
     * @param nomeGrupo o nome do grupo requisitado
     * @return o grupo requisitado
     */
    public Grupo getGrupo(String nomeGrupo){
        return this.grupo.get(nomeGrupo);
    }
}