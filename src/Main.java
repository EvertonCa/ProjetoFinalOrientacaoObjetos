import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        ///criação do objeto mundo
        Mundo meuMundo = new Mundo();

        ///criação do objeto padrao de coordenadas de semaforos
        CoordenadasSemaforos coordenadas = new CoordenadasSemaforos();

        ///criação da lista que armazena os objetos semaforos do Q1
        ArrayList <Semaforo> semaforosQ1 = new ArrayList<>();
        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q1
        for (int i=0; i < coordenadas.getSizeQ1(); i++)
        {
            semaforosQ1.add(new Semaforo(coordenadas.getCoordenadasXQ1(i), coordenadas.getCoordenadasYQ1(i), coordenadas.getVerdeQ1(i)));
        }

        while(true)
        {
            for (int i=0; i < semaforosQ1.size(); i++)
            {
                meuMundo.populaSemaforoQ1(semaforosQ1.get(i));
            }
            meuMundo.desenhaMundo(meuMundo.getMundoQ1());

            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
