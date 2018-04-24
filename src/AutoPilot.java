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

    public void move(boolean random)
    {
        String direcao = arestaAtual.getDirecao();

        if(!cheguei)
        {
            if(direcao.equals("esquerda"))
            {
                if(super.getX() - 1 == 6)
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
                if(super.getX() + 1 == 5)
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
                if(super.getY() - 1 == 7)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getY() - 1);
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
                if(super.getY() + 1 == 8)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getY() + 1);
                }
                else
                {
                    if(random)
                        naEsquinaRandom();
                    else
                        naEsquinaRota();
                }
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
                if(buffer.size() < 1)
                {
                    if(buffer.get(i).getDestino() == menorRota.get(1))
                    {
                        arestaProxima = buffer.get(i);
                        break;
                    }
                }
                else
                {
                    if(buffer.get(i) == arestaDestino)
                    {
                        arestaProxima = arestaDestino;
                        cheguei = true;
                    }
                }
            }
            menorRota.remove(0);
            proxArestaDefinida = true;
            arestaAtual = arestaProxima;
            rotaParaProximaAresta();
        }
        else
        {
            moveNoVertice();
        }
    }

    public void rotaParaProximaAresta()
    {
        rotaNosCruzamentos.clear();
        if(arestaAtual.getDestino().equals("direita"))
        {
            if(arestaProxima.getDestino().equals("direita"))
            {
                for(int i = 0; i < 5; i++)
                {
                    rotaNosCruzamentos.add("direita");
                }
            }

            else if(arestaProxima.getDestino().equals("cima"))
            {
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
            }
            else if(arestaProxima.getDestino().equals("baixo"))
            {
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("baixo");
            }
        }
        else if(arestaAtual.getDestino().equals("esquerda"))
        {
            if(arestaProxima.getDestino().equals("esquerda"))
            {
                for(int i = 0; i < 5; i++)
                {
                    rotaNosCruzamentos.add("esquerda");
                }
            }
            else if(arestaProxima.getDestino().equals("cima"))
            {
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("cima");
            }
            else if(arestaProxima.getDestino().equals("baixo"))
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
        else if(arestaAtual.getDestino().equals("cima"))
        {
            if(arestaProxima.getDestino().equals("direita"))
            {
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("direita");
            }
            else if(arestaProxima.getDestino().equals("esquerda"))
            {
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("cima");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
                rotaNosCruzamentos.add("esquerda");
            }
            else if(arestaProxima.getDestino().equals("cima"))
            {
                for(int i = 0; i < 5; i++)
                {
                    rotaNosCruzamentos.add("cima");
                }
            }
        }
        else
        {
            if(arestaProxima.getDestino().equals("direita"))
            {
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");
                rotaNosCruzamentos.add("direita");

            }
            else if(arestaProxima.getDestino().equals("esquerda"))
            {
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("baixo");
                rotaNosCruzamentos.add("esquerda");
            }
            else if(arestaProxima.getDestino().equals("baixo"))
            {
                for(int i = 0; i < 5; i++)
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
            super.setX(super.getY() - 1);
        }
        else
        {
            rotaNosCruzamentos.remove(0);
            super.setX(super.getY() + 1);
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
    protected boolean rotaAleatoria, proxArestaDefinida = false, cheguei = false;
}
