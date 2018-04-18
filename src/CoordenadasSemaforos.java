public class CoordenadasSemaforos
{
    public int getSizeQ1()
    {
        return coordenadasXQ1.length;
    }

    public int getSizeQ2()
    {
        return coordenadasXQ2.length;
    }

    public int getSizeQ3()
    {
        return coordenadasXQ3.length;
    }

    public int getSizeQ4()
    {
        return coordenadasXQ4.length;
    }

    public int getCoordenadasXQ1(int i)
    {
        return coordenadasXQ1[i];
    }

    public int getCoordenadasYQ1(int i)
    {
        return coordenadasYQ1[i];
    }

    public boolean getVerdeQ1(int i)
    {
        return verdeQ1[i];
    }

    public int getCoordenadasXQ2(int i)
    {
        return coordenadasXQ2[i];
    }

    public int getCoordenadasYQ2(int i)
    {
        return coordenadasYQ2[i];
    }

    public boolean getVerdeQ2(int i)
    {
        return verdeQ2[i];
    }

    public int getCoordenadasXQ3(int i)
    {
        return coordenadasXQ3[i];
    }

    public int getCoordenadasYQ3(int i)
    {
        return coordenadasYQ3[i];
    }

    public boolean getVerdeQ3(int i)
    {
        return verdeQ3[i];
    }

    public int getCoordenadasXQ4(int i)
    {
        return coordenadasXQ4[i];
    }

    public int getCoordenadasYQ4(int i)
    {
        return coordenadasYQ4[i];
    }

    public boolean getVerdeQ4(int i)
    {
        return verdeQ4[i];
    }

    //31 semaforos Q1
    protected int coordenadasXQ1[] = {3,3,7,7,7,8,8,8,17,17,17,18,18,22,22,22,23,23,32,33,37,37,38,47,47,48,48,52,52,52,53};
    protected int coordenadasYQ1[] = {15,40,9,34,54,14,39,59,10,35,55,15,40,9,34,54,28,59,55,45,39,59,44,24,40,29,45,23,39,59,44};
    protected boolean verdeQ1[] = {true, true, true, true, true, false, false, false, false, false, false, true, true,
            true, true, true, false, false, false, true, true, true, false, false, false, true, true, true, true, true, false};

    //xx semaforos Q2
    protected int coordenadasXQ2[] = {10,9,14,15,10,14,13,34,39,45,50,58,57,10,9,14,15,24,25,30,40,45,46,53,58,52,41,46};
    protected int coordenadasYQ2[] = {3,8,9,4,22,26,29,22,23,22,23,23,26,46,51,52,47,51,46,47,51,52,47,46,47,51,54,55};
    protected boolean verdeQ2[] = {true, true, true, true, true, false, false, false, false, false, false, true, true,
            true, true, true, false, false, false, true, true, true, false, false, false, true, true, true};

    //xx semaforos Q3
    protected int coordenadasXQ3[] = {};
    protected int coordenadasYQ3[] = {};
    protected boolean verdeQ3[] = {};

    //xx semaforos Q4
    protected int coordenadasXQ4[] = {};
    protected int coordenadasYQ4[] = {};
    protected boolean verdeQ4[] = {};

}
