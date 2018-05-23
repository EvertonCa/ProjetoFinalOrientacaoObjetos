/**
 / Classe responsável por agrupar e fazer a lógica da inteligencia dos semaforos em grupo
 **/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Interseccao {
    /// Construtor da instersecção que tem como parâmetros (lista com todos os semaforos na intersecção e o número que
    // ela é chamda no mundo de grades)
    Interseccao(List <Semaforo> litaSemaforos, int descricao) {
        this.listaSemaforos = litaSemaforos;
        this.descricao = descricao;
        this.contadorDeTempo = 0;
    }

    /// Lógica para saber se os semáforos podem mudar de cor
    public void verificaSemaforo (Mundo meuMundo)
    {
        int contVerde = 0;
        int contVermelho = 0;
        int[][] mapa;

        boolean temCarro[] = new boolean[listaSemaforos.size()];

        for(int i = 0; i < listaSemaforos.size(); i ++)
        {
            if (listaSemaforos.get(i).getQuadrante() == 1)
            {
                mapa = meuMundo.getMundoQ1();
            }
            else if (listaSemaforos.get(i).getQuadrante() == 2)
            {
                mapa = meuMundo.getMundoQ2();
            }
            else if (listaSemaforos.get(i).getQuadrante() == 3)
            {
                mapa = meuMundo.getMundoQ3();
            }
            else
            {
                mapa = meuMundo.getMundoQ4();
            }

            temCarro[i] = listaSemaforos.get(i).run(mapa);
            if (temCarro[i] && !listaSemaforos.get(i).getVerde())
            {
                contVermelho ++;
            }
            else if (temCarro[i] && listaSemaforos.get(i).getVerde())
            {
                contVerde ++;
            }
        }

        if (contVermelho == 0 && contVerde != 0)
        {
            contadorDeTempo = 0;
        }

        if (contVermelho != 0 && contVerde == 0 || contadorDeTempo >= listaSemaforos.get(0).getDuracao())
        {
            mudaCorVertice();
        }
        else
        {
            contadorDeTempo ++;
        }
    }

    /// Método que muda a cor de todos os semáforos que estão no vertice
    public void mudaCorVertice ()
    {
        for(int i = 0; i < listaSemaforos.size(); i ++)
        {
            listaSemaforos.get(i).mudarCor();
        }
        contadorDeTempo = 0;
    }

    /// Método que envia a lista de semáforos que tem na intersecção chamada
    public List<Semaforo> getListaSemaforos() {
        return listaSemaforos;
    }


    private List <Semaforo> listaSemaforos;
    private int descricao;
    private int contadorDeTempo;
}