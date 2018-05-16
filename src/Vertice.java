/**
 / Classe que armazena os vertices do grafo.
 **/

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice>
{
    /// construtor padrão
    public Vertice()
    {
        visitado = false;
    }

    public void setArestas(List<Aresta> arestas)
    {
        this.arestas.addAll(arestas);
    }

    public List<Aresta> getArestas()
    {
        return arestas;
    }

    public void setVerticesVizinhos(List<Vertice> verticesVizinhos)
    {
        this.verticesVizinhos.addAll(verticesVizinhos);
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setPai(Vertice pai)
    {
        this.pai = pai;
    }

    public Vertice getPai()
    {
        return pai;
    }

    public boolean verificaVisita()
    {
        return visitado;
    }

    public void visitar()
    {
        visitado = true;
    }

    public void setDistancia(int distancia)
    {
        this.distancia = distancia;
    }

    public int getDistancia()
    {
        return distancia;
    }

    public void setQuadrante(int quadrante) {
        this.quadrante = quadrante;
    }


    public int compareTo(Vertice vertice)
    {
        if(this.getDistancia() < vertice.getDistancia())
            return -1;

        else if(this.getDistancia() == vertice.getDistancia())
            return 0;

        return 1;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Vertice)
        {
            Vertice vRef = (Vertice) obj;

            if(this.getDescricao().equals(vRef.getDescricao()))
                return true;
        }

        return false;
    }

    @Override
    public String toString()
    {
        String s = " ";
        s+= this.getDescricao();
        return s;
    }

    protected Vertice pai;
    protected List <Aresta> arestas = new ArrayList<Aresta>();
    protected List <Vertice> verticesVizinhos = new ArrayList<Vertice>();
    protected boolean visitado;
    protected int distancia, quadrante;
    protected String descricao;
}
