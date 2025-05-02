package entities;

import enums.PerfilUsuario;
import exception.DataNascimentoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Treinador extends Pessoa{
    private List<Atleta> atletaOrientados = new ArrayList<>();

    public Treinador(String name, String email, LocalDate dataNascimento, PerfilUsuario perfil) throws DataNascimentoException {
        super(name, email, dataNascimento, perfil);
    }


    public List<Atleta> getAtletaOrientados() {
        return atletaOrientados;
    }

    public void prescreverTreino(Atleta atleta, Treino treino){
        Atleta novoAtleta = atleta;
        atletaOrientados.add(novoAtleta);
    }

    @Override
    public void exibirResumo(){
        super.exibirResumo();
        for(Atleta a : atletaOrientados){
            System.out.println(a);
        }

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treinador{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", email='").append(email).append('\'');
        sb.append(", perfil=").append(perfil);
        sb.append('}');
        return sb.toString();
    }
}
