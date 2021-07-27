package turma;

import java.util.ArrayList;

/**
 * Classe responsável por realizar a contagem e o registro de quantos e quais alunos resolveram
 * questões.
 * 
 * @author Adnan Bezerra
 */
public class Questões {

    /**
     * ArrayList encarregado de registrar quais alunos resolveram questões.
     */
    private ArrayList<String> listaAlunos;

    /**
     * Construtur da classe Questões. Ele está vazio, pois a sua única função é ativar a classe.
     */
    public Questões(){
        listaAlunos = new ArrayList<>();
    }

    /**
     * Método que registra uma questão feita por um aluno.
     * @param aluno o aluno que resolveu a questão.
     */
    public void registraAluno(Aluno aluno){
        listaAlunos.add(aluno.toString());
    }

    /**
     * Override no método toString, que fica responsável por entregar uma listagem dos alunos que resolveram questões.
     * 
     * @return a lista.
     */
    @Override
    public String toString(){
        String listagem = "";
        for(int i = 0; i < listaAlunos.size(); i++){
            if(i == listaAlunos.size() - 1){
                listagem += i + 1 + " - " + this.listaAlunos.get(i);
            } else { 
                listagem += i + 1 + " - " + this.listaAlunos.get(i) + "\n";
            }
        }
        return listagem;
    }
    
}
