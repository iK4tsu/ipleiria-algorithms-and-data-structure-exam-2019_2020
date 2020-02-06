package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaCircularBaseNaoOrdenada;

public class GestorViagensNumaDataPartida
{
    private ListaDuplaCircularBaseLimiteOrdenada<Viagem> viagens;
    private TabelaHashPorSondagemComIncrementoQuadratico<String, ListaDuplaCircularBaseLimiteOrdenada<Viagem>> viagensPorLocalPartida;
    private static final IteradorIteravelDuplo<Viagem> ITERADOR_VIAGENS_VAZIO = new ListaDuplaCircularBaseNaoOrdenada<Viagem>().iterador();

    GestorViagensNumaDataPartida()
    {
        viagens = new ListaDuplaCircularBaseLimiteOrdenada<>(GestorViagens.ComparacaoLimiteViagensPorHoraPartidaAscendenteSeguidoPorLocalChegadaDescendente.CRITERIO);
        viagensPorLocalPartida = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
    }

    public void inserir(Viagem viagem)
    {
        viagens.inserir(viagem);
        String localPartida = viagem.getLocalPartida();
        ListaDuplaCircularBaseLimiteOrdenada<Viagem> viagensNoLocalPartida = viagensPorLocalPartida.consultar(localPartida);
        if (viagensNoLocalPartida == null)
        {
            viagensNoLocalPartida = new ListaDuplaCircularBaseLimiteOrdenada<>(GestorViagens.ComparacaoLimiteViagensPorHoraPartidaAscendenteSeguidoPorLocalChegadaDescendente.CRITERIO);
            viagensPorLocalPartida.inserir(localPartida, viagensNoLocalPartida);
        }
        viagensNoLocalPartida.inserir(viagem);
    }

    public IteradorIteravelDuplo<Viagem> iterador()
    {
        return viagens.iterador();
    }

    public IteradorIteravelDuplo<Viagem> consultar(String localPartida)
    {
        ListaDuplaCircularBaseLimiteOrdenada<Viagem> viagensNoLocalPartida = viagensPorLocalPartida.consultar(localPartida);
        if (viagensNoLocalPartida == null) return ITERADOR_VIAGENS_VAZIO;
        return viagensNoLocalPartida.iterador();
    }
}
