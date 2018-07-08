package br.com.developers.allefsousa.testandroid.Data.Local;

/**
 * Created by allef on 07/07/2018.
 */

public class Salario {

    private Double saldo;



    private Double somaSalario(Double salario, Double valor){
        return salario+valor;
    }
    private Double subtraiSalario(Double salario, Double valor){
        return salario-valor;
    }
    private Double multiplicaSalario(Double salario, Double valor){
        return salario*valor;
    }
    private Double divideSalario(Double salario, Double valor){
        return salario/valor;
    }


}
