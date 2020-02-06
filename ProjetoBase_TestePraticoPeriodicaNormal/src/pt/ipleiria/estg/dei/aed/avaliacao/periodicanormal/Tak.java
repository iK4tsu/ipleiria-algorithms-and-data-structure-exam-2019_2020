package pt.ipleiria.estg.dei.aed.avaliacao.periodicanormal;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Tak
{
    Tak(int x, int y, int z)
    {
        getEstatistica(x,y,z);
    }


    private int tak(EstatisticaDeChamadas estatistica, int x, int y, int z)
    {
        estatistica.incrementarChamadas();
        if (x <= y) return y;
        return tak(estatistica,tak(estatistica,x-1,y,z), tak(estatistica,y-1,z,x), tak(estatistica,z-1,x,y));
    }

    private EstatisticaDeChamadas getEstatistica(int x, int y, int z)
    {
        EstatisticaDeChamadas estatistica = new EstatisticaDeChamadas(1);
        tak(estatistica, x, y, z);
        estatistica.parar();
        estatistica.apresentar();
        return estatistica;
    }
}