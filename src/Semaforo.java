import java.util.concurrent.Semaphore;

public class Semaforo extends Thread implements Runnable
{
    public Semaforo(int x, int y, boolean verde, int duracao)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;
        this.duracao = duracao;

        this.parar = false;

        new Thread(this).start();
    }

    // Função que faz o semaforo mudar
    @Override
    public void run()
    {
        // laço que sempre acontecerá até que o programa finalize
        while(!parar)
        {
            try {
                if (this.verde)
                    Thread.sleep(this.duracao);
                else
                    Thread.sleep(this.duracao);

                this.mudarCor();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
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
    }

    public synchronized void deligarSemaforo ()
    {
        this.parar = true;
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
    private boolean parar;
}
