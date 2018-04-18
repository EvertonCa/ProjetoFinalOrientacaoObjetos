import java.util.ArrayList;
import java.util.List;

public class Grafo
{
    public Grafo()
    {

    }

    public List<Vertice> getGrafo()
    {
        return grafo;
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
