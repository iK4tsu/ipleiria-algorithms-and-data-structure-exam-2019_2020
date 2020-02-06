package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.Maximo;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;

public class MainPraticaMaximo {
    public MainPraticaMaximo() {
        Maximo maximo = new Maximo();

        ArrayList<Estatistica> estatisticas = new ArrayList<>();
        int[] ns = {5, 10};
        for (int n : ns) {
            estatisticas.add(maximo.getEstatistica(
                    VetorDeInteiros.criarAleatorioInt(n, -50, 50, true)));
        }

        VisualizadorEstatisticas visualizadorEstatisticas =
                new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Máximo", estatisticas);
        visualizadorEstatisticas.visualizar();

        VisualizadorEstatisticas visualizadorGrafico
                = new VisualizadorEstatisticas();
        ArrayList<Estatistica> estatisticasGrafico = new ArrayList<>();
        for (int i = 10; i < 501; i += 10) {
            estatisticasGrafico.add(
                    maximo.getEstatistica(VetorDeInteiros.criarAleatorioInt(i, true)));
        }
        visualizadorGrafico.adicionarEstatisticas("Máximo", estatisticasGrafico);
        visualizadorGrafico.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaMaximo();
    }
}
