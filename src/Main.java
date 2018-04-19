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

        ArrayList <Semaforo> semaforosQ2 = new ArrayList<>();
      
        ///criação da lista que armazana os objetos semaforos do Q3
	      ArrayList <Semaforo> semaforosQ3 = new ArrayList<>();   
      
        ///criação da lista que armazana os objetos semaforos do Q4
        ArrayList <Semaforo> semaforosQ4 = new ArrayList<>();

        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q1
        for (int i=0; i < coordenadas.getSizeQ1(); i++)
        {
            semaforosQ1.add(new Semaforo(coordenadas.getCoordenadasXQ1(i), coordenadas.getCoordenadasYQ1(i), coordenadas.getVerdeQ1(i)));
        }
      
        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q2
        for (int i=0; i < coordenadas.getSizeQ2(); i++)
        {
            semaforosQ2.add(new Semaforo(coordenadas.getCoordenadasXQ2(i), coordenadas.getCoordenadasYQ2(i), coordenadas.getVerdeQ2(i)));
        }
        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q3
        for (int i=0; i < coordenadas.getSizeQ3(); i++)
        {
            semaforosQ3.add(new Semaforo(coordenadas.getCoordenadasXQ3(i), coordenadas.getCoordenadasYQ3(i), coordenadas.getVerdeQ3(i)));
        }

        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q4
        for (int i=0; i < coordenadas.getSizeQ4(); i++)
        {
            semaforosQ4.add(new Semaforo(coordenadas.getCoordenadasXQ4(i), coordenadas.getCoordenadasYQ4(i), coordenadas.getVerdeQ4(i)));
        }

        ///boleano que gerencia se os veiculos entrados pelo usuario chegaram ao destino final
        boolean cheguei = false;

        ///loop infinito de execução do programa
        while (true)
        {
            ///loop de execução enquanto os veiculos nao chegam ao destino
            while (!cheguei)
            {
                ///popula os semaforos do Q1 no mundo
                for (int i=0; i < semaforosQ1.size(); i++)
                {
                    meuMundo.populaSemaforoQ1(semaforosQ1.get(i));
                }

                ///popula os semaforos do Q2 no mundo
                for (int i=0; i < semaforosQ2.size(); i++)
                {
                    meuMundo.populaSemaforoQ2(semaforosQ2.get(i));
                }
                ///popula os semaforos do Q3 no mundo
                for (int i=0; i < semaforosQ3.size(); i++)
                {
                    meuMundo.populaSemaforoQ3(semaforosQ3.get(i));
                }  
                ///popula os semaforos do Q4 no mundo
                for (int i=0; i < semaforosQ4.size(); i++)
                {
                    meuMundo.populaSemaforoQ4(semaforosQ4.get(i));
                }

                              

                ///desenha o mundo com os quadrantes 1 e 2
                meuMundo.desenhaMundo(meuMundo.getMundoQ1(), meuMundo.getMundoQ2());
                ///desenha o mundo com os quadrantes 3 e 4
                meuMundo.desenhaMundo(meuMundo.getMundoQ3(), meuMundo.getMundoQ4());
                ///pausa a execução do programa pelo tempo determinado
                meuMundo.pausaMundo();
            }
        }
    }
}
