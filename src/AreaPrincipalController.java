import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
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
import java.util.List;

public class AreaPrincipalController {

    public void obterRota() throws IOException {
        handleCarro1 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

        if(handleCarro1.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro1.getRespostaGPSDestino().equals("naoEncontrado"))
        {
            chamaErroEndereco();
        }
    }

    public void rodarPrograma()
    {
        new Animador().start();
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

                while (keepGoing1)
                {
                    Thread.sleep(25); //40fps
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            handleCarro1.moveObjetos(carro1);
                            keepGoing1 = handleCarro1.isKeepGoing();
                        }
                    });
                }

            }catch (InterruptedException ex)
            {
                return;
            }
        }
    }

    public Button botaoEnderecos, botaoOk, botaoMostrarNoMapa;
    public Pane layoutAnimacao;
    public HBox menuSuperior, menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor;
    public TextField ruaOrigem, ruaDestino;
    public ImageView mapaCidade, carro1, carro2, carro3, carro4, carro5;
    public StackPane stackAnimacao;
    public Stage avisoErro;
    public AreaPrincipalHandle handleCarro1;
    public boolean keepGoing1 = true;

}
