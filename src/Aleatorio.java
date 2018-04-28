import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    public Aresta randomizeArestaGrafo(Grafo grafo)
    {
        this.grafo = grafo;
        int quadrante = ThreadLocalRandom.current().nextInt(1,5);
        int tamanhoLista;
        switch (quadrante)
        {
            default:
            {
                tamanhoLista = grafo.getListaArestasQ1().size();
                return grafo.getListaArestasQ1().get(ThreadLocalRandom.current().nextInt(0,tamanhoLista));
            }

            case 2:
            {
                tamanhoLista = grafo.getListaArestasQ2().size();
                return grafo.getListaArestasQ2().get(ThreadLocalRandom.current().nextInt(0,tamanhoLista));
            }

            case 3:
            {
                tamanhoLista = grafo.getListaArestasQ3().size();
                return grafo.getListaArestasQ3().get(ThreadLocalRandom.current().nextInt(0,tamanhoLista));
            }

            case 4:
            {
                tamanhoLista = grafo.getListaArestasQ4().size();
                return grafo.getListaArestasQ4().get(ThreadLocalRandom.current().nextInt(0,tamanhoLista));
            }
        }
    }

    public String randomizaRua()
    {
        String rua;
        int numero;

        numero = ThreadLocalRandom.current().nextInt(0,90);

        rua = "Rua " + numero;
        return rua;
    }

    public String randomizaRuaComExcecao(String excecao)
    {
        String rua = randomizaRua();

        while (rua.equals(excecao))
        {
            rua = randomizaRua();
        }

        return rua;
    }

    public Aresta randomizeArestaVertice(Vertice vertice)
    {
        List <Aresta> listaDeArestas = vertice.getArestas();
        int tamanho = listaDeArestas.size();
        return listaDeArestas.get(ThreadLocalRandom.current().nextInt(0,tamanho+1));
    }

    ///volta um número aleatório entre 100 e 300000
    public int randomizeID()
    {
        int id = ThreadLocalRandom.current().nextInt(100,300000);
        return id;
    }

    public int randomizeIDParaAleatorios()
    {
        int id = ThreadLocalRandom.current().nextInt(300001,600000);
        return id;
    }


    protected int numero;
    protected Grafo grafo;
}
