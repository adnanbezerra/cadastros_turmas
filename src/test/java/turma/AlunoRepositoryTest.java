package turma;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoRepositoryTest {

    private Aluno bixote;
    private AlunoRepository repositorio;

    @BeforeEach
    void BeforeEach(){
        bixote = new Aluno("123", "Varyan Wrynn", "computação");
        repositorio = new AlunoRepository();
        repositorio.cadastraAluno(bixote);
    }

    /**
     * Teste que tenta cadastrar um aluno no repositório.
     */
    @Test
    void cadastraAluno(){
        repositorio.cadastraAluno(bixote);
    }

    /**
     * Testa o método getAluno para o caso de um aluno que existe.
     */
    @Test
    void testeGetAlunoExistente(){
        Aluno teste = repositorio.getAluno("123");
        assertTrue(teste.equals(bixote));
    }

    /**
     * Testa o método getAluno para o caso de um aluno que não existe. É esperado que ele retorne um valor
     * null, dado que o aluno não existe.
     */
    @Test
    void testeGetAlunoInexistente(){
        Aluno teste = repositorio.getAluno("1262");
        assert(teste == null);
    }

    /**
     * Testa se um aluno já foi cadastrado no repositório. O resultado esperado é true.
     */
    @Test
    void testeExisteTrue(){
        Aluno bixin = new Aluno("123", "Thrall", "Computação");
        repositorio.cadastraAluno(bixin);
        String matricula = bixin.getMatricula();
        assertTrue(repositorio.testeExiste(matricula));
    }
    
    /**
     * Testa se um aluno já foi cadastrado no repositório. O resultado esperado é false.
     */
    @Test
    void testeExisteFalse(){
        Aluno bixin = new Aluno("6134", "Thrall", "Computação");
        String matricula = bixin.getMatricula();
        assertFalse(repositorio.testeExiste(matricula));
    }
}
