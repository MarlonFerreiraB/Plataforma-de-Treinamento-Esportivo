package entities;

import enums.PerfilUsuario;
import exception.DataNascimentoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atleta extends Pessoa {
    private List<Treino> treinoList = new ArrayList<>();
    private double peso;
    private double altura;

    public Atleta(String name, String email, LocalDate dataNascimento, PerfilUsuario perfil, double peso, double altura) throws DataNascimentoException {
        super(name, email, dataNascimento, perfil);
        this.peso = peso;
        this.altura = altura;
        if(peso < 0){
            throw new IllegalArgumentException("Error: Peso negativo");
        }
        if(altura < 0){
            throw new IllegalArgumentException("Error: Altura negativa");
        }
    }

    public List<Treino> getTreinoList() {
        return treinoList;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void resgistrarTreino(Treino treino){
        for(Treino t: treinoList){
            if(treino.getData() == t.getData() && treino.getTipoTreino() == t.getTipoTreino()){
                System.out.println("Esse treino ja existe.");
            }
        }
        treinoList.add(treino);
    }

    public void exibirTreinos(){
        for(Treino t: treinoList){
            System.out.println(t);
        }
    }

    public double calcularIMC(){
        return peso / (altura * altura);
    }

    @Override
    public void exibirResumo(){
        super.exibirResumo();
        System.out.println("Nome: " + name);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("IMC: " + calcularIMC());
        System.out.println("Treinos: ");
        exibirTreinos();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atleta{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", perfil=").append(perfil);
        sb.append(", peso=").append(peso);
        sb.append(", altura=").append(altura);
        sb.append("treinoList=").append(treinoList);
        sb.append('}');
        return sb.toString();
    }
}
