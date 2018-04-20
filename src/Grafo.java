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

        criaArestas(1);
        criaArestas(2);
        criaArestas(3);
        criaArestas(4);
        criaVertices(1);
        criaVertices(2);
        criaVertices(3);
        criaVertices(4);

        criaGrafo();
    }

    public List<Vertice> getGrafo()
    {
        return grafo;
    }

    public void criaArestas(int quadrante)
    {
        try
        {
            Manipulador manip = new Manipulador();
            Properties prop;
            List <Aresta> arestas = new ArrayList<Aresta>();

            switch (quadrante)
            {
                default:
                {
                    prop = manip.getArestasQ1();
                    arestasQ1 = arestas;
                    break;
                }

                case 2:
                {
                    prop = manip.getArestasQ2();
                    arestasQ2 = arestas;
                    break;
                }

                case 3:
                {
                    prop = manip.getArestasQ3();
                    arestasQ3 = arestas;
                    break;
                }

                case 4:
                {
                    prop = manip.getArestasQ4();
                    arestasQ4 = arestas;
                    break;
                }

            }


            int quantidadeDeArestas = Integer.parseInt(prop.getProperty("quantidadeDeArestas"));

            int[][] matriz;

            for(int i = 0; i < quantidadeDeArestas; i++)
            {
                String direcao = prop.getProperty("aresta" + i + "Direcao");
                int verticeInicial = Integer.parseInt(prop.getProperty("aresta" + i + "VerticeInicial"));
                int verticeFinal = Integer.parseInt(prop.getProperty("aresta" + i + "VerticeFinal"));
                int peso = Integer.parseInt(prop.getProperty("aresta" + i + "Peso"));
                int quadranteArestaNova = Integer.parseInt(prop.getProperty("aresta" + i + "Quadrante"));
                int x1Inicial = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX1"));
                int x1Final = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX1"));
                int x2Inicial = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialX2"));
                int x2Final = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalX2"));
                int y1Inicial = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY1"));
                int y1Final = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY1"));
                int y2Inicial = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaInicialY2"));
                int y2Final = Integer.parseInt(prop.getProperty("aresta" + i + "CoordenadaFinalY2"));

                if(direcao.equals("vertical"))
                {
                    arestas.add(new Aresta(vertices.get(verticeInicial), vertices.get(verticeFinal),peso,quadranteArestaNova));
                    matriz = new int[][] {{x1Inicial, x1Final}, {y1Inicial, y1Final}};
                    arestas.get(i).setBaixo(matriz);
                    matriz = new int[][] {{x2Inicial, x2Final},{y2Inicial, y2Final}};
                    arestas.get(i).setCima(matriz);
                }
                else
                {
                    arestas.add(new Aresta(vertices.get(verticeInicial), vertices.get(verticeFinal),peso,quadranteArestaNova));
                    matriz = new int[][] {{x1Inicial, x1Final},{y1Inicial, y1Final}};
                    arestas.get(i).setEsquerda(matriz);
                    matriz = new int[][] {{x2Inicial, x2Final},{y2Inicial, y2Final}};
                    arestas.get(i).setDireita(matriz);
                }
            }

        }catch (IOException e){System.out.println("Erro no arquivo de propriedades Quadrante " + quadrante);}
    }

    public void criaVertices(int quadrante)
    {
        try
        {
            Manipulador manip = new Manipulador();

            Properties prop2;

            switch (quadrante)
            {
                default:
                {
                    prop2 = manip.getVerticesQ1();
                    break;
                }

                case 2:
                {
                    prop2 = manip.getVerticesQ2();
                    break;
                }

                case 3:
                {
                    prop2 = manip.getVerticesQ3();
                    break;
                }

                case 4:
                {
                    prop2 = manip.getVerticesQ4();
                    break;
                }

            }

            int quantidadeDeVertices = Integer.parseInt(prop2.getProperty("quantidadeDeVertices"));

            for(int i=0; i < quantidadeDeVertices; i++)
            {
                vertices.get(i).setDescricao(prop2.getProperty("vertice" + i + "Descricao"));

                List <Vertice > verticesVizinhos = new ArrayList<Vertice>();

                for(int j = 0; j < (Integer.parseInt(prop2.getProperty("vertice" + i + "QuantidadeDeVerticesVizinhos"))); j++)
                {
                    verticesVizinhos.add(vertices.get(Integer.parseInt(prop2.getProperty("vertice" + i + "VerticeVizinho" + j))));
                }
                vertices.get(i).setVerticesVizinhos(verticesVizinhos);

                List <Aresta > arestasVizinhas = new ArrayList<Aresta>();

                for(int j = 0; j < (Integer.parseInt(prop2.getProperty("vertice" + i + "QuantidadeDeArestasVizinhas"))); j++)
                {
                    int quadranteDaAresta = Integer.parseInt(prop2.getProperty("vertice" + i + "QuadranteArestaVizinha" + j));

                    switch (quadranteDaAresta)
                    {
                        default:
                        {
                            arestasVizinhas.add(arestasQ1.get(Integer.parseInt(prop2.getProperty("vertice" + i + "ArestaVizinha" + j))));
                            break;
                        }

                        case 2:
                        {
                            arestasVizinhas.add(arestasQ2.get(Integer.parseInt(prop2.getProperty("vertice" + i + "ArestaVizinha" + j))));
                            break;
                        }

                        case 3:
                        {
                            arestasVizinhas.add(arestasQ3.get(Integer.parseInt(prop2.getProperty("vertice" + i + "ArestaVizinha" + j))));
                            break;
                        }

                        case 4:
                        {
                            arestasVizinhas.add(arestasQ4.get(Integer.parseInt(prop2.getProperty("vertice" + i + "ArestaVizinha" + j))));
                            break;
                        }
                    }
                }
                vertices.get(i).setArestas(arestasVizinhas);
            }

        }catch (IOException e){System.out.println("Erro no arquivo de propriedades Quadrante " + quadrante);}
    }

    public void criaGrafo()
    {
        this.grafo.addAll(vertices);
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
    protected List <Aresta> arestasQ1 = new ArrayList<Aresta>();
    protected List <Aresta> arestasQ2 = new ArrayList<Aresta>();
    protected List <Aresta> arestasQ3 = new ArrayList<Aresta>();
    protected List <Aresta> arestasQ4 = new ArrayList<Aresta>();

}
