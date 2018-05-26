/**
 / Classe responsável por administrar a criação e movimentação de veiculos individuais
 **/

import javafx.scene.image.ImageView;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AreaPrincipalHandle {

    /// Construtor que recebe as ruas de origem e destino e calcula a rota e os caminhos para o veiculo.
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

    /// Define a coordenada inicial na Rua de Origem.
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

    /// Move o objeto 0.5 pixel ou o gira para a direção definida.
    public void moveObjetos(ImageView carro)
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
                    direitaOuEsquerda("horario", "antihorario");

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
                    direitaOuEsquerda("antihorario", "horario");

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
                    cimaOuBaixo("esquerda", "direita");
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
                    cimaOuBaixo("direita", "esquerda");
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

    /// Método auxiliar para "MoveObjeto"
    private void cimaOuBaixo(String esquerda, String direita) {
        if(caminhosGUI.size() > 1)
        {
            if(caminhosGUI.get(1).getDirecao().equals(esquerda))
            {
                girando = true;
                giraPara = "antihorario";
            }
            else if(caminhosGUI.get(1).getDirecao().equals(direita))
            {
                girando = true;
                giraPara = "horario";
            }
            else
                caminhosGUI.remove(0);
        }
        else
            keepGoing = false;
    }

    /// Método auxiliar para "MoveObjeto"
    private void direitaOuEsquerda(String horario, String antihorario) {
        if(caminhosGUI.size() > 1)
        {
            if(caminhosGUI.get(1).getDirecao().equals("baixo"))
            {
                girando = true;
                giraPara = horario;
            }
            else if(caminhosGUI.get(1).getDirecao().equals("cima"))
            {
                girando = true;
                giraPara = antihorario;
            }
            else
                caminhosGUI.remove(0);
        }
        else
            keepGoing = false;
    }

    /// Gira o veiculos para o sentido correto (5 graus por iteração)
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

    public String getRespostaGPSOrigem() {
        return respostaGPSOrigem;
    }

    public String getRespostaGPSDestino() {
        return respostaGPSDestino;
    }

    public boolean isKeepGoing() {
        return keepGoing;
    }

    public double getyAtual() {
        return yAtual;
    }

    public double getxAtual() {
        return xAtual;
    }

    protected GPS gps;
    protected AutoPilot tesla;
    protected List<CaminhoGUI> caminhosGUI;
    protected String ruaDeOrigem, ruaDeDestino, respostaGPSOrigem, respostaGPSDestino, giraPara;
    protected double xInicial, yInicial, xAtual, yAtual, contadorRotacao = 0.0;
    protected boolean keepGoing = true, girando = false;
    protected int quadranteInicial;
}
