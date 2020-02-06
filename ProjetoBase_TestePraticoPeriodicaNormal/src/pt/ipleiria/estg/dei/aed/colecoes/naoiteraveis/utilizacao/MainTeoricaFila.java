package pt.ipleiria.estg.dei.aed.colecoes.naoiteraveis.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.naoiteraveis.estruturas.Fila;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;

public class MainTeoricaFila {

    public MainTeoricaFila() {
        Fila<Pessoa> filaPessoas = new Fila<>();

        filaPessoas.inserir(new Pessoa(3, "B"));
        filaPessoas.inserir(new Pessoa(1, "C"));
        filaPessoas.inserir(new Pessoa(2, "A"));

        System.out.println("filaPessoas\n" + filaPessoas);

        filaPessoas.remover();
        System.out.println("filaPessoas\n" + filaPessoas);

        System.out.println(filaPessoas.consultar());

        filaPessoas.remover();
        System.out.println("filaPessoas\n" + filaPessoas);
    }

    public static void main(String[] args) {
        new MainTeoricaFila();
    }
}
