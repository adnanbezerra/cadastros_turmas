package turma;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestõesTest {

    private Questões registro;
    private Aluno bixote; 

    @BeforeEach
    void BeforeEach(){
        registro = new Questões();
        bixote = new Aluno("123", "Lor'themar Theron", "Magia");
    }

    /**
     * Se certifica de que é possível cadastrar um aluno na lista dos que resolveram questões.
     */
    @Test
    void testeRegistro(){
        registro.registraAluno(bixote);
    }

    /**
     * Testa o toString para o caso de que nenhum aluno tenha sido registrado ainda.
     */
    @Test
    void toStringVazio(){
        String expected = "";
        String actual = registro.toString();
        assertEquals(expected, actual);
    }

    /**
     * Testa o toString para o caso de uma lista não vazia, neste caso com três elementos.
     */
    @Test
    void toStringNãoVazio(){
        Aluno bixin = new Aluno("5167", "Kael'thas Sunstrider", "Magia");
        Aluno bixão = new Aluno("1284", "Jaina Proudmoore", "Magia");
        registro.registraAluno(bixote);
        registro.registraAluno(bixin);
        registro.registraAluno(bixão);
        String expected = "1 - 123 - Lor'themar Theron - Magia\n2 - 5167 - Kael'thas Sunstrider - Magia\n3 - 1284 - Jaina Proudmoore - Magia";
        String actual = registro.toString();
        assertEquals(expected, actual);
    }
}
