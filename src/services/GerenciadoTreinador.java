package services;

import entities.Atleta;
import entities.Treinador;
import entities.Treino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadoTreinador {
    List<Treinador> treinadorList = new ArrayList<>();

    public boolean addTreinador(Treinador treinador){
        for(Treinador t: treinadorList){
            if(t.getName().equalsIgnoreCase(treinador.getName()) && t.getDataNascimento() == treinador.getDataNascimento()){
                System.out.println("Esse atleta ja existe");
                return false;
            }
        }
        treinadorList.add(treinador);
        return true;
    }

    public void prescreverTreino(Atleta atleta, Treino treino, String name, LocalDate date){
        for(Treinador t: treinadorList){
            if(t.getName().equalsIgnoreCase(name) && t.getDataNascimento() == date){
                t.prescreverTreino(atleta, treino);
            }
        }
        System.out.println("N foi possivel pescrever o treino");
    }

    public Treinador procurarTreinador(String email){
        for(Treinador t: treinadorList){
            if(t.getEmail().equalsIgnoreCase(email)){
                System.out.println("Treinador encontrado");
                return t;
            }
        }
        System.out.println("Treinador n encontrado");
        return null;
    }

    public void exbirResumo(String email){
        for(Treinador t: treinadorList){
            if(t.getEmail().equalsIgnoreCase(email)){
                t.exibirResumo();
            }
        }
    }
}
