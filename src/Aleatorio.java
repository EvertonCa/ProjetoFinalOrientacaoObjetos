import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    public Aresta randomizeAresta(Grafo grafo)
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
    ///volta um número aleatório entre 1 e 300000
    public int randomizeID()
    {
        int id1 = ThreadLocalRandom.current().nextInt(1,100000);
        int id2 = ThreadLocalRandom.current().nextInt(1,100000);
        int id3 = ThreadLocalRandom.current().nextInt(1,100000);
        return id1+id2+id3;
    }


    protected int numero;
    protected Grafo grafo;
}
