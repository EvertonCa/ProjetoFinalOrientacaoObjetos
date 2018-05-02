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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void pegaRuas() throws IOException {
        ruaDeOrigem = ruaOrigem.getText();
        ruaDeDestino = ruaDestino.getText();
        GPS gps = new GPS();
        respostaGPSOrigem = gps.ruaExiste(ruaDeOrigem);
        respostaGPSDestino = gps.ruaExiste(ruaDeDestino);

        if(respostaGPSOrigem.equals("naoEncontrado") || respostaGPSDestino.equals("naoEncontrado"))
        {
            chamaErroEndereco();
        }

        System.out.println(respostaGPSOrigem + " e " + respostaGPSDestino);
    }

    public void calcularRota()
    {

    }

    public void popupBoasVindas() throws IOException
    {
        Parent boasVindasParent = FXMLLoader.load(getClass().getResource("PopUpBoasVindas.fxml"));
        Scene boasVindasScene = new Scene(boasVindasParent);

        boasVindas = new Stage();
        boasVindas.setScene(boasVindasScene);
        boasVindas.initOwner(botaoEnderecos.getScene().getWindow());
        boasVindas.showAndWait();

        boasVindas.close();
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

    public Button botaoEnderecos, botaoOk;
    public Pane layoutAnimacao;
    public HBox menuSuperior, menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor;
    public TextField ruaOrigem, ruaDestino;
    public String ruaDeOrigem, ruaDeDestino, respostaGPSOrigem, respostaGPSDestino;
    public ImageView mapaCidade;
    public StackPane stackAnimacao;
    public Stage avisoErro, boasVindas;
}
