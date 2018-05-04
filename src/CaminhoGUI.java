public class CaminhoGUI {
    public CaminhoGUI(String direcao, int tamanho, int xInicial, int yInicial)
    {
        this.direcao = direcao;
        this.tamanho = tamanho;
        this.xAtual = xInicial*6.5; //outro local para mudar a proporção é no animador de Controller
        this.yAtual = yInicial*6.5;
        if(direcao.equals("direita"))
        {
            xDestino = xAtual + (tamanho * 6.5);
            angulo = 0.0;
        }
        else if(direcao.equals("esquerda"))
        {
            xDestino = xAtual - (tamanho * 6.5);
            angulo = 180.0;
        }
        else if(direcao.equals("cima"))
        {
            yDestino = yAtual - (tamanho * 6.5);
            angulo = 270.0;
        }
        else
        {
            yDestino = yAtual + (tamanho * 6.5);
            angulo = 90.0;
        }
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public String getDirecao() {
        return direcao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public double getxAtual() {
        return xAtual;
    }

    public void setxAtual(double xAtual) {
        this.xAtual = xAtual;
    }

    public double getyAtual() {
        return yAtual;
    }

    public void setyAtual(double yAtual) {
        this.yAtual = yAtual;
    }

    public double getxDestino() {
        return xDestino;
    }

    public void setxDestino(double xDestino) {
        this.xDestino = xDestino;
    }

    public double getyDestino() {
        return yDestino;
    }

    public void setyDestino(double yDestino) {
        this.yDestino = yDestino;
    }

    private String direcao;
    private int tamanho;
    private double xAtual, yAtual, xDestino, yDestino, angulo;
}
