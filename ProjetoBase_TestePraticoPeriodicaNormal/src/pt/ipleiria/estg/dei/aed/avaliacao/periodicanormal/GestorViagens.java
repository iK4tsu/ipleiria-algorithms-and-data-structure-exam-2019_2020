package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaCircularBaseNaoOrdenada;

public enum GestorViagens {
    INSTANCIA;

    private TabelaHashPorSondagem<Data, GestorViagensNumaDataPartida> viagens;
    public static final IteradorIteravelDuplo<Viagem> ITERADOR_VIAGENS_VAZIO = new ListaDuplaCircularBaseNaoOrdenada<Viagem>().iterador();

    GestorViagens() {
        viagens = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
    }

    public void inserir(Viagem viagem) {
        Data dataPartida = viagem.getDataPartida();

        GestorViagensNumaDataPartida viagensNumaDataPartida = viagens.consultar(dataPartida);
        if (viagensNumaDataPartida == null)
        {
            viagensNumaDataPartida = new GestorViagensNumaDataPartida();
            viagens.inserir(dataPartida, viagensNumaDataPartida);
        }
        viagensNumaDataPartida.inserir(viagem);
    }

    public IteradorIteravelDuplo<Viagem> consultar(Data dataPartida) {
        GestorViagensNumaDataPartida viagensNumaDataPartida = viagens.consultar(dataPartida);
        if (viagensNumaDataPartida == null) return ITERADOR_VIAGENS_VAZIO;
        return viagensNumaDataPartida.iterador();
    }

    public IteradorIteravelDuplo<Viagem> consultar(Data dataPartida, String localPartida) {
        GestorViagensNumaDataPartida viagensNumaDataPartida = viagens.consultar(dataPartida);
        if (viagensNumaDataPartida == null) return ITERADOR_VIAGENS_VAZIO;
        return viagensNumaDataPartida.consultar(localPartida);
    }


    public enum ComparacaoLimiteViagensPorHoraPartidaAscendenteSeguidoPorLocalChegadaDescendente implements ComparacaoLimite<Viagem>
    {
        CRITERIO;

        public static final Viagem LIMITE = new Viagem(null,null,null, Integer.MAX_VALUE,0);

        public int comparar(Viagem o1, Viagem o2)
        {
            int cp = Integer.compare(o1.getHoraPartida(), o2.getHoraPartida());
            if (cp != 0) return cp;
            return -o1.getLocalChegada().compareTo(o2.getLocalChegada());
        }

        public Viagem getLimite()
        {
            return LIMITE;
        }
    }
}
