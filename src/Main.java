import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String argv[])
    {
        Grafo grafo = new Grafo();
        Dijkstra dijkstra = new Dijkstra();

        List <Vertice> menorRota = new ArrayList<Vertice>();

        menorRota = dijkstra.encontrarMenorCaminhoDijkstra(grafo, grafo.encontrarVertice("verticeNulo0"), grafo.encontrarVertice("vertice20"));

        for(int i = 0; i < menorRota.size(); i++)
        {
            System.out.print(menorRota.get(i));
            System.out.printf(" -> ");
        }
    }
}