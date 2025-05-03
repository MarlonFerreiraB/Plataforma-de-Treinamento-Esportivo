package services;

import entities.Atleta;
import entities.Treino;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAtleta {
    List<Atleta> atletaList = new ArrayList<>();


    public boolean addAtleta(Atleta atleta){
        for(Atleta a: atletaList){
            if(a.getName().equalsIgnoreCase(atleta.getName()) && a.getDataNascimento() == atleta.getDataNascimento()){
                System.out.println("Esse atleta ja existe");
                return false;
            }
        }
        atletaList.add(atleta);
        return true;
    }

    public Atleta procurarAtleta(String email){
        for(Atleta a: atletaList){
            if(a.getEmail().equalsIgnoreCase(email)){
                System.out.println("Atleta encontrado");
                return a;
            }
        }
        System.out.println("Atleta n encontrado");
        return null;
    }

    public boolean registraTreino(String email, Treino treino){
        for(Atleta a: atletaList){
            if(a.getEmail().equalsIgnoreCase(email)){
                a.resgistrarTreino(treino);
                return true;
            }
        }
        System.out.println("Este email n esta no nosso banco");
        return false;
    }

    public void exibirResumo(String email){
        for(Atleta a: atletaList){
            if(a.getEmail().equalsIgnoreCase(email)){
            a.exibirResumo();
            }
        }
    }
}
