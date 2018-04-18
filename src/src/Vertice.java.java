public class Vertice
{
    public Vertice(int destino, int peso, int interseccaoInicial, int interseccaoFinal)
    {
        this.destino = destino;
        this.peso = peso;
        this.interseccaoInicial = interseccaoInicial;
        this.interseccaoFinal = interseccaoFinal;
    }

    protected int destino, peso, interseccaoInicial, interseccaoFinal;
}