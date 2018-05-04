import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void obterRota() throws IOException {
        ruaDeOrigem = ruaOrigem.getText();
        ruaDeDestino = ruaDestino.getText();
        gps = new GPS();
        respostaGPSOrigem = gps.ruaExiste(ruaDeOrigem);
        respostaGPSDestino = gps.ruaExiste(ruaDeDestino);

        if(respostaGPSOrigem.equals("naoEncontrado") || respostaGPSDestino.equals("naoEncontrado"))
        {
            chamaErroEndereco();
        }

        System.out.println("Arestas da rua de Origem: " + respostaGPSOrigem + "\nArestas da rua de Destino: " + respostaGPSDestino);

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
        new Animador().start();
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

    public void chamaErroEndereco() throws IOException
    {
        Parent erroEnderecoParent = FXMLLoader.load(getClass().getResource("PopupErroEndereco.fxml"));
        Scene erroEnderecoScene = new Scene(erroEnderecoParent);

        avisoErro = new Stage();
        avisoErro.setTitle("ENDEREÇO INVÁLIDO!");
        avisoErro.setScene(erroEnderecoScene);
        avisoErro.initModality(Modality.APPLICATION_MODAL);
        avisoErro.initOwner(botaoEnderecos.getScene().getWindow());
        avisoErro.showAndWait();
    }

    public void fechaAviso()
    {
        Stage stage = (Stage) botaoOk.getScene().getWindow();
        stage.close();
    }

    class Animador extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                xAtual = xInicial*6;
                yAtual = yInicial*6;


                while (keepGoing)
                {
                    Thread.sleep(25); //40fps
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            moveObjetos();
                        }
                    });
                }

            }catch (InterruptedException ex)
            {
                return;
            }
        }
    }

    public void moveObjetos() //incrementos de 0.15 px para 40fps e mapa de 720x720
    {
        if(keepGoing && !girando)
        {
            if(caminhosGUI.get(0).getDirecao().equals("direita"))
            {
                if(caminhosGUI.get(0).getxAtual() < caminhosGUI.get(0).getxDestino())
                {
                    xAtual += 0.3;
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
                    xAtual -= 0.3;
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
                    yAtual -= 0.3;
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
                    yAtual += 0.3;
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
            gira();
        }
        carro.setLayoutY(yAtual);
        carro.setLayoutX(xAtual);
        carro.setRotate(caminhosGUI.get(0).getAngulo());
        //System.out.println("x atual " + caminhosGUI.get(0).getxAtual());
        //System.out.println("y atual " + caminhosGUI.get(0).getyAtual());
        //System.out.println("x destino " + caminhosGUI.get(0).getxDestino());
        //System.out.println("y destino " + caminhosGUI.get(0).getyDestino());
    }

    public void gira()
    {
        if(giraPara.equals("horario"))
        {
            caminhosGUI.get(0).setAngulo(caminhosGUI.get(0).getAngulo() + 1);
        }
        else
            caminhosGUI.get(0).setAngulo(caminhosGUI.get(0).getAngulo() - 1);
        carro.setRotate(caminhosGUI.get(0).getAngulo());
        contadorRotacao++;
        if(contadorRotacao == 90.0)
        {
            girando = false;
            contadorRotacao = 0;
            caminhosGUI.remove(0);
        }
    }

    public Button botaoEnderecos, botaoOk;
    public Pane layoutAnimacao;
    public HBox menuSuperior, menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor;
    public TextField ruaOrigem, ruaDestino;
    public String ruaDeOrigem, ruaDeDestino, respostaGPSOrigem, respostaGPSDestino, giraPara;
    public ImageView mapaCidade;
    public StackPane stackAnimacao;
    public Stage avisoErro;
    public GPS gps;
    public AutoPilot tesla;
    public List <CaminhoGUI> caminhosGUI;
    public Rectangle carro;
    public double xInicial, yInicial, xAtual, yAtual, contadorRotacao = 0.0;
    public boolean keepGoing = true, girando = false;
    public int quadranteInicial;
}
