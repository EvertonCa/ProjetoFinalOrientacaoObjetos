import java.util.concurrent.Semaphore;

public class Semaforo
{
    public Semaforo(int x, int y, boolean verde, int duracao)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;
        this.duracao = duracao;
        this.contadorDeTempo = 0;
    }

    // Função que faz o semaforo mudar
    public boolean run(int[][] mapa)
    {
        boolean temCarro = false;
        //ABAIXO É O TESTE DO LUCAS

        if(x + 1 <= 24 && mapa[x + 1][y] == 9)
        {
            temCarro = false;
        }
        else if(x - 1 >= 0 && mapa[x - 1][y] == 9)
        {
            temCarro = false;
        }
        else if(y + 1 <= 24 && mapa[x][y + 1] == 9)
        {
            temCarro = false;
        }
        else if(y - 1 >= 0 && mapa[x][y - 1] == 9)
        {
            temCarro = false;
        }
        else
        {
            temCarro = true;
        }

        return temCarro;
        /*
        //A PARTIR DAQUI É O TESTE DO HELMUTH
        while(true)
        {
            if(mapa[x + 1][y] == 9)
            {
                cont++;
            }
            else if(mapa[x - 1][y] == 9)
            {
                cont++;
            }
            else if(mapa[x][y + 1] == 9)
            {
                cont++;
            }
            else if(mapa[x][y - 1] == 9)
            {
                cont++;
            }
        }*/
    }

    public void adicionaContador ()
    {
        contadorDeTempo ++;
    }

    // metodo que faz a cor mudar de vermelho para verde e vice versa
    private synchronized void mudarCor()
    {
        if (this.verde) {
            this.verde = false;
        }
        else
        {
            this.verde = true;
        }
        this.contadorDeTempo = 0;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean getVerde()
    {
        return verde;
    }

    protected int x, y;
    protected int duracao;
    protected boolean verde;
    protected int contadorDeTempo;
}
