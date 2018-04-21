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
        posicionaNaAresta();
    }

    ///construtor com rota especifica
    public AutoPilot(List <Vertice> menorRota, List <Aresta> origemDestino)
    {
        rotaAleatoria = false;
        this.menorRota = menorRota;
        arestaOrigem = origemDestino.get(0);
        arestaDestino = origemDestino.get(1);
        posicionaNaAresta();
    }

    public void posicionaNaAresta()
    {
        String direcao = arestaOrigem.getDirecao();
        super.setQuadranteAtual(arestaOrigem.getQuadrante());
        int coordenadas[][] = arestaOrigem.getCoordenadas();
        int xCentral, yCentral;

        if(direcao.equals("esquerda"))
        {
            xCentral = coordenadas[0][1] + (arestaOrigem.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(direcao.equals("direita"))
        {
            xCentral = coordenadas[0][0] + (arestaOrigem.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(direcao.equals("cima"))
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][1] + (arestaOrigem.getPeso() / 2 );
        }
        else
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][0] + (arestaOrigem.getPeso() / 2 );
        }

        super.setX(xCentral);
        super.setY(yCentral);
    }

    public void moveRandom()
    {

    }

    public void moveRota()
    {

    }

    protected Aresta arestaOrigem, arestaDestino;
    protected List <Vertice> menorRota;
    protected boolean rotaAleatoria;
}
