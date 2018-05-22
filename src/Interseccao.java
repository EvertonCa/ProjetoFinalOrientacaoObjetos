import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Interseccao {
    Interseccao(List <Semaforo> litaSemaforos, int descricao) {
        this.listaSemaforos = litaSemaforos;
        this.descricao = descricao;
        this.contadorDeTempo = 0;
    }

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

//        System.out.println(contVermelho);System.out.println(contVerde);
        if (contVermelho != 0 && contVerde == 0 || contadorDeTempo >= listaSemaforos.get(0).getDuracao())
        {
            mudaCorVertice();
        }
        else
        {
            contadorDeTempo ++;
        }
    }

    public void mudaCorVertice ()
    {
        for(int i = 0; i < listaSemaforos.size(); i ++)
        {
            listaSemaforos.get(i).mudarCor();
        }
        contadorDeTempo = 0;
    }

    public List<Semaforo> getListaSemaforos() {
        return listaSemaforos;
    }


    private List <Semaforo> listaSemaforos;
    private int descricao;
    private int contadorDeTempo;
}