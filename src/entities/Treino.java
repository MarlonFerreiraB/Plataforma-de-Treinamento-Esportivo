package entities;

import enums.Intensidade;
import enums.Status;
import enums.TipoTreino;
import exception.DataTreinoisBeforeException;

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
        if(data.isBefore(LocalDate.now())){
            throw new DataTreinoisBeforeException("A data so pode ser no dia de hoje a diante");
        }
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean cancelarTreino(){
        setStatus(Status.CANCELADO);
        return true;
    }

    public void concluirTreino(){
        setStatus(Status.REALIZADO);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treino{");
        sb.append("data=").append(data);
        sb.append(", tipoTreino=").append(tipoTreino);
        sb.append(", intensidade=").append(intensidade);
        sb.append(", status=").append(status);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", duracaoMinutos=").append(duracaoMinutos);
        sb.append('}');
        return sb.toString();
    }
}
