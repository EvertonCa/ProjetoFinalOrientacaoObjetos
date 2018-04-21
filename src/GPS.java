import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPS
{
    public GPS()
    {
        obterRuasUsuario();
        obterRota();

    }

    public void obterRuasUsuario()
    {
        Scanner teclado = new Scanner(System.in);
        boolean origemExiste = false, destinoExiste = false;

        while (!origemExiste)
        {
            System.out.printf("Entre com a origem: ");
            ruaOrigem = teclado.nextLine();

            origem = ruaParaVertice("origem");

            if(origem.equals("naoEncontrado"))
            {
                System.out.printf("Rua não encontrada! tente novamente!\n");
            }

            else
            {
                origemExiste = true;
            }
        }

        while (!destinoExiste)
        {
            System.out.printf("Entre com a destino: ");
            ruaDestino = teclado.nextLine();

            destino = ruaParaVertice("origem");

            if(destino.equals("naoEncontrado"))
            {
                System.out.printf("Rua não encontrada! tente novamente!\n");
            }

            else
            {
                destinoExiste = true;
            }
        }


    }

    public String ruaParaVertice(String origemOuDestino)
    {
        String resposta = "naoEncontrado";
        return resposta;
    }

    public void obterRota()
    {
        Grafo grafo = new Grafo();
        Dijkstra dijkstra = new Dijkstra();

        menorRota = dijkstra.encontrarMenorCaminhoDijkstra(grafo, grafo.encontrarVertice(origem), grafo.encontrarVertice(destino));
    }

    public void exibirMenorRota()
    {
        System.out.printf("A menor rota para o destino é a seguinte:\n");
        System.out.print(menorRota.get(0));

        for(int i = 1; i < menorRota.size(); i++)
        {
            System.out.printf(" -> ");
            System.out.print(menorRota.get(i));
        }
    }

    protected List <Vertice> menorRota = new ArrayList<Vertice>();
    protected String origem, destino, ruaOrigem, ruaDestino;
}
