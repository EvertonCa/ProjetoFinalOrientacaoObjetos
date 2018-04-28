import java.io.IOException;
import java.util.*;

public class GPS
{
    public GPS(String aleatorio)
    {
        Grafo grafo = new Grafo();
        this.grafo = grafo;
        Grafo grafo1 = new Grafo();
        this.grafo1 = grafo1;
        Grafo grafo2 = new Grafo();
        this.grafo2 = grafo2;
        Grafo grafo3 = new Grafo();
        this.grafo3 = grafo3;
        Grafo grafo4 = new Grafo();
        this.grafo4 = grafo4;

        if(aleatorio.equals("aleatorio"))
            obterRuasAleatorias();
        else
            obterRuasUsuario();
        obterRota();

    }

    public void obterRuasUsuario()
    {
        Scanner teclado = new Scanner(System.in);
        boolean origemExiste = false, destinoExiste = false;

        while (!origemExiste)
        {
            System.out.printf("Entre com a origem: ");
            ruaOrigem = teclado.nextLine();

            origem = ruaExiste("origem");

            if(origem.equals("naoEncontrado"))
            {
                System.out.printf("Rua não encontrada! tente novamente!\n");
            }

            else
            {
                encontraArestas(origem, "origem");
                encontraVertices("origem");
                origemExiste = true;
            }
        }

        while (!destinoExiste)
        {
            System.out.printf("Entre com a destino: ");
            ruaDestino = teclado.nextLine();

            destino = ruaExiste("destino");

            if(destino.equals("naoEncontrado"))
            {
                System.out.printf("Rua não encontrada! tente novamente!\n");
            }

            else
            {
                encontraArestas(destino, "destino");
                encontraVertices("destino");
                destinoExiste = true;
            }
        }
    }

    public void obterRuasAleatorias()
    {
        Aleatorio random = new Aleatorio();

        ruaOrigem = random.randomizaRua();
        ruaDestino = random.randomizaRuaComExcecao(ruaOrigem);

        origem = ruaExiste("origem");
        encontraArestas(origem, "origem");
        encontraVertices("origem");

        destino = ruaExiste("destino");
        encontraArestas(destino, "destino");
        encontraVertices("destino");
    }

    public String ruaExiste(String origemOuDestino) {
        try {
            Manipulador manip = new Manipulador();
            Properties propQ1 = manip.getRuasQ1();
            Properties propQ2 = manip.getRuasQ2();
            Properties propQ3 = manip.getRuasQ3();
            Properties propQ4 = manip.getRuasQ4();

            String tudoJunto, resposta;

            if (origemOuDestino.equals("origem")) {

                String separados[] = ruaOrigem.split(" ");
                tudoJunto = separados[0] + separados[1];
            } else {
                String separados[] = ruaDestino.split(" ");
                tudoJunto = separados[0] + separados[1];
            }

            String arestas = propQ1.getProperty(tudoJunto);
            quadrante = 1;

            if(arestas == null)
            {
                arestas = propQ2.getProperty(tudoJunto);
                quadrante = 2;

                if(arestas == null)
                {
                    arestas = propQ3.getProperty(tudoJunto);
                    quadrante = 3;

                    if(arestas == null)
                    {
                        arestas = propQ4.getProperty(tudoJunto);
                        quadrante = 4;
                    }
                }
            }

            if(arestas == null)
            {
                resposta = "naoEncontrado";
            }
            else
            {
                resposta = arestas;
            }
            return resposta;
        } catch (IOException e){return null;}
    }

    public void encontraArestas(String arestas, String origemOuDestino)
    {
        String separados[] = arestas.split("e");
        int primeiraAresta = Integer.parseInt(separados[0]);
        int segundaAresta = Integer.parseInt(separados[1]);
        if(origemOuDestino.equals("origem"))
        {
            switch (quadrante)
            {
                default:
                {
                    populaArestasOrigem(grafo.getArestasQ1(primeiraAresta));
                    populaArestasOrigem(grafo.getArestasQ1(segundaAresta));
                    break;
                }

                case 2:
                {
                    populaArestasOrigem(grafo.getArestasQ2(primeiraAresta));
                    populaArestasOrigem(grafo.getArestasQ2(segundaAresta));
                    break;
                }

                case 3:
                {
                    populaArestasOrigem(grafo.getArestasQ3(primeiraAresta));
                    populaArestasOrigem(grafo.getArestasQ3(segundaAresta));
                    break;
                }

                case 4:
                {
                    populaArestasOrigem(grafo.getArestasQ4(primeiraAresta));
                    populaArestasOrigem(grafo.getArestasQ4(segundaAresta));
                    break;
                }
            }
        }
        else
        {
            switch (quadrante)
            {
                default:
                {
                    populaArestasDestino(grafo.getArestasQ1(primeiraAresta));
                    populaArestasDestino(grafo.getArestasQ1(segundaAresta));
                    break;
                }

                case 2:
                {
                    populaArestasDestino(grafo.getArestasQ2(primeiraAresta));
                    populaArestasDestino(grafo.getArestasQ2(segundaAresta));
                    break;
                }

                case 3:
                {
                    populaArestasDestino(grafo.getArestasQ3(primeiraAresta));
                    populaArestasDestino(grafo.getArestasQ3(segundaAresta));
                    break;
                }

                case 4:
                {
                    populaArestasDestino(grafo.getArestasQ4(primeiraAresta));
                    populaArestasDestino(grafo.getArestasQ4(segundaAresta));
                    break;
                }
            }
        }
    }

    public void encontraVertices(String origemOuDestino)
    {
        if(origemOuDestino.equals("origem"))
        {
            verticesOrigem.add(arestasOrigem.get(0).getDestino());
            verticesOrigem.add(arestasOrigem.get(1).getDestino());

        }
        else
        {
            verticesDestino.add(arestasDestino.get(0).getOrigem());
            verticesDestino.add(arestasDestino.get(1).getOrigem());
        }
    }

    public void populaArestasOrigem(Aresta aresta)
    {
        arestasOrigem.add(aresta);
    }

    public void populaArestasDestino(Aresta aresta)
    {
        arestasDestino.add(aresta);
    }

    public void obterRota()
    {
        Dijkstra dijkstra1 = new Dijkstra();
        Dijkstra dijkstra2 = new Dijkstra();
        Dijkstra dijkstra3 = new Dijkstra();
        Dijkstra dijkstra4 = new Dijkstra();

        menorRota1 = dijkstra1.encontrarMenorCaminhoDijkstra(grafo1,
                grafo1.encontrarVertice(verticesOrigem.get(0).getDescricao()),
                grafo1.encontrarVertice(verticesDestino.get(0).getDescricao()));
        menorRota2 = dijkstra2.encontrarMenorCaminhoDijkstra(grafo2,
                grafo2.encontrarVertice(verticesOrigem.get(0).getDescricao()),
                grafo2.encontrarVertice(verticesDestino.get(1).getDescricao()));
        menorRota3 = dijkstra3.encontrarMenorCaminhoDijkstra(grafo3,
                grafo3.encontrarVertice(verticesOrigem.get(1).getDescricao()),
                grafo3.encontrarVertice(verticesDestino.get(0).getDescricao()));
        menorRota4 = dijkstra4.encontrarMenorCaminhoDijkstra(grafo4,
                grafo4.encontrarVertice(verticesOrigem.get(1).getDescricao()),
                grafo4.encontrarVertice(verticesDestino.get(1).getDescricao()));

        int tamanho1 = menorRota1.size(), tamanho2 = menorRota2.size(), tamanho3 = menorRota3.size(), tamanho4 = menorRota4.size();

        List <Integer> rotas = new ArrayList<>();
        rotas.add(tamanho1);
        rotas.add(tamanho2);
        rotas.add(tamanho3);
        rotas.add(tamanho4);

        Collections.sort(rotas);

        int menorTamanho = rotas.get(0);

        if(menorTamanho == tamanho1)
        {
            menorRota = menorRota1;
            arestasDefinitivas.add(arestasOrigem.get(0));
            arestasDefinitivas.add(arestasDestino.get(0));
        }
        else if(menorTamanho == tamanho2)
        {
            menorRota = menorRota2;
            arestasDefinitivas.add(arestasOrigem.get(0));
            arestasDefinitivas.add(arestasDestino.get(1));
        }
        else if(menorTamanho == tamanho3)
        {
            menorRota = menorRota3;
            arestasDefinitivas.add(arestasOrigem.get(1));
            arestasDefinitivas.add(arestasDestino.get(0));

        }
        else
        {
            menorRota = menorRota4;
            arestasDefinitivas.add(arestasOrigem.get(1));
            arestasDefinitivas.add(arestasDestino.get(1));
        }
    }

    public void exibirMenorRota()
    {
        System.out.printf("A menor rota para o destino é a seguinte:\n");
        System.out.print(menorRota.get(0));

        for(int i = 1; i < menorRota.size(); i++)
        {
            System.out.printf(" -> ");
            System.out.print(menorRota.get(i));
        }
        System.out.printf("\n");
    }

    public List<Vertice> getMenorRota() {
        return menorRota;
    }

    public List<Aresta> getArestasDefinitivas() {
        return arestasDefinitivas;
    }

    protected Grafo grafo, grafo1, grafo2, grafo3, grafo4;
    protected int quadrante;
    protected List <Vertice> menorRota1,menorRota2, menorRota3, menorRota4, menorRota;
    protected List <Aresta> arestasOrigem = new ArrayList<>();
    protected List <Aresta> arestasDestino = new ArrayList<>();
    protected List <Aresta> arestasDefinitivas = new ArrayList<>();
    protected List <Vertice> verticesOrigem = new ArrayList<>();
    protected List <Vertice> verticesDestino = new ArrayList<>();
    protected String origem, destino, ruaOrigem, ruaDestino;
}
