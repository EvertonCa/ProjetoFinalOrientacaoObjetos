import java.util.ArrayList;
import java.util.List;

public class AutoPilot extends Veiculos
{
    ///construtor com rota aleatoria
    public AutoPilot(Grafo grafo)
    {
        Aleatorio aleatorio = new Aleatorio();
        rotaAleatoria = true;
        arestaOrigem = aleatorio.randomizeAresta(grafo);
    }

    ///construtor com rota especifica
    public AutoPilot(List <Vertice> menorRota, List <Aresta> origemDestino)
    {
        rotaAleatoria = false;
        this.menorRota = menorRota;
        arestaOrigem = origemDestino.get(0);
        arestaDestino = origemDestino.get(1);
    }

    public void posicionaNaAresta()
    {
        String direcao;

    }

    public void move()
    {

    }

    protected Aresta arestaOrigem, arestaDestino;
    protected List <Vertice> menorRota;
    protected boolean rotaAleatoria;
}
