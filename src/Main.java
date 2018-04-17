import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Mundo meuMundo = new Mundo();
        CoordenadasSemaforos coordenadas = new CoordenadasSemaforos();

        ArrayList <Semaforo> semaforosQ1 = new ArrayList<>();

        for (int i=0; i < coordenadas.getSizeQ1(); i++)
        {
            semaforosQ1.add(new Semaforo(coordenadas.getCoordenadasXQ1(i), coordenadas.getCoordenadasYQ1(i), coordenadas.getVerdeQ1(i)));
        }

        for (int i=0; i < semaforosQ1.size(); i++)
        {
            meuMundo.populaSemaforoQ1(semaforosQ1.get(i));
        }

        meuMundo.desenhaMundo();
        meuMundo.pausaMundo();
    }
}
