package services;

import entities.Atleta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public Atleta procurarAtleta(String name, LocalDate date){
        for(Atleta a: atletaList){
            if(a.getName().equalsIgnoreCase(name) && a.getDataNascimento() == date){
                System.out.println("Atleta encontrado");
                return a;
            }
        }
        System.out.println("Atleta n encontrado");
        return null;
    }
}
