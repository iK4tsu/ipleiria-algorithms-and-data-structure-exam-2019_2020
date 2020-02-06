package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

public class MainAvaliacaoViagens {

    private MainAvaliacaoViagens() {
        Viagem[] viagens = {
                new Viagem("Lisboa", "Porto", new Data(1, 1, 2020), 8, 1),
                new Viagem("Lisboa", "Porto", new Data(1, 1, 2020), 10, 1),
                new Viagem("Porto", "Lisboa", new Data(1, 1, 2020), 8, 1),
                new Viagem("Porto", "Lisboa", new Data(2, 1, 2020), 14, 1),
                new Viagem("Lisboa", "Londres", new Data(1, 1, 2020), 6, 3),
                new Viagem("Lisboa", "Londres", new Data(2, 1, 2020), 6, 3),
                new Viagem("Porto", "Londres", new Data(1, 1, 2020), 10, 2),
                new Viagem("Porto", "Roma", new Data(1, 1, 2020), 13, 4),
                new Viagem("Porto", "Roma", new Data(1, 1, 2020), 10, 4)
        };

        long before = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
        for (Viagem viagem : viagens) {
            GestorViagens.INSTANCIA.inserir(viagem);
        }

        System.out.println("\nViagens no dia 1-1-2020:");
        for (Viagem viagem : GestorViagens.INSTANCIA.consultar(new Data(1, 1, 2020))) {
            System.out.println(viagem);
        }

        System.out.println("\nViagens no dia 1-1-2020, a partir do Porto");
        for (Viagem viagem : GestorViagens.INSTANCIA.consultar(new Data(1, 1, 2020), "Porto")) {
            System.out.println(viagem);
        }}
        long now = System.currentTimeMillis();
        System.out.println("Seconds elapsed: " + (now-before)/1000F + " seconds." );
    }

    public static void main(String[] args) {
        new MainAvaliacaoViagens();
    }
}
