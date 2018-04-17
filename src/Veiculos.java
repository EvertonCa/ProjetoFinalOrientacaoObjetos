public class Veiculos
{
    public Veiculos(int xAtual, int yAtual, int xDestino, int yDestino)
    {
        Aleatorio random = new Aleatorio();
        this.xAtual = xAtual;
        this.xDestino = xDestino;
        this.yAtual = yAtual;
        this.yDestino = yDestino;
        ID = random.randomizeID();
    }

    protected int xAtual, yAtual, xDestino, yDestino, ID;
}
