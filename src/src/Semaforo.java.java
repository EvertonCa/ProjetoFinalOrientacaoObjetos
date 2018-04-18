public class Semaforo
{
    public Semaforo(int x, int y, boolean verde)
    {
        this.x = x;
        this.y = y;
        this.verde = verde;
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