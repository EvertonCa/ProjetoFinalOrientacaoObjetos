import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String argv[])
    {
       Grafo meuGrafo = new Grafo();
       Dijkstra meuDijkstra = new Dijkstra();

       List <Vertice> menorCaminho = new ArrayList<Vertice>();

       menorCaminho = meuDijkstra.encontrarMenorCaminhoDijkstra(meuGrafo, meuGrafo.encontrarVertice("vertice3"), meuGrafo.encontrarVertice("vertice1"));

       for(int i=0; i < menorCaminho.size(); i++)
       {
           System.out.print(menorCaminho.get(i));
           System.out.printf("\n");
       }

    }
}
