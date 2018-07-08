package br.com.developers.allefsousa.testandroid.Data.Local;

/**
 * Created by allef on 07/07/2018.
 */

public class Salario { // gerar teste ctrl + shift + t

    private Double saldo;



    public Double somaSalario(Double salario, Double valor){
        return salario+valor;
    }
    public Double subtraiSalario(Double salario, Double valor){
        return salario-valor;
    }
    protected Double multiplicaSalario(Double salario, Double valor){
        return salario*valor;
    }
    protected Double divideSalario(Double salario, Double valor){
        return salario/valor;
    }


}
