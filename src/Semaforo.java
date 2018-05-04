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
    public void run(int[][] mapa)
    {
        // laço que sempre acontecerá até que o programa finalize
        if (this.verde)
        {
            if (this.contadorDeTempo == this.duracao)
            {
                mudarCor();
            }
            else
            {
                if ((y + 1 <= 24 && mapa[y+1][x] != 9) && (y - 1 >= 0 && mapa[y-1][x] != 9) && (x + 1 <= 24 && mapa[y][x+1] != 9)
                        && (x - 1 >= 0 && mapa[y][x-1] != 9))// menor que o tamanho do mapa e não tiver um carro
                {
                    System.out.println(mapa[y+1][x] + " " + mapa[y-1][x] + " " + mapa[y][x+1] + " " + mapa[y][x-1]);
                    mudarCor();
                }
                else
                {
                    contadorDeTempo ++;
                }
            }
        }
        else
        {
            mudarCor();
        }
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
