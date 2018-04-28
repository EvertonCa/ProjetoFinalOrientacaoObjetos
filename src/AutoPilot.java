import java.util.ArrayList;
import java.util.List;

public class AutoPilot extends Veiculos
{
    ///construtor com rota especifica
    public AutoPilot(List <Vertice> menorRota, List <Aresta> origemDestino, String aleatorio)
    {
        if(aleatorio.equals("aleatorio"))
            setIDParaRandom();
        rotaAleatoria = false;
        this.menorRota = menorRota;
        arestaOrigem = origemDestino.get(0);
        arestaDestino = origemDestino.get(1);
        setQuadranteAtual(arestaOrigem.getQuadrante());
        posicionaNaAresta();
        defineCoordenadasDestino();
    }

    public void posicionaNaAresta()
    {
        arestaAtual = arestaOrigem;
        super.setQuadranteAtual(arestaOrigem.getQuadrante());

        centraliza(arestaOrigem);

        super.setX(xCentral);
        super.setY(yCentral);
    }

    public void defineCoordenadasDestino()
    {
        super.setQuadranteDestino(arestaDestino.getQuadrante());

        centraliza(arestaDestino);

        super.xDestino = xCentral;
        super.yDestino = yCentral;
    }

    public void centraliza(Aresta aresta)
    {
        int coordenadas[][] = aresta.getCoordenadas();
        String sentido = aresta.getDirecao();
        if(sentido.equals("esquerda"))
        {
            xCentral = coordenadas[0][1] + (aresta.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(sentido.equals("direita"))
        {
            xCentral = coordenadas[0][0] + (aresta.getPeso() / 2 );
            yCentral = coordenadas[1][0];
        }
        else if(sentido.equals("cima"))
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][1] + (aresta.getPeso() / 2 );
        }
        else
        {
            xCentral = coordenadas[0][1];
            yCentral = coordenadas[1][0] + (aresta.getPeso() / 2 );
        }
    }

    public void move()
    {
        String direcao = arestaAtual.getDirecao();
        Mundo matrizMundo = new Mundo();
        int quadrante = super.getQuadranteAtual();
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
                if(mundo[super.getY()][super.getX()] < 10 && super.getX() == 0)
                {
                    cruzandoQuadrante = true;
                    naEsquinaRota();
                }
                else if(mundo[super.getY()][super.getX()] >= 10 && super.getX() == 0)
                {
                    cruzandoQuadrante = true;
                    moveNoVertice();
                }
                else if(mundo[super.getY()][super.getX() - 1] == 6)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getX()-1);
                }
                else
                {
                    naEsquinaRota();
                }
            }
            else if(direcao.equals("direita"))
            {
                if(mundo[super.getY()][super.getX()] < 10 && super.getX() == 59)
                {
                    cruzandoQuadrante = true;
                    naEsquinaRota();
                }
                else if(mundo[super.getY()][super.getX()] >= 10 && super.getX() == 59)
                {
                    cruzandoQuadrante = true;
                    moveNoVertice();
                }
                else if(mundo[super.getY()][super.getX() + 1] == 5)
                {
                    proxArestaDefinida = false;
                    super.setX(super.getX() + 1);

                }
                else
                {
                    naEsquinaRota();
                }
            }
            else if(direcao.equals("cima"))
            {
                if(mundo[super.getY()][super.getX()] < 10 && super.getY() == 0)
                {
                    cruzandoQuadrante = true;
                    naEsquinaRota();
                }
                else if(mundo[super.getY()][super.getX()] >= 10 && super.getY() == 0)
                {
                    cruzandoQuadrante = true;
                    moveNoVertice();
                }
                else if(mundo[super.getY() - 1][super.getX()] == 7)
                {
                    proxArestaDefinida = false;
                    super.setY(super.getY() - 1);
                }
                else
                {
                    naEsquinaRota();
                }
            }
            else
            {
                if(mundo[super.getY()][super.getX()] < 10 && super.getY() == 59)
                {
                    cruzandoQuadrante = true;
                    naEsquinaRota();
                }
                else if(mundo[super.getY()][super.getX()] >= 10 && super.getY() == 59)
                {
                    cruzandoQuadrante = true;
                    moveNoVertice();
                }
                else if(mundo[super.getY() + 1][super.getX()] == 8)
                {
                    proxArestaDefinida = false;
                    super.setY(super.getY() + 1);
                }
                else
                {
                    naEsquinaRota();
                }
            }

            if(super.getX() == super.getxDestino() && super.getY() == super.getyDestino())
            {
                cheguei = true;
            }
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
            if(cruzandoQuadrante)
            {
                super.setX(0);
                cruzandoQuadrante = false;
                setQuadranteAtual(arestaProxima.getQuadrante());
            }
            else
            {
                if(super.getX() == 59)
                {
                    super.setX(0);

                }
                else
                {
                    super.setX(super.getX() + 1);
                }

            }

        }
        else if(rotaNosCruzamentos.get(0).equals("esquerda"))
        {
            rotaNosCruzamentos.remove(0);
            if(cruzandoQuadrante)
            {
                super.setX(59);
                cruzandoQuadrante = false;
                setQuadranteAtual(arestaProxima.getQuadrante());
            }
            else
            {
                if(super.getX() == 0)
                {
                    super.setX(59);

                }
                else
                    super.setX(super.getX() - 1);
            }
        }

        else if(rotaNosCruzamentos.get(0).equals("cima"))
        {
            rotaNosCruzamentos.remove(0);
            if(cruzandoQuadrante)
            {
                super.setY(59);
                cruzandoQuadrante = false;
                setQuadranteAtual(arestaProxima.getQuadrante());
            }
            else
            {
                if(super.getY() == 0)
                {
                    super.setY(59);

                }
                else
                    super.setY(super.getY() - 1);
            }

        }
        else
        {
            rotaNosCruzamentos.remove(0);
            if(cruzandoQuadrante)
            {
                super.setY(0);
                cruzandoQuadrante = false;
                setQuadranteAtual(arestaProxima.getQuadrante());
            }
            else
            {
                if(super.getY() == 59)
                {
                    super.setY(0);

                }
                else
                    super.setY(super.getY() + 1);
            }
        }
    }

    public boolean getCheguei() {
        return cheguei;
    }

    public Aresta getArestaAtual() {
        return arestaAtual;
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
    protected boolean cruzandoQuadrante = false;
    protected int xCentral, yCentral;
}