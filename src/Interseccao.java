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

    public void verificaSemaforo (int[][] mapa)
    {
        int contVerde = 0;
        int contVermelho = 0;

        boolean temCarro[] = new boolean[listaSemaforos.size()];

        for(int i = 0; i < listaSemaforos.size(); i ++)
        {
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

//        System.out.println(contVermelho);System.out.println(contVerde);
        if (contVermelho != 0 && contVerde == 0 || contadorDeTempo == listaSemaforos.get(0).getDuracao())
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
