import java.util.concurrent.Semaphore;

public class Semaforo extends Thread implements Runnable
{
    private boolean parar;
    private boolean corMudou;


    public Semaforo(int x, int y, boolean verde)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;

        this.parar = false;
        this.corMudou = false;

        new Thread(this).start();
    }

    @Override
    public void run()
    {
        while(!parar)
        {
            try {
                if (this.verde)
                    Thread.sleep(2000);
                else
                    Thread.sleep(2000);

                mudarCor();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mudarCor()
    {
        if (this.verde) {
            this.verde = false;
        }
        else
        {
            this.verde = true;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized  void esperaCorMudar()
    {
        while (!this.corMudou)
        {
            try {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
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

    protected int x, y;
    protected boolean verde;
}
