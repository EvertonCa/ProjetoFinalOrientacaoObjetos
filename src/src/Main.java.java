import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        ///cria��o do objeto mundo
        Mundo meuMundo = new Mundo();

        ///cria��o do objeto padrao de coordenadas de semaforos
        CoordenadasSemaforos coordenadas = new CoordenadasSemaforos();

        ///cria��o da lista que armazena os objetos semaforos do Q1
        ArrayList <Semaforo> semaforosQ1 = new ArrayList<>();

	///cria��o da lista que armazana os objetos semaforos do Q3
	ArrayList <Semaforo> semaforosQ3 = new ArrayList<>();

        ///adiciona os objetos semaforos com as coordenadas padr�o na lista do Q1
        for (int i=0; i < coordenadas.getSizeQ1(); i++)
        {
            semaforosQ1.add(new Semaforo(coordenadas.getCoordenadasXQ1(i), coordenadas.getCoordenadasYQ1(i), coordenadas.getVerdeQ1(i)));
        }

        ///adiciona os objetos semaforos com as coordenadas padr�o na lista do Q3
        for (int i=0; i < coordenadas.getSizeQ3(); i++)
        {
            semaforosQ3.add(new Semaforo(coordenadas.getCoordenadasXQ3(i), coordenadas.getCoordenadasYQ3(i), coordenadas.getVerdeQ3(i)));
        }

        ///boleano que gerencia se os veiculos entrados pelo usuario chegaram ao destino final
        boolean cheguei = false;

        ///loop infinito de execu��o do programa
        while (true)
        {
            ///loop de execu��o enquanto os veiculos nao chegam ao destino
            while (!cheguei)
            {
                ///popula os semaforos do Q1 no mundo
                for (int i=0; i < semaforosQ1.size(); i++)
                {
                    meuMundo.populaSemaforoQ1(semaforosQ1.get(i));
                }

                ///popula os semaforos do Q3 no mundo
                for (int i=0; i < semaforosQ3.size(); i++)
                {
                    meuMundo.populaSemaforoQ3(semaforosQ3.get(i));
                }

                ///desenha o mundo com os quadrantes 1 e 2
                meuMundo.desenhaMundo(meuMundo.getMundoQ1(), meuMundo.getMundoQ2());
                ///desenha o mundo com os quadrantes 3 e 4
                meuMundo.desenhaMundo(meuMundo.getMundoQ3(), meuMundo.getMundoQ4());
                ///pausa a execu��o do programa pelo tempo determinado
                meuMundo.pausaMundo();
            }
        }
    }
}