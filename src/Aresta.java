public class Aresta
{
    public Aresta(Vertice origem, Vertice destino, int peso)
    {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getPeso()
    {
        return peso;
    }

    public Vertice getDestino()
    {
        return destino;
    }

    public Vertice getOrigem()
    {
        return origem;
    }

    protected Vertice origem, destino;
    protected int peso;
}
