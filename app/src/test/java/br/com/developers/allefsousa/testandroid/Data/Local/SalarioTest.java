package br.com.developers.allefsousa.testandroid.Data.Local;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by allef on 07/07/2018.
 */
public class SalarioTest {


    @Before // antes
    public void setUp() throws Exception {
        Salario salario = new Salario();
        System.out.println("Iniciando Teste");

    }


    @After
    public void cleanup() {
        System.out.println("limpando teste");
    }

    @BeforeClass
    public static void testClassSetup() {
        System.out.println("Teste da classe iniciado");
    }

    @AfterClass
    public static void testClassCleanup() {
        System.out.println("Fim do teste");
    }


    @Test
    public void somaSalario() throws Exception {

    }

    @Test
    public void subtraiSalario() throws Exception {

    }

    @Test
    public void multiplicaSalario() throws Exception {
    }

    @Test
    public void divideSalario() throws Exception {
    }

}