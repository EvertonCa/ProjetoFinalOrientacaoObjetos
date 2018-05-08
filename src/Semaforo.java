import java.util.concurrent.Semaphore;

public class Semaforo
{
    public Semaforo(int x, int y, boolean verde, int duracao)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;
        this.duracao = duracao;
    }

    // Função que faz o semaforo mudar
    public boolean run(int[][] mapa)
    {
        boolean temCarro = false;
        //ABAIXO É O TESTE DO LUCAS
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//        System.out.println("mapa[" + (x + 1) + "] = " + mapa[y + 1][x]);
//        System.out.println("mapa[" + (x - 1) + "] = " + mapa[y - 1][x]);
//        System.out.println("mapa[" + (y + 1) + "] = " + mapa[y][x + 1]);
//        System.out.println("mapa[" + (y - 1) + "] = " + mapa[y][x - 1]);


        if(x + 1 <= 24 && mapa[y][x + 1] == 9)
        {
            temCarro = true;
        }
        else if(x - 1 >= 0 && mapa[y][x - 1] == 9)
        {
            temCarro = true;
        }
        else if(y + 1 <= 24 && mapa[y + 1][x] == 9)
        {
            temCarro = true;
        }
        else if(y - 1 >= 0 && mapa[y - 1][x] == 9)
        {
            temCarro = true;
        }
        else
        {
            temCarro = false;
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

    // metodo que faz a cor mudar de vermelho para verde e vice versa
    public void mudarCor()
    {
        if (this.verde) {
            this.verde = false;
        }
        else
        {
            this.verde = true;
        }
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

    public int getDuracao() {
        return duracao;
    }

    protected int x, y;
    protected int duracao;
    protected boolean verde;
}
