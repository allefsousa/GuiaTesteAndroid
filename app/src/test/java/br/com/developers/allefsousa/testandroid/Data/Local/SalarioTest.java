package br.com.developers.allefsousa.testandroid.Data.Local;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Console;

import static org.junit.Assert.*;

/**
 * Created by allef on 07/07/2018.
 */
public class SalarioTest {

    Salario salario;
    /**
     * quando o teste é iniciado
     * @throws Exception
     */
    @Before // antes
    public void setUp() throws Exception {
         salario = new Salario();
        System.out.println("Iniciando Teste");

    }

    /**
     * quando o teste Termina
     */
    @After
    public void cleanup() {
        System.out.println("FIM TESTE");

    }

    /**
     * Quando a classe começa aser testada
     */
    @BeforeClass
    public static void testClassSetup() {
        System.out.println("Teste da classe iniciado");
    }

    /**
     * Exibir algo apos o fim do teste  da claasse
     */
    @AfterClass
    public static void testClassCleanup() {
        System.out.println("Fim do teste");
    }

    /**
     * Os valores do assert sao passados
     * resultado esperado , o resultado da operação , e o valor que você aceitar como margem ;
     * @throws Exception
     */
    @Test
    public void somaSalario() throws Exception {

        Double resultado = salario.somaSalario(10.0,10.0);
        assertEquals(20.0,resultado,0.0);

    }

    @Test
    public void subtraiSalario() throws Exception {
        Double resultado = salario.subtraiSalario(10.0,10.0);
        assertEquals(0.0,resultado,0.0);

    }

    @Test
    public void multiplicaSalario() throws Exception {
        Double resultado = salario.multiplicaSalario(10.0,10.0);
        assertEquals(100.0,resultado,0.0);
    }

    @Test
    public void divideSalario() throws Exception {
        Double resultado = salario.divideSalario(10.0,10.0);
        assertEquals(01.0,resultado,0.0);
    }

}