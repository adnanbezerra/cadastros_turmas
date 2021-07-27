package turma;

import java.util.HashSet;

/**
 * Repositório para a classe Aluno.
 * 
 * @author Adnan Bezerra
 */
public class AlunoRepository {

    /**
     * Conjunto que conterá o registro dos objetos do tipo Aluno
     */
    private HashSet<Aluno> repositorio;

    /**
     * Construtor da classe AlunoRepository, que é responsável apenas por inicializá-la.
     */
    public AlunoRepository(){
        this.repositorio = new HashSet<>();
    }

    /**
     * Método para cadastrar um aluno no repositório.
     * 
     * @param aluno o aluno a ser cadastrado.
     */
    public void cadastraAluno(Aluno aluno){
        this.repositorio.add(aluno);
    }

    /**
     * Método usado para buscar um aluno dentro do repositório a partir de sua matrícula. É suposto, primeiramente,
     * que tal aluno já está cadastrado no sistema. 
     * 
     * @param matricula a matrícula do aluno que quer ser buscado
     * @return o aluno requisitado
     */
    public Aluno getAluno(String matricula){
        Aluno bixote = null;
        for(Aluno e : repositorio){
            if(e.getMatricula().equals(matricula)){
                bixote = e;
                break;
            }
        }
        return bixote;
    }

    /**
     * Testa se um aluno já foi registrado no conjunto com base na sua matrícula.
     * 
     * @param matricula A matrícula a ser comparada.
     * @return O resultado de se existe ou não.
     */
    public boolean testeExiste(String matricula){
        boolean existe = false;
        for(Aluno aluno : repositorio){
            if(matricula.equals(aluno.getMatricula())){
                existe = true;
            } else {
                existe = false;
            }
        }
        return existe;
    }
}