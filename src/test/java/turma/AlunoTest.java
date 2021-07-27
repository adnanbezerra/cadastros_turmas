package turma;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    
    private Aluno bixote;

    /**
     * BeforeEach da classe, para registrar um aluno a ser usado nos demais testes.
     * Este é, em si, um teste simples para o construtor, quando o aluno vem com todas as
     * informações a serem usadas.
     */
    @BeforeEach
    void meuAluno(){
        bixote = new Aluno("134", "Varyan Wrynn", "Computação");
    }

    /**
     * Teste das três classes getter pressentes na classe Aluno.
     */
    @Test
    void testeGetters(){
        assert(bixote.getNome().equals("Varyan Wrynn"));
        assert(bixote.getCurso().equals("Computação"));
        assert(bixote.getMatricula().equals("134"));
    }

    /**
     * Teste da classe toString, que é responsabilizada por retornar uma string com as informações do aluno.
     */
    @Test
    void testeToString(){
        String esperado = "134 - Varyan Wrynn - Computação";
        assertEquals(esperado, bixote.toString());
    }

    /**
     * Testa o método .equals(Aluno), tendo por resultado esperado "true".
     */
    @Test
    void testeEqualsTrue(){
        Aluno bixinho = new Aluno("134", "Anduin Lothar", "Artes cênicas");
        assertTrue(bixote.equals(bixinho));
    }

    /**
     * Testa o método .equals(Aluno), tendo por resultado esperado "false".
     */
    @Test
    void testeEqualsFalse(){
        Aluno bixinho = new Aluno("6890", "Raindal Jenkyns", "Teologia");
        assertFalse(bixote.equals(bixinho));
    }

    /**
     * Testa o Override no método hashCode, que deve comparar apenas qual o código do atributo
     * Matrícula do aluno.
     */
    @Test
    void testeHashCode(){
        int expected = bixote.getMatricula().hashCode();
        int actual = bixote.hashCode();
        assertEquals(expected, actual);
    }
    
}
