package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ArvoreBinaria;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores.ComparacaoLimitePessoasPorNomeAscendente;

public class MainTeoricaArvoreBinaria {

    private MainTeoricaArvoreBinaria() {
        ArvoreBinaria<Pessoa> arvoreBinariaPessoasNome = new ArvoreBinaria<>(ComparacaoLimitePessoasPorNomeAscendente.CRITERIO);

        Pessoa[] pessoas = {
                new Pessoa(3, "P"),
                new Pessoa(8, "F"),
                new Pessoa(2, "M"),
                new Pessoa(1, "T"),
                new Pessoa(7, "A"),
                new Pessoa(4, "R"),
                new Pessoa(10, "Q"),
                new Pessoa(5, "I"),
                new Pessoa(13, "X"),
                new Pessoa(11, "Z")
        };

        // Remoção de pessoa que não existe
        arvoreBinariaPessoasNome.remover(new Pessoa(6, "D"));

        for (Pessoa pessoa : pessoas) {
            arvoreBinariaPessoasNome.inserir(pessoa);
        }

        System.out.println("\nTodas as pessoas em pré-ordem:");
        for (Pessoa pessoa : arvoreBinariaPessoasNome.iteradorPreOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em ordem:");
        for (Pessoa pessoa : arvoreBinariaPessoasNome.iteradorEmOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em ordem com nome entre B e R:");
        for (Pessoa pessoa : arvoreBinariaPessoasNome.consultar(new Pessoa(0, "B"), new Pessoa(0, "R"))) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas em pós-ordem:");
        for (Pessoa pessoa : arvoreBinariaPessoasNome.iteradorPosOrdem()) {
            System.out.println(pessoa);
        }

        System.out.println("\nTodas as pessoas por níveis:");
        for (Pessoa pessoa : arvoreBinariaPessoasNome.iteradorPorNiveis()) {
            System.out.println(pessoa);
        }


        System.out.println("\nPessoa na 4ª posição: " + arvoreBinariaPessoasNome.consultar(3));

        arvoreBinariaPessoasNome.remover(new Pessoa(7, "A")); // Caso sem filhos
        arvoreBinariaPessoasNome.remover(new Pessoa(2, "M")); // Caso apenas com filho à esquerda
        arvoreBinariaPessoasNome.remover(new Pessoa(8, "F")); // Caso apenas com filho à direita
        arvoreBinariaPessoasNome.remover(new Pessoa(3, "P")); // Caso com dois filhos em que paiMenorElemento != filho
        arvoreBinariaPessoasNome.removerPorReferencia(pessoas[3]);     // Caso com dois filhos em que paiMenorElemento == filho

    }

    public static void main(String[] args) {
        new MainTeoricaArvoreBinaria();
    }
}
