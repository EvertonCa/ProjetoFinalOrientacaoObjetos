import java.util.ArrayList;
import java.util.List;

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
        ///cria a lista que armazena as arestas do Q1
        List <Aresta> buffer = new ArrayList<Aresta>();

        ///cria a aresta 0, de peso 10, com rotas para esquerda e direita, conectada ao vertice 0 e 1
        buffer.add(new Aresta(vertices.get(0), vertices.get(1), 10, 1));
        int[][] matriz;
        matriz = new int[][] {{0,9},{4,4}};
        buffer.get(0).setEsquerda(matriz);
        matriz = new int[][] {{0,9},{6,6}};
        buffer.get(0).setDireita(matriz);

        ///cria a aresta 1, de peso 20, com rotas para esquerda e direita, conectada ao vertice 1 e 2
        buffer.add(new Aresta(vertices.get(1), vertices.get(2), 20, 1));
        matriz = new int[][] {{15,34},{4,4}};
        buffer.get(1).setEsquerda(matriz);
        matriz = new int[][] {{15,34},{6,6}};
        buffer.get(1).setDireita(matriz);

        ///cria a aresta 2, de peso 15, com rotas para esquerda e direita, conectada ao vertice 2 e 3
        buffer.add(new Aresta(vertices.get(2), vertices.get(3), 15, 1));
        matriz = new int[][] {{40,54},{4,4}};
        buffer.get(2).setEsquerda(matriz);
        matriz = new int[][] {{40,54},{6,6}};
        buffer.get(2).setDireita(matriz);

        ///cria a aresta 3, de peso 10, com rotas para baixo e cima, conectada ao vertice 1 e 5
        buffer.add(new Aresta(vertices.get(1), vertices.get(5), 10, 1));
        matriz = new int[][] {{11,11},{8,17}};
        buffer.get(3).setBaixo(matriz);
        matriz = new int[][] {{13,13},{8,17}};
        buffer.get(3).setCima(matriz);

        ///cria a aresta 4, de peso 10, com rotas para baixo e cima, conectada ao vertice 2 e 7
        buffer.add(new Aresta(vertices.get(2), vertices.get(7), 10, 1));
        matriz = new int[][] {{36,36},{8,17}};
        buffer.get(4).setBaixo(matriz);
        matriz = new int[][] {{38,38},{8,17}};
        buffer.get(4).setCima(matriz);

        ///cria a aresta 5, de peso 10, com rotas para baixo e cima, conectada ao vertice 3 e 8
        buffer.add(new Aresta(vertices.get(3), vertices.get(8), 10, 1));
        matriz = new int[][] {{56,56},{8,17}};
        buffer.get(5).setBaixo(matriz);
        matriz = new int[][] {{58,58},{8,17}};
        buffer.get(5).setCima(matriz);

        ///cria a aresta 6, de peso 10, com rotas para esquerda e direita, conectada ao vertice 4 e 5
        buffer.add(new Aresta(vertices.get(4), vertices.get(5), 10, 1));
        matriz = new int[][] {{0,9},{19,19}};
        buffer.get(6).setEsquerda(matriz);
        matriz = new int[][] {{0,9},{21,21}};
        buffer.get(6).setDireita(matriz);

        ///cria a aresta 7, de peso 9, com rotas para esquerda e direita, conectada ao vertice 5 e 6
        buffer.add(new Aresta(vertices.get(5), vertices.get(6), 9, 1));
        matriz = new int[][] {{15,23},{19,19}};
        buffer.get(7).setEsquerda(matriz);
        matriz = new int[][] {{15,23},{21,21}};
        buffer.get(7).setDireita(matriz);

        ///cria a aresta 8, de peso 6, com rotas para esquerda e direita, conectada ao vertice 6 e 7
        buffer.add(new Aresta(vertices.get(6), vertices.get(7), 6, 1));
        matriz = new int[][] {{29,34},{19,19}};
        buffer.get(8).setEsquerda(matriz);
        matriz = new int[][] {{29,34},{21,21}};
        buffer.get(8).setDireita(matriz);

        ///cria a aresta 9, de peso 15, com rotas para esquerda e direita, conectada ao vertice 7 e 8
        buffer.add(new Aresta(vertices.get(7), vertices.get(8), 15, 1));
        matriz = new int[][] {{40,54},{19,19}};
        buffer.get(9).setEsquerda(matriz);
        matriz = new int[][] {{40,54},{21,21}};
        buffer.get(9).setDireita(matriz);

        ///cria a aresta 10, de peso 10, com rotas para baixo e cima, conectada ao vertice 6 e 10
        buffer.add(new Aresta(vertices.get(6), vertices.get(10), 10, 1));
        matriz = new int[][] {{25,25},{23,32}};
        buffer.get(10).setBaixo(matriz);
        matriz = new int[][] {{27,27},{23,32}};
        buffer.get(10).setCima(matriz);

        ///cria a aresta 11, de peso 10, com rotas para baixo e cima, conectada ao vertice 8 e 12
        buffer.add(new Aresta(vertices.get(8), vertices.get(12), 10, 1));
        matriz = new int[][] {{56,56},{23,32}};
        buffer.get(11).setBaixo(matriz);
        matriz = new int[][] {{58,58},{23,32}};
        buffer.get(11).setCima(matriz);

        ///cria a aresta 12, de peso 24, com rotas para esquerda e direita, conectada ao vertice 9 e 10
        buffer.add(new Aresta(vertices.get(9), vertices.get(10), 24, 1));
        matriz = new int[][] {{0,23},{34,34}};
        buffer.get(12).setEsquerda(matriz);
        matriz = new int[][] {{0,23},{36,36}};
        buffer.get(12).setDireita(matriz);

        ///cria a aresta 13, de peso 11, com rotas para esquerda e direita, conectada ao vertice 10 e 11
        buffer.add(new Aresta(vertices.get(10), vertices.get(11), 11, 1));
        matriz = new int[][] {{29,39},{34,34}};
        buffer.get(13).setEsquerda(matriz);
        matriz = new int[][] {{29,39},{36,36}};
        buffer.get(13).setDireita(matriz);

        ///cria a aresta 14, de peso 10, com rotas para esquerda e direita, conectada ao vertice 11 e 12
        buffer.add(new Aresta(vertices.get(11), vertices.get(12), 10, 1));
        matriz = new int[][] {{45,54},{34,34}};
        buffer.get(14).setEsquerda(matriz);
        matriz = new int[][] {{45,54},{36,36}};
        buffer.get(14).setDireita(matriz);

        ///cria a aresta 15, de peso 10, com rotas para baixo e cima, conectada ao vertice 10 e 14
        buffer.add(new Aresta(vertices.get(10), vertices.get(14), 10, 1));
        matriz = new int[][] {{25,25},{38,47}};
        buffer.get(15).setBaixo(matriz);
        matriz = new int[][] {{27,27},{38,47}};
        buffer.get(15).setCima(matriz);

        ///cria a aresta 16, de peso 10, com rotas para baixo e cima, conectada ao vertice 11 e 15
        buffer.add(new Aresta(vertices.get(11), vertices.get(15), 10, 1));
        matriz = new int[][] {{41,41},{38,47}};
        buffer.get(16).setBaixo(matriz);
        matriz = new int[][] {{43,43},{38,47}};
        buffer.get(16).setCima(matriz);

        ///cria a aresta 17, de peso 11, com rotas para esquerda e direita, conectada ao vertice 13 e 14
        buffer.add(new Aresta(vertices.get(13), vertices.get(14), 11, 1));
        matriz = new int[][] {{12,22},{49,49}};
        buffer.get(17).setEsquerda(matriz);
        matriz = new int[][] {{12,22},{51,51}};
        buffer.get(17).setDireita(matriz);

        ///cria a aresta 18, de peso 12, com rotas para esquerda e direita, conectada ao vertice 14 e 15
        buffer.add(new Aresta(vertices.get(14), vertices.get(15), 12, 1));
        matriz = new int[][] {{28,39},{49,49}};
        buffer.get(18).setEsquerda(matriz);
        matriz = new int[][] {{28,39},{51,51}};
        buffer.get(18).setDireita(matriz);

        ///cria a aresta 19, de peso 15, com rotas para esquerda e direita, conectada ao vertice 15 e 25
        buffer.add(new Aresta(vertices.get(15), vertices.get(25), 12, 1));
        matriz = new int[][] {{28,39},{49,49}};
        buffer.get(18).setEsquerda(matriz);
        matriz = new int[][] {{28,39},{51,51}};
        buffer.get(18).setDireita(matriz);

        ///cria a aresta 20, de peso 2, com rotas para baixo e cima, conectada ao vertice 13 e 17
        buffer.add(new Aresta(vertices.get(13), vertices.get(17), 2, 1));
        matriz = new int[][] {{8,8},{53,54}};
        buffer.get(20).setBaixo(matriz);
        matriz = new int[][] {{10,10},{53,54}};
        buffer.get(20).setCima(matriz);

        ///cria a aresta 21, de peso 7, com rotas para esquerda e direita, conectada ao vertice 16 e 17
        buffer.add(new Aresta(vertices.get(16), vertices.get(17), 7, 1));
        matriz = new int[][] {{0,6},{56,56}};
        buffer.get(21).setEsquerda(matriz);
        matriz = new int[][] {{0,6},{58,58}};
        buffer.get(21).setDireita(matriz);

        ///cria a aresta 22, de peso 7, com rotas para baixo e cima, conectada ao vertice 15 e 36
        buffer.add(new Aresta(vertices.get(15), vertices.get(36), 7, 1));
        matriz = new int[][] {{41,41},{53,59}};
        buffer.get(22).setBaixo(matriz);
        matriz = new int[][] {{43,43},{53,59}};
        buffer.get(22).setCima(matriz);

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
}
