import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
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

        tesla.gerarCoordenadasGUI();
        caminhosGUI = tesla.gerarRotasGUI();
        tesla.exibeRotasGUI();
        tesla.posicionaNaAresta();
        xInicial = tesla.getX();
        yInicial = tesla.getY();
        animador();
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

    public void animador()
    {
        carro.setLayoutX(xInicial*5);
        carro.setLayoutY(yInicial*5);

        SequentialTransition animaTudo = new SequentialTransition();
        animaTudo.setNode(carro);

        for(int i = 0; i < caminhosGUI.size(); i++)
        {
            if(caminhosGUI.get(i).getDirecao().equals("direita"))
            {
                TranslateTransition animacao = new TranslateTransition();
                animacao.setDuration(Duration.seconds(caminhosGUI.get(0).getTamanho()));
                animacao.setNode(carro);
                animacao.setToX(xInicial*5 + caminhosGUI.get(0).getTamanho());
                animaTudo.getChildren().add(animacao);
            }
            else if(caminhosGUI.get(i).getDirecao().equals("esquerda"))
            {
                TranslateTransition animacao = new TranslateTransition();
                animacao.setDuration(Duration.seconds(caminhosGUI.get(0).getTamanho()));
                animacao.setNode(carro);
                animacao.setToX(xInicial*5 - caminhosGUI.get(0).getTamanho());
                animaTudo.getChildren().add(animacao);
            }
            else if(caminhosGUI.get(i).getDirecao().equals("cima"))
            {
                TranslateTransition animacao = new TranslateTransition();
                animacao.setDuration(Duration.seconds(caminhosGUI.get(0).getTamanho()));
                animacao.setNode(carro);
                animacao.setToY(yInicial*5 - caminhosGUI.get(0).getTamanho());
                animaTudo.getChildren().add(animacao);
            }
            else
            {
                TranslateTransition animacao = new TranslateTransition();
                animacao.setDuration(Duration.seconds(caminhosGUI.get(0).getTamanho()));
                animacao.setNode(carro);
                animacao.setToY(yInicial*5 + caminhosGUI.get(0).getTamanho());
                animaTudo.getChildren().add(animacao);
            }

            RotateTransition gira = new RotateTransition();
            gira.setDuration(Duration.seconds(1));
            gira.setNode(carro);
            gira.setByAngle(90.0);
            animaTudo.getChildren().add(gira);
        }

        animaTudo.play();
    }

    public Button botaoEnderecos, botaoOk;
    public Pane layoutAnimacao;
    public HBox menuSuperior, menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor;
    public TextField ruaOrigem, ruaDestino;
    public String ruaDeOrigem, ruaDeDestino, respostaGPSOrigem, respostaGPSDestino;
    public ImageView mapaCidade;
    public StackPane stackAnimacao;
    public Stage avisoErro, animacao;
    public GPS gps;
    public AutoPilot tesla;
    public List <CaminhoGUI> caminhosGUI;
    public Rectangle carro;
    public int xInicial, yInicial;
}
