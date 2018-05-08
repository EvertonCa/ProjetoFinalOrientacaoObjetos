import javafx.scene.image.ImageView;

import java.util.List;

public class AreaPrincipalHandle {

    public AreaPrincipalHandle(String ruaDeOrigem, String ruaDeDestino)
    {
        this.ruaDeOrigem = ruaDeOrigem;
        this.ruaDeDestino = ruaDeDestino;
        gps = new GPS();

        respostaGPSOrigem = gps.ruaExiste(ruaDeOrigem);
        respostaGPSDestino = gps.ruaExiste(ruaDeDestino);

        if (!respostaGPSOrigem.equals("Formato Errado!") && !respostaGPSDestino.equals("Formato Errado!"))
        {
            System.out.println("Arestas da rua de Origem: " + respostaGPSOrigem + "\nArestas da rua de Destino: " + respostaGPSDestino);
            System.out.println("Quadrante da rua de Origem: " + gps.quadranteOrigem + "\nQuadrante da rua de Destino: " + gps.quadranteDestino);

            gps.obterRuasUsuario(respostaGPSOrigem, respostaGPSDestino);
            gps.obterRota();

            gps.exibirMenorRota();

            tesla = new AutoPilot(gps.getMenorRota(), gps.getArestasDefinitivas(), "definido");

            quadranteInicial = tesla.getQuadranteAtual();

            tesla.gerarCoordenadasGUI();
            caminhosGUI = tesla.gerarRotasGUI();
            tesla.exibeRotasGUI();
            tesla.posicionaNaAresta();
            defineCoordenadaInicial();

            xAtual = xInicial * 6.5 - 6; //outro local para mudar a proporção é no construtor de CaminhosGUI
            yAtual = yInicial * 6.5 - 7;
        }
    }

    public void defineCoordenadaInicial()
    {
        if(quadranteInicial == 1)
        {
            xInicial = tesla.getX();
            yInicial = tesla.getY();
        }
        else if(quadranteInicial == 2)
        {
            xInicial = tesla.getX() + 60;
            yInicial = tesla.getY();
        }
        else if(quadranteInicial == 3)
        {
            xInicial = tesla.getX();
            yInicial = tesla.getY() + 60;
        }
        else
        {
            xInicial = tesla.getX() + 60;
            yInicial = tesla.getY() + 60;
        }
    }

    public void moveObjetos(ImageView carro) //incrementos de 0.15 px para 40fps e mapa de 720x720
    {
        if(keepGoing && !girando)
        {
            if(caminhosGUI.get(0).getDirecao().equals("direita"))
            {
                if(caminhosGUI.get(0).getxAtual() < caminhosGUI.get(0).getxDestino())
                {
                    xAtual += 0.5;
                    caminhosGUI.get(0).setxAtual(xAtual);
                }
                else
                {
                    if(caminhosGUI.size() > 1)
                    {
                        if(caminhosGUI.get(1).getDirecao().equals("baixo"))
                        {
                            girando = true;
                            giraPara = "horario";
                        }
                        else if(caminhosGUI.get(1).getDirecao().equals("cima"))
                        {
                            girando = true;
                            giraPara = "antihorario";
                        }
                        else
                            caminhosGUI.remove(0);
                    }
                    if(caminhosGUI.isEmpty())
                    {
                        System.out.println("oi");
                        keepGoing = false;
                    }
                }
            }
            else if(caminhosGUI.get(0).getDirecao().equals("esquerda"))
            {
                if(caminhosGUI.get(0).getxAtual() > caminhosGUI.get(0).getxDestino())
                {
                    xAtual -= 0.5;
                    caminhosGUI.get(0).setxAtual(xAtual);
                }
                else
                {
                    if(caminhosGUI.size() > 1)
                    {
                        if(caminhosGUI.get(1).getDirecao().equals("baixo"))
                        {
                            girando = true;
                            giraPara = "antihorario";
                        }
                        else if(caminhosGUI.get(1).getDirecao().equals("cima"))
                        {
                            girando = true;
                            giraPara = "horario";
                        }
                        else
                            caminhosGUI.remove(0);
                    }

                    if(caminhosGUI.isEmpty())
                    {
                        keepGoing = false;
                    }
                }
            }
            else if(caminhosGUI.get(0).getDirecao().equals("cima"))
            {
                if(caminhosGUI.get(0).getyAtual() > caminhosGUI.get(0).getyDestino())
                {
                    yAtual -= 0.5;
                    caminhosGUI.get(0).setyAtual(yAtual);
                }
                else
                {
                    if(caminhosGUI.size() > 1)
                    {
                        if(caminhosGUI.get(1).getDirecao().equals("esquerda"))
                        {
                            girando = true;
                            giraPara = "antihorario";
                        }
                        else if(caminhosGUI.get(1).getDirecao().equals("direita"))
                        {
                            girando = true;
                            giraPara = "horario";
                        }
                        else
                            caminhosGUI.remove(0);
                    }
                    if(caminhosGUI.isEmpty())
                    {
                        keepGoing = false;
                    }
                }
            }
            else
            {
                if(caminhosGUI.get(0).getyAtual() < caminhosGUI.get(0).getyDestino())
                {
                    yAtual += 0.5;
                    caminhosGUI.get(0).setyAtual(yAtual);
                }
                else
                {
                    if(caminhosGUI.size() > 1)
                    {
                        if(caminhosGUI.get(1).getDirecao().equals("direita"))
                        {
                            girando = true;
                            giraPara = "antihorario";
                        }
                        else if(caminhosGUI.get(1).getDirecao().equals("esquerda"))
                        {
                            girando = true;
                            giraPara = "horario";
                        }
                        else
                            caminhosGUI.remove(0);
                    }
                    if(caminhosGUI.isEmpty())
                    {
                        keepGoing = false;
                    }
                }
            }
        }
        if(girando)
        {
            gira(carro);
        }
        carro.setVisible(true);
        carro.setLayoutY(yAtual);
        carro.setLayoutX(xAtual);
        carro.setRotate(caminhosGUI.get(0).getAngulo());

    }

    public void gira(ImageView carro)
    {
        if(giraPara.equals("horario"))
        {
            caminhosGUI.get(0).setAngulo(caminhosGUI.get(0).getAngulo() + 5);
        }
        else
            caminhosGUI.get(0).setAngulo(caminhosGUI.get(0).getAngulo() - 5);
        carro.setRotate(caminhosGUI.get(0).getAngulo());
        contadorRotacao++;
        if(contadorRotacao == 18.0)
        {
            girando = false;
            contadorRotacao = 0;
            caminhosGUI.remove(0);
        }
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public AutoPilot getTesla() {
        return tesla;
    }

    public void setTesla(AutoPilot tesla) {
        this.tesla = tesla;
    }

    public List<CaminhoGUI> getCaminhosGUI() {
        return caminhosGUI;
    }

    public void setCaminhosGUI(List<CaminhoGUI> caminhosGUI) {
        this.caminhosGUI = caminhosGUI;
    }

    public String getRuaDeOrigem() {
        return ruaDeOrigem;
    }

    public void setRuaDeOrigem(String ruaDeOrigem) {
        this.ruaDeOrigem = ruaDeOrigem;
    }

    public String getRuaDeDestino() {
        return ruaDeDestino;
    }

    public void setRuaDeDestino(String ruaDeDestino) {
        this.ruaDeDestino = ruaDeDestino;
    }

    public String getRespostaGPSOrigem() {
        return respostaGPSOrigem;
    }

    public void setRespostaGPSOrigem(String respostaGPSOrigem) {
        this.respostaGPSOrigem = respostaGPSOrigem;
    }

    public String getRespostaGPSDestino() {
        return respostaGPSDestino;
    }

    public void setRespostaGPSDestino(String respostaGPSDestino) {
        this.respostaGPSDestino = respostaGPSDestino;
    }

    public String getGiraPara() {
        return giraPara;
    }

    public void setGiraPara(String giraPara) {
        this.giraPara = giraPara;
    }

    public double getxInicial() {
        return xInicial;
    }

    public void setxInicial(double xInicial) {
        this.xInicial = xInicial;
    }

    public double getyInicial() {
        return yInicial;
    }

    public void setyInicial(double yInicial) {
        this.yInicial = yInicial;
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

    public double getContadorRotacao() {
        return contadorRotacao;
    }

    public void setContadorRotacao(double contadorRotacao) {
        this.contadorRotacao = contadorRotacao;
    }

    public boolean isKeepGoing() {
        return keepGoing;
    }

    public void setKeepGoing(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    public boolean isGirando() {
        return girando;
    }

    public void setGirando(boolean girando) {
        this.girando = girando;
    }

    public int getQuadranteInicial() {
        return quadranteInicial;
    }

    public void setQuadranteInicial(int quadranteInicial) {
        this.quadranteInicial = quadranteInicial;
    }

    //protected ImageView carro;
    protected GPS gps;
    protected AutoPilot tesla;
    protected List<CaminhoGUI> caminhosGUI;
    protected String ruaDeOrigem, ruaDeDestino, respostaGPSOrigem, respostaGPSDestino, giraPara;
    protected double xInicial, yInicial, xAtual, yAtual, contadorRotacao = 0.0;
    protected boolean keepGoing = true, girando = false;
    protected int quadranteInicial;
}
