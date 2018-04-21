import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPS
{
    public GPS()
    {
        obterOrigemDestino();
        obterRota();

    }

    public void obterOrigemDestino()
    {
        Scanner teclado = new Scanner(System.in);

        System.out.printf("Entre com a origem: ");
        origem = teclado.nextLine();
        System.out.printf("Entre com a destino: ");
        destino = teclado.nextLine();
    }

    public void obterRota()
    {
        Grafo grafo = new Grafo();
        Dijkstra dijkstra = new Dijkstra();

        menorRota = dijkstra.encontrarMenorCaminhoDijkstra(grafo, grafo.encontrarVertice(origem), grafo.encontrarVertice(destino));
    }

    public List<Vertice> getMenorRota()
    {
        return menorRota;
    }

    protected List <Vertice> menorRota = new ArrayList<Vertice>();
    protected String origem, destino;
}
