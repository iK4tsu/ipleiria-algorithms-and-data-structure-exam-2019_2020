package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

import java.util.Objects;

public class Viagem {
    private String localPartida;
    private String localChegada;
    private Data dataPartida;
    private int horaPartida;
    private int duracao;

    public Viagem(String localPartida, String localChegada, Data dataPartida, int horaPartida, int duracao) {
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.dataPartida = dataPartida;
        this.horaPartida = horaPartida;
        this.duracao = duracao;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public Data getDataPartida() {
        return dataPartida;
    }

    public int getHoraPartida() {
        return horaPartida;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "localPartida='" + localPartida + '\'' +
                ", localChegada='" + localChegada + '\'' +
                ", dataPartida=" + dataPartida +
                ", horaPartida=" + horaPartida +
                ", duracao=" + duracao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagem viagem = (Viagem) o;
        return horaPartida == viagem.horaPartida &&
                duracao == viagem.duracao &&
                Objects.equals(localPartida, viagem.localPartida) &&
                Objects.equals(localChegada, viagem.localChegada) &&
                Objects.equals(dataPartida, viagem.dataPartida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localPartida, localChegada, dataPartida, horaPartida, duracao);
    }
}
