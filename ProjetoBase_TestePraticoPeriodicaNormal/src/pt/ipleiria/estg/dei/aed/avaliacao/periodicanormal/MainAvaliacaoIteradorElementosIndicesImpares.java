package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.ComparacaoLimiteInteirosAscendente;

public class MainAvaliacaoIteradorElementosIndicesImpares {

    private MainAvaliacaoIteradorElementosIndicesImpares() {
        ListaDuplaCircularBaseLimiteOrdenada<Integer> listaInteiros = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteInteirosAscendente.CRITERIO);

        long before = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            listaInteiros.inserir(i);
        }

        for (int i = 0; i < 1000; i++) {
        System.out.println("Lista com elementos de 0 a 9");
        for (Integer elementoIndiceImpar : listaInteiros.iteradorElementosIndicesImpares()) {
            System.out.println(elementoIndiceImpar);
        }

        System.out.println("\nLista com elementos de 0 a 10");
        listaInteiros.inserir(10);
        for (Integer elementoIndiceImpar : listaInteiros.iteradorElementosIndicesImpares()) {
            System.out.println(elementoIndiceImpar);
        }

        System.out.println("\nLista com elementos de 0 a 11");
        listaInteiros.inserir(11);
        for (Integer elementoIndiceImpar : listaInteiros.iteradorElementosIndicesImpares()) {
            System.out.println(elementoIndiceImpar);
        }}
        long now = System.currentTimeMillis();
        System.out.println("Seconds elapsed: " + (now-before)/1000F + " seconds." );
    }

    public static void main(String[] args) {
        new MainAvaliacaoIteradorElementosIndicesImpares();
    }
}
