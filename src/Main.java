import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Semaforo semaforo = new Semaforo(1, 4, false);

        for(int i = 0; i < 10; i++)
        {
            if (semaforo.getVerde())
                System.out.println("Verde");
            else
                System.out.println("Vermelho");

            semaforo.esperaCorMudar();
        }

    }
}
