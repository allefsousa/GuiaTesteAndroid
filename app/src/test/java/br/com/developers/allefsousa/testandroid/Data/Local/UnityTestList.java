package br.com.developers.allefsousa.testandroid.Data.Local;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by allef on 07/07/2018.
 */

public class UnityTestList {


    @Before
    public void setUp() throws Exception {
        System.out.println("--------------------------- Inicio teste --------------------");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--------------------------- Fim teste -----------------------");
    }

    @Test
    public void testWithAsserts() {
        List<String> list = generateStingList();
        assertTrue(list.contains("Toquio"));
        assertTrue(list.contains("Berlim"));
        assertTrue(list.size() > 2);
        assertTrue(list.size() < 13);
        assertTrue(list.size() == 8);
    }

    private List<String> generateStingList() {
        List<String> retorno = new ArrayList<>();
        retorno.add("Toquio");
        retorno.add("Berlim");
        retorno.add("Moscow");
        retorno.add("Rio");
        retorno.add("Nairobi");
        retorno.add("Denver");
        retorno.add("Helsinque");
        retorno.add("Oslo");


        return  retorno;
    }
}
