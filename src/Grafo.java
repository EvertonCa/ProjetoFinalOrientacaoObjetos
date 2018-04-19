import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Grafo
{
    public Grafo()
    {
        ///cria 76 vertices padrão para os 18 vertices nulos (que saem da cidade) e 58 intersecções
        for(int i = 0; i < 76; i++)
        {
            vertices.add(new Vertice());
        }
        quadrante1();
    }

    public List<Vertice> getGrafo()
    {
        return grafo;
    }

    public void quadrante1()
    {
        try
        {
            ///cria a lista que armazena as arestas do Q1
            List <Aresta> buffer = new ArrayList<Aresta>();

            Manipulador manip = new Manipulador();
            Properties prop = manip.getArestasQ1();

            int quantidade = Integer.parseInt(prop.getProperty("quantidadeDeArestas"));

            int[][] matriz;

            for(int i = 0; i < quantidade; i++)
            {
                String direcao = prop.getProperty("aresta" + i + "Direcao");

                if(direcao.equals("vertical"))
                {
                    buffer.add(new Aresta(vertices.get(Integer.parseInt(prop.getProperty("aresta" + i + "VerticeInicial"))),
                            vertices.get(Integer.parseInt(prop.getProperty("aresta" + i + "VerticeFinal"))),
                            Integer.parseInt(prop.getProperty("aresta" + i + "Peso")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "Quadrante"))));
                    matriz = new int[][] {{Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX1")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX1"))},
                            {Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY1")),
                                    Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY1"))}};
                    buffer.get(i).setBaixo(matriz);
                    matriz = new int[][] {{Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX2")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX2"))},
                            {Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY2")),
                                    Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY2"))}};
                    buffer.get(i).setCima(matriz);
                }
                else
                {
                    buffer.add(new Aresta(vertices.get(Integer.parseInt(prop.getProperty("aresta" + i + "VerticeInicial"))),
                            vertices.get(Integer.parseInt(prop.getProperty("aresta" + i + "VerticeFinal"))),
                            Integer.parseInt(prop.getProperty("aresta" + i + "Peso")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "Quadrante"))));
                    matriz = new int[][] {{Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX1")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX1"))},
                            {Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY1")),
                                    Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY1"))}};
                    buffer.get(i).setEsquerda(matriz);
                    matriz = new int[][] {{Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX2")),
                            Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX2"))},
                            {Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY2")),
                                    Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY2"))}};
                    buffer.get(i).setDireita(matriz);
                }
            }

            this.grafo.addAll(vertices);
        }catch (IOException e){System.out.println("Erro no arquivo de propriedades Quadrante 1");}
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
    protected List <Vertice> vertices = new ArrayList<Vertice>();
}
