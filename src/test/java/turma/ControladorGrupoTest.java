package turma;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorGrupoTest {

    private ControladorGrupo controle;
    private Aluno gabriel;
    private Aluno lili;
    private Aluno angela;
    private Aluno torbjorn;

    @BeforeEach
    void BeforeEach(){
        controle = new ControladorGrupo();
        gabriel = new Aluno("250", "Gabriel Reyes", "Computação");
        lili = new Aluno("200", "Lili Camposh", "Computação");
        angela = new Aluno("202", "Angela Ziegler", "Medicina");
        torbjorn = new Aluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    /**
     * Testa o cadastro de um grupo com restrição de curso. Para tanto, é esperado que
     * o método .getCurso() retorne a restrição "Computação".
     */
    @Test
    void cadastroComRestrição(){
        controle.cadastraGrupo("Listas", "Computação");
        assert(controle.getGrupo("Listas").getCurso().equals("Computação"));
    }

    /**
     * Testa o cadastro de um grupo sem restrição de curso. Para tanto, é esperado que o método
     * .getCurso() retorne uma string vazia.
     */
    @Test
    void cadastroSemRestrição(){
        controle.cadastraGrupo("Programação OO", "");
        assert(controle.getGrupo("Programação OO").getCurso().equals(""));
    }
    
    /**
     * Testa o método .testeExiste(grupo). O resultado esperado é "true".
     */
    @Test
    void testeExisteTrue(){
        controle.cadastraGrupo("Listas", "Medicina");
        Grupo comparador = new Grupo("Listas", "Computação");
        assertTrue(controle.testeExiste(comparador.getNome()));
    }

    /**
     * Testa o método .texteExiste(grupo). O resultado esperado é "false".
     */
    @Test
    void testeExisteFalse(){
        controle.cadastraGrupo("Listas", "Medicina");
        Grupo comparador = new Grupo("POO", "");
        assertFalse(controle.testeExiste(comparador.getNome()));
    }

    /**
     * Testa a alocação de diversos alunos a um grupo, incluindo com uma repetição de aluno.
     */
    @Test
    void testeAlocação(){
        controle.cadastraGrupo("Programação POO", "");
        controle.alocarAluno(lili, "Programação POO");
        controle.alocarAluno(torbjorn, "Programação POO");
        controle.alocarAluno(lili, "Programação POO");
    }

    /**
     * Testa se um aluno já está alocado a um determinado grupo. O resultado esperado é "true".
     */
    @Test
    void testeCadastroTrue(){
        controle.cadastraGrupo("Programação OO", "");
        controle.alocarAluno(gabriel, "Programação OO");
        assertTrue(controle.testeCadastro(gabriel.getMatricula(), "Programação OO"));
    }

    /**
     * Testa se um aluno já está alocado a um determinado grupo. O resultado esperado é "false".
     */
    @Test
    void testeCadastroFalse(){
        controle.cadastraGrupo("Programação OO", "");
        assertFalse(controle.testeCadastro(angela.getMatricula(), "Programação OO"));
    }

    /**
     * Testa o método de contagem de quantos grupos têm restrição para um determinado curso. O resultado esperado é 0.
     */
    @Test
    void testeContagemZero(){
        String contagem = controle.contagemRestricao("Ciência da Computação");
        String esperado = "Ciência da computação 0";
        assertEquals(esperado, contagem);
    }

    /**
     * Testa o método de contagem de quantos grupos têm restrição para um determinado curso. O resultado esperado, nesse caso,
     * é 5.
     */
    @Test
    void testeContagemNãoZero(){
        controle.cadastraGrupo("Programação POO", "Ciência da computação");
        controle.cadastraGrupo("Listas", "Ciência da computação");
        controle.cadastraGrupo("Geringonça", "Ciência da computação");
        controle.cadastraGrupo("Vice treco do subtroço", "Ciência da computação");
        controle.cadastraGrupo("Prince Ali handsome as he", "Ciência da computação");
        String expected = "Ciência da computação 5";
        String actual = controle.contagemRestricao("Ciência da computação");
        assertEquals(expected, actual);
    }

    
}
