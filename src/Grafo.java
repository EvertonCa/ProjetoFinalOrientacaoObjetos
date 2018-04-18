import java.util.ArrayList;
import java.util.List;

public class Grafo
{
    public Grafo()
    {
        quadrante1();
    }

    public List<Vertice> getGrafo()
    {
        return grafo;
    }

    public void quadrante1()
    {
        ///cria a lista que armazena os vertices do Q1
        List <Vertice> verticesQ1 = new ArrayList<Vertice>();

        ///cria 17 vertices padrão para os 17 cruzamentos
        for(int i = 0; i < 17; i++)
        {
            verticesQ1.add(new Vertice());
        }

        ///cria a lista que armazena as arestas do Q1
        List <Aresta> buffer = new ArrayList<Aresta>();

        buffer.add(new Aresta(verticesQ1.get(0), verticesQ1.get(1), 10, 1));

        this.grafo.addAll(verticesQ1);
    }

    // Método que retorna o vértice cuja descrição é igual à procurada.
    public Vertice encontrarVertice(String nome) {

        for (int i = 0; i < grafo.size(); i++)
        {
            if (nome.equalsIgnoreCase(grafo.get(i).getDescricao()))
                return grafo.get(i);
        }

        return null;

    }

    protected List <Vertice> grafo = new ArrayList<Vertice>();
}
