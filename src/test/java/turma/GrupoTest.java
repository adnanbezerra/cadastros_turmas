package turma;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrupoTest {

    private Aluno bixote;
    private Grupo exemplo;

    @BeforeEach
    void BeforeEach(){
        bixote = new Aluno("123", "Garrosh Hellscream", "Educação Física");
        exemplo = new Grupo("Listas", "");
    }
 
    /**
     * Testa se é possível criar um grupo com restrição de curso e checa como é registrada a restrição.
     */
    @Test
    void testeGrupoComRestrição(){
        Grupo comRestricao = new Grupo("Programação POO", "Computação");
        String actual = comRestricao.getCurso();
        String expected = "Computação";
        assertEquals(expected, actual);
    }

    /**
     * Testa se é possível criar um grupo sem restrição de curso e checa como fica registrada esta falta de curso.
     */
    @Test
    void testeGrupoSemRestrição(){
        Grupo semRestricao = new Grupo("Listas", "");
        String expected = "";
        String actual = semRestricao.getCurso();
        assertEquals(expected, actual);
    }

    /**
     * Testa se é possível cadastrar um aluno em um curso.
     */
    @Test
    void testeCadastro(){
        exemplo.cadastraNoGrupo(bixote);
    }

    /**
     * Testa os dois getters da classe para o caso do grupo não ter restrição de curso.
     */
    @Test
    void testeGettersSemRestrição(){
        assertEquals("Listas", exemplo.getNome());
        assertEquals("", exemplo.getCurso());
    }

    /**
     * Testa os dois getters da classe para o caso do curso ter restrição de curso.
     */
    @Test
    void testeGettersComRestrição(){
        Grupo trem = new Grupo("Prince Zuko", "Firebending");
        assertEquals("Prince Zuko", trem.getNome());
        assertEquals("Firebending", trem.getCurso());
    }

    /**
     * Testa se um aluno está cadastrado dentro de um grupo. O resultado esperado é "false".
     */
    @Test
    void testeEstadoFalse(){
        assertFalse(exemplo.estaNoGrupo(bixote.getMatricula()));
    }

    /**
     * Testa se um aluno está cadastrado dentro de um grupo. o resultado esperado é "true".
     */
    @Test
    void testeEstadoTrue(){
        exemplo.cadastraNoGrupo(bixote);
        assertTrue(exemplo.estaNoGrupo(bixote.getMatricula()));
    }
}
