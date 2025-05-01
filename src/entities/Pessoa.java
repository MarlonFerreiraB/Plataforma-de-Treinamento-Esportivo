package entities;

import enums.PerfilUsuario;
import exception.DataNascimentoException;

import javax.sound.sampled.Port;
import java.time.LocalDate;

public abstract class Pessoa {
    protected String name;
    protected String email;
    protected LocalDate dataNascimento;
    protected PerfilUsuario perfil;

    public Pessoa(String name,String email, LocalDate dataNascimento, PerfilUsuario perfil) throws DataNascimentoException {
        this.name =name;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.perfil = perfil;
        if(dataNascimento.isAfter(LocalDate.now())){
            throw new DataNascimentoException("Error: Nascimento esta errado");
        }

    }

    public String getName(){return name;}

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }
}
