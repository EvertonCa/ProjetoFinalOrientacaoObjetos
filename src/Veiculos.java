/**
 / Classe pai veiculos que é extendida em AutoPilot e armazena coordenadas do veiculo
 **/

public class Veiculos
{
    /// Construtor padrão
    public Veiculos()
    {
        Aleatorio random = new Aleatorio();
        ID = random.randomizeID();
    }

    public int getxDestino()
    {
        return xDestino;
    }

    public int getyDestino()
    {
        return yDestino;
    }

    /// Cria uma ID aleatória para veiculos aleatórios
    public void setIDParaRandom()
    {
        Aleatorio random = new Aleatorio();
        ID = random.randomizeIDParaAleatorios();
    }

    public int getID()
    {
        return ID;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setQuadranteAtual(int quadranteAtual) {
        this.quadranteAtual = quadranteAtual;
    }

    public void setQuadranteDestino(int quadranteDestino) {
        this.quadranteDestino = quadranteDestino;
    }

    public int getQuadranteAtual() {
        return quadranteAtual;
    }

    public int getQuadranteDestino() {
        return quadranteDestino;
    }

    protected int x, y, xDestino, yDestino, quadranteAtual, quadranteDestino, ID;
}
