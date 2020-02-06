package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.util.Arrays;

public class Maximo {
    public int executar(EstatisticaDeComparacoes estatistica, int... valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("Pelo menos um valor");
        }

        int indiceMaximo = 0;
        for (int i = 1; i < valores.length; i++) {
            estatistica.incrementarComparacoes();
            if (valores[i] > valores[indiceMaximo]) {
                indiceMaximo = i;
            }
        }
        return valores[indiceMaximo];
    }

    public EstatisticaDeComparacoes getEstatistica(int... valores) {
        try {
            EstatisticaDeComparacoes estatistica =
                    new EstatisticaDeComparacoes(valores.length);
            int maximo = executar(estatistica, valores);
            estatistica.parar();
            System.out.println("máximo(" + Arrays.toString(valores) + ") = " + maximo);
            estatistica.apresentar();
            return estatistica;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
