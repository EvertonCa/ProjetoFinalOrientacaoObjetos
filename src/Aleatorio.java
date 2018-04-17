import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    ///volta um número aleatório entre 1 e 4
    public int randomizeDirecao()
    {
        numero = ThreadLocalRandom.current().nextInt(1,5);
        return numero;
    }

    ///volta um número aleatório entre 0 e 30
    public int randomize30()
    {
        numero = ThreadLocalRandom.current().nextInt(0,30);
        return numero;
    }

    ///volta um número aleatório entre 0 e 60
    public int randomize60()
    {
        numero = ThreadLocalRandom.current().nextInt(0,60);
        return numero;
    }

    ///volta um número aleatório entre 1 e 5
    public int randomizePassageiros()
    {
        numero = ThreadLocalRandom.current().nextInt(1,6);
        return numero;
    }

    ///volta um número aleatório entre 10000 e 30000
    public int randomizeCarga()
    {
        numero = ThreadLocalRandom.current().nextInt(10000,30001);
        return numero;
    }

    ///volta um número aleatório entre 1 e 300000
    public int randomizeID()
    {
        int id1 = ThreadLocalRandom.current().nextInt(1,100000);
        int id2 = ThreadLocalRandom.current().nextInt(1,100000);
        int id3 = ThreadLocalRandom.current().nextInt(1,100000);
        return id1+id2+id3;
    }

    ///volta um tipo de moto aleatória
    public String randomizeTipo()
    {
        int random;
        random = ThreadLocalRandom.current().nextInt(0,3);

        switch (random)
        {
            case 0: {
                return "Esportiva";
            }

            case 1: {
                return "Estradeira";
            }

            default: {
                return "Dia-a-Dia";
            }
        }
    }

    protected int numero;
}
