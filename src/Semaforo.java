import java.util.concurrent.Semaphore;

public class Semaforo
{
    // Contrutor do semaforo com coordenada, cor, duração e quadrante
    public Semaforo(int x, int y, boolean verde, int duracao, int quadrante)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;
        this.duracao = duracao;
        this.quadrante = quadrante;
    }

    // Função que identifica se o semaforo precisa mudar
    public boolean run(int[][] mapa)
    {
        boolean temCarro = false;

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
    }

    // metodo que faz a cor mudar do semaforo
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

    public int getQuadrante() {
        return quadrante;
    }

    protected int x, y;
    protected int duracao;
    protected boolean verde;
    private int quadrante;
}