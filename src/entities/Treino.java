package entities;

import enums.Intensidade;
import enums.Status;
import enums.TipoTreino;

import java.time.LocalDate;

public class Treino {
    private LocalDate data;
    private TipoTreino tipoTreino;
    private Intensidade intensidade;
    private Status status;
    private String descricao;
    private int duracaoMinutos;

    public Treino(LocalDate data, TipoTreino tipoTreino, Intensidade intensidade, Status status, String descricao, int duracaoMinutos){
        this.data = data;
        this.tipoTreino = tipoTreino;
        this.intensidade = intensidade;
        this.status = status;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoTreino getTipoTreino() {
        return tipoTreino;
    }

    public Intensidade getIntensidade() {
        return intensidade;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
}
