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
    protected int peso, quadrante;
    /// matriz que indica as coordenadas das "ruas" no mundo
    // {{coordenada inicial X, coordenada final X},{coordenada inicial Y, coordenada final Y}}
    protected int [][] direita = {{0,0},{0,0}};
    protected int [][] esquerda = {{0,0},{0,0}};
    protected int [][] cima = {{0,0},{0,0}};
    protected int [][] baixo = {{0,0},{0,0}};



}
