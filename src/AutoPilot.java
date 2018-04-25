import java.util.ArrayList;
import java.util.List;

public class AutoPilot extends Veiculos
{
    ///construtor com rota aleatoria
    public AutoPilot(Grafo grafo)
    {
        Aleatorio aleatorio = new Aleatorio();
        rotaAleatoria = true;
        arestaOrigem = aleatorio.randomizeArestaGrafo(grafo);
        posicionaNaAresta();
    }

    ///construtor com rota especifica
    public AutoPilot(List <Vertice> menorRota, List <Aresta> origemDestino)
    {
        rotaAleatoria = false;
        this.menorRota = menorRota;
        arestaOrigem = origemDestino.get(0);
        arestaDestino = origemDestino.get(1);
        posicionaNaAresta();
        defineCoordenadasDestino();
    }

    public void posicionaNaAresta()
    {
        arestaAtual = arestaOrigem;
        String direcao = arestaOrigem.getDirecao();
        super.setQuadranteAtual(arestaOrigem.getQuadrante());
        int coordenadas[][] = arestaOrigem.getCoordenadas();
        int xCentral, yCentral;

        if(direcao.equals("esquerda"))
        {
            xCentral = coordenadas[0][1] + (arestaOrigem.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(direcao.equals("direita"))
        {
            xCentral = coordenadas[0][0] + (arestaOrigem.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(direcao.equals("cima"))
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][1] + (arestaOrigem.getPeso() / 2 );
        }
        else
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][0] + (arestaOrigem.getPeso() / 2 );
        }

        super.setX(xCentral);
        super.setY(yCentral);
    }

    public void defineCoordenadasDestino()
    {
        String sentido = arestaDestino.getDirecao();
        super.setQuadranteDestino(arestaDestino.getQuadrante());
        int coordenadas[][] = arestaDestino.getCoordenadas();
        int xCentral, yCentral;

        if(sentido.equals("esquerda"))
        {
            xCentral = coordenadas[0][1] + (arestaDestino.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(sentido.equals("direita"))
        {
            xCentral = coordenadas[0][0] + (arestaDestino.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(sentido.equals("cima"))
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][1] + (arestaDestino.getPeso() / 2 );
        }
        else
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][0] + (arestaDestino.getPeso() / 2 );
        }
        super.xDestino = xCentral;
        super.yDestino = yCentral;
    }

    public void move(boolean random)
    {
        String direcao = arestaAtual.getDirecao();
        Mundo matrizMundo = new Mundo();
        int quadrante = arestaAtual.getQuadrante();
        int mundo[][];
        switch (quadrante)
        {
            default:
            {
                mundo = matrizMundo.getMundoQ1();
                break;
            }

            case 2:
            {
                mundo = matrizMundo.getMundoQ2();
                break;
            }

            case 3:
            {
                mundo = matrizMundo.getMundoQ3();
                break;
            }

            case 4:
            {
                mundo = matrizMundo.getMundoQ4();
                break;
            }
        }

        if(!cheguei)
        {
            if(direcao.equals("esquerda"))
            {
                if(mundo[super.getY()][super.getX() - 1] == 6)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getX()-1);
                }
                else
                {
                    if(random)
                        naEsquinaRandom();
                    else
                        naEsquinaRota();
                }
            }
            else if(direcao.equals("direita"))
            {
                if(mundo[super.getY()][super.getX() + 1] == 5)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getX() + 1);

                }
                else
                {
                    if(random)
                        naEsquinaRandom();
                    else
                        naEsquinaRota();
                }
            }
            else if(direcao.equals("cima"))
            {
                if(mundo[super.getY() - 1][super.getX()] == 7)
                {
                    proxArestaDefinida = false;
                    super.setY(super.getY() - 1);
                }
                else
                {
                    if(random)
                        naEsquinaRandom();
                    else
                        naEsquinaRota();
                }
            }
            else
            {
                if(mundo[super.getY() + 1][super.getX()] == 8)
                {
                    proxArestaDefinida = false;
                    super.setY(super.getY() + 1);
                }
                else
                {
                    if(random)
                        naEsquinaRandom();
                    else
                        naEsquinaRota();
                }
            }

            if(super.getX() == super.getxDestino() && super.getY() == super.getyDestino())
            {
                cheguei = true;
            }
        }
    }

    public void naEsquinaRandom()
    {
        if(!proxArestaDefinida)
        {
            defineArestaProxima();
            proxArestaDefinida = true;
            arestaAtual = arestaProxima;
            rotaParaProximaAresta();
        }
        else
        {
            moveNoVertice();
        }
    }

    public void naEsquinaRota()
    {
        if(!proxArestaDefinida)
        {
            List <Aresta> buffer = menorRota.get(0).getArestas();
            for(int i=0; i < buffer.size(); i++)
            {
                if(menorRota.size() > 1)
                {
                    Vertice comparador = menorRota.get(1);
                    if(buffer.get(i).getDestino().equals(comparador))
                    {
                        arestaProxima = buffer.get(i);
                        break;
                    }
                }
                else
                {
                    if(buffer.get(i).getDestino().equals(arestaDestino.getDestino()) &&
                            buffer.get(i).getOrigem().equals(arestaDestino.getOrigem()))
                    {
                        System.out.print(buffer.get(i).getDestino() + " <- | -> " + arestaDestino.getDestino());
                        arestaProxima = arestaDestino;
                        chegueiNaArestaDestino = true;
                        break;
                    }
                }
            }
            menorRota.remove(0);
            proxArestaDefinida = true;
            rotaParaProximaAresta();
            moveNoVertice();
            arestaAtual = arestaProxima;
        }
        else
        {
            System.out.printf("\nHeeey\n");
            moveNoVertice();
        }
    }

    public void rotaParaProximaAresta()
    {
        rotaNosCruzamentos.clear();
        if(arestaAtual.getDirecao().equals("direita"))
        {
            if(arestaProxima.getDirecao().equals("direita"))
            {
                for(int i = 0; i < 7; i++)
                {
                    rotaNosCruzamentos.add("direita");
                }
            }

            else if(arestaProxima.getDirecao().equals("cima"))
            {
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
            }
            else if(arestaProxima.getDirecao().equals("baixo"))
            {
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("baixo");
            }
        }
        else if(arestaAtual.getDirecao().equals("esquerda"))
        {
            if(arestaProxima.getDirecao().equals("esquerda"))
            {
                for(int i = 0; i < 7; i++)
                {
                    rotaNosCruzamentos.add("esquerda");
                }
            }
            else if(arestaProxima.getDirecao().equals("cima"))
            {
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("cima");
            }
            else if(arestaProxima.getDirecao().equals("baixo"))
            {
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
            }
        }
        else if(arestaAtual.getDirecao().equals("cima"))
        {
            if(arestaProxima.getDirecao().equals("direita"))
            {
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("direita");
            }
            else if(arestaProxima.getDirecao().equals("esquerda"))
            {
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
            }
            else if(arestaProxima.getDirecao().equals("cima"))
            {
                for(int i = 0; i < 7; i++)
                {
                    rotaNosCruzamentos.add("cima");
                }
            }
        }
        else
        {
            if(arestaProxima.getDirecao().equals("direita"))
            {
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");

            }
            else if(arestaProxima.getDirecao().equals("esquerda"))
            {
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("esquerda");
            }
            else if(arestaProxima.getDirecao().equals("baixo"))
            {
                for(int i = 0; i < 7; i++)
                {
                    rotaNosCruzamentos.add("baixo");
                }
            }
        }
    }

    public void defineArestaProxima()
    {
        Aleatorio aleatorio = new Aleatorio();
        arestaProxima = aleatorio.randomizeArestaVertice(arestaAtual.getDestino());
    }

    public void moveNoVertice()
    {
        if(rotaNosCruzamentos.get(0).equals("direita"))
        {
            rotaNosCruzamentos.remove(0);
            super.setX(super.getX() + 1);
        }
        else if(rotaNosCruzamentos.get(0).equals("esquerda"))
        {
            rotaNosCruzamentos.remove(0);
            super.setX(super.getX() - 1);
        }

        else if(rotaNosCruzamentos.get(0).equals("cima"))
        {
            rotaNosCruzamentos.remove(0);
            super.setY(super.getY() - 1);
        }
        else
        {
            rotaNosCruzamentos.remove(0);
            super.setY(super.getY() + 1);
        }
    }

    public boolean getCheguei() {
        return cheguei;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getxDestino() {
        return super.getxDestino();
    }

    @Override
    public int getyDestino() {
        return super.getyDestino();
    }

    protected Aresta arestaOrigem, arestaDestino, arestaAtual, arestaProxima;
    protected List <Vertice> menorRota;
    protected List <String> rotaNosCruzamentos = new ArrayList<>();
    protected boolean rotaAleatoria, proxArestaDefinida = false, cheguei = false, chegueiNaArestaDestino = false;
}
