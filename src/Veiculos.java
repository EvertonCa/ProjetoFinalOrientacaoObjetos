public class Veiculos
{
    public Veiculos(int quadranteAtual ,int xAtual, int yAtual, int quadranteDestino, int xDestino, int yDestino)
    {
        Aleatorio random = new Aleatorio();
        this.xAtual = xAtual;
        this.xDestino = xDestino;
        this.yAtual = yAtual;
        this.yDestino = yDestino;
        this.quadranteAtual = quadranteAtual;
        this.quadranteDestino = quadranteDestino;
        ID = random.randomizeID();
    }

    public void move()
    {
        Mundo mundoComparador = new Mundo();

        if(mundoComparador.getLocalizacao(quadranteAtual, xAtual, yAtual) == 5 && xAtual + 1 == 5)
        {
            xAtual++;
        }

        else if(mundoComparador.getLocalizacao(quadranteAtual, xAtual, yAtual) == 6 && xAtual - 1 == 6)
        {
            xAtual--;
        }

        if(mundoComparador.getLocalizacao(quadranteAtual, xAtual, yAtual) == 7 && yAtual - 1 == 7)
        {
            yAtual--;
        }

        else if(mundoComparador.getLocalizacao(quadranteAtual, xAtual, yAtual) == 8 && yAtual + 1 == 8)
        {
            yAtual++;
        }
    }

    public int getxAtual()
    {
        return xAtual;
    }

    public int getyAtual()
    {
        return yAtual;
    }

    public int getxDestino()
    {
        return xDestino;
    }

    public int getyDestino()
    {
        return yDestino;
    }

    public int getID()
    {
        return ID;
    }

    protected int xAtual, yAtual, xDestino, yDestino, quadranteAtual, quadranteDestino, ID;
}
