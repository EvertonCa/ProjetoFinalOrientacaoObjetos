import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AreaPrincipalController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }

    public void determinaQuantidadeDeCarros()
    {
        if(radioButtonGroup.getSelectedToggle().equals(radioButton1))
        {
            quantidadeDeCarros = 1;
        }
        else if(radioButtonGroup.getSelectedToggle().equals(radioButton2))
        {
            quantidadeDeCarros = 2;
        }
        else if(radioButtonGroup.getSelectedToggle().equals(radioButton3))
        {
            quantidadeDeCarros = 3;
        }
        else if(radioButtonGroup.getSelectedToggle().equals(radioButton4))
        {
            quantidadeDeCarros = 4;
        }
        else
        {
            quantidadeDeCarros = 5;
        }
        System.out.println("Quantidade de Carros: " + quantidadeDeCarros);
    }

    public void determinaRotasDefinidas()
    {
        if(toggleButton1Group.getSelectedToggle().equals(botaoDefinido))
        {
            rotasDefinidas = true;
        }
        else
        {
            rotasDefinidas = false;
        }

        System.out.println("Rotas definidas: " + rotasDefinidas);
    }

    public void determinaSemaforosHabilitados()
    {
        if(toggleButton2Group.getSelectedToggle().equals(botaoHabilitado))
        {
            semaforosHabilitados = true;
        }
        else
        {
            semaforosHabilitados = false;
        }

        System.out.println("Semaforos Habilitados: " + semaforosHabilitados);
    }

    public void obterRota() throws IOException
    {
        if(rotasCalculadas == 0)
        {
            handleCarro1 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

            if(handleCarro1.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro1.getRespostaGPSDestino().equals("naoEncontrado"))
            {
                chamaErroEndereco();
            }
            rotasCalculadas = 1;
            labelTituloRuas.setVisible(true);
            labelCor.setVisible(true);
            labelRuaDestino.setVisible(true);
            labelRuaOrigem.setVisible(true);
            ruaDeOrigem1.setText(ruaOrigem.getText());
            ruaDeOrigem1.setVisible(true);
            ruaDeDestino1.setText(ruaDestino.getText());
            ruaDeDestino1.setVisible(true);
            iconeCarro1.setVisible(true);
        }
        else if(rotasCalculadas == 1)
        {
            handleCarro2 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

            if(handleCarro2.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro2.getRespostaGPSDestino().equals("naoEncontrado"))
            {
                chamaErroEndereco();
            }
            rotasCalculadas = 2;
            ruaDeOrigem2.setText(ruaOrigem.getText());
            ruaDeOrigem2.setVisible(true);
            ruaDeDestino2.setText(ruaDestino.getText());
            ruaDeDestino2.setVisible(true);
            iconeCarro2.setVisible(true);
        }
        else if(rotasCalculadas == 2)
        {
            handleCarro3 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

            if(handleCarro3.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro3.getRespostaGPSDestino().equals("naoEncontrado"))
            {
                chamaErroEndereco();
            }
            rotasCalculadas = 3;
            ruaDeOrigem3.setText(ruaOrigem.getText());
            ruaDeOrigem3.setVisible(true);
            ruaDeDestino3.setText(ruaDestino.getText());
            ruaDeDestino3.setVisible(true);
            iconeCarro3.setVisible(true);
        }
        else if(rotasCalculadas == 3)
        {
            handleCarro4 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

            if(handleCarro4.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro4.getRespostaGPSDestino().equals("naoEncontrado"))
            {
                chamaErroEndereco();
            }
            rotasCalculadas = 4;
            ruaDeOrigem4.setText(ruaOrigem.getText());
            ruaDeOrigem4.setVisible(true);
            ruaDeDestino4.setText(ruaDestino.getText());
            ruaDeDestino4.setVisible(true);
            iconeCarro4.setVisible(true);
        }
        else if(rotasCalculadas == 4)
        {
            handleCarro5 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

            if(handleCarro5.getRespostaGPSOrigem().equals("naoEncontrado") || handleCarro5.getRespostaGPSDestino().equals("naoEncontrado"))
            {
                chamaErroEndereco();
            }
            rotasCalculadas = 5;
            ruaDeOrigem5.setText(ruaOrigem.getText());
            ruaDeOrigem5.setVisible(true);
            ruaDeDestino5.setText(ruaDestino.getText());
            ruaDeDestino5.setVisible(true);
            iconeCarro5.setVisible(true);
        }
        if(rotasCalculadas == quantidadeDeCarros)
        {
            botaoEnderecos.setDisable(true);
        }
        ruaOrigem.clear();
        ruaDestino.clear();
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

                while (keepGoing)
                {
                    Thread.sleep(25); //40fps
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            if(quantidadeDeCarros == 1)
                            {
                                handleCarro1.moveObjetos(carro1);
                                keepGoing = handleCarro1.isKeepGoing();
                            }
                            else if(quantidadeDeCarros == 2)
                            {
                                handleCarro1.moveObjetos(carro1);
                                handleCarro2.moveObjetos(carro2);

                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing())
                                    keepGoing = false;
                            }
                            else if(quantidadeDeCarros == 3)
                            {
                                handleCarro1.moveObjetos(carro1);
                                handleCarro2.moveObjetos(carro2);
                                handleCarro3.moveObjetos(carro3);
                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() && !handleCarro3.isKeepGoing())
                                    keepGoing = false;
                            }
                            else if(quantidadeDeCarros == 4)
                            {
                                handleCarro1.moveObjetos(carro1);
                                handleCarro2.moveObjetos(carro2);
                                handleCarro3.moveObjetos(carro3);
                                handleCarro4.moveObjetos(carro4);
                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() &&
                                        !handleCarro3.isKeepGoing() && !handleCarro4.isKeepGoing())
                                    keepGoing = false;
                            }
                            else
                            {
                                handleCarro1.moveObjetos(carro1);
                                handleCarro2.moveObjetos(carro2);
                                handleCarro3.moveObjetos(carro3);
                                handleCarro4.moveObjetos(carro4);
                                handleCarro5.moveObjetos(carro5);
                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() &&
                                        !handleCarro3.isKeepGoing() && !handleCarro4.isKeepGoing() && !handleCarro5.isKeepGoing())
                                    keepGoing = false;
                            }
                        }
                    });
                }

            }catch (InterruptedException ex)
            {
                return;
            }
        }
    }

    public void fecharPrograma()
    {
        Stage stage = (Stage) layout.getScene().getWindow();
        stage.close();
    }

    public void novoPrograma() throws IOException
    {
        VBox buffer = FXMLLoader.load(getClass().getResource("AreaPrincipal.fxml"));
        layout.getChildren().setAll(buffer);
    }

    public Button botaoEnderecos, botaoOk, botaoMostrarNoMapa;
    public RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    public ToggleButton botaoDefinido, botaoAleatorio, botaoHabilitado, botaoNaoHabilitado;
    public ToggleGroup radioButtonGroup, toggleButton1Group, toggleButton2Group;
    public Pane layoutAnimacao;
    public HBox menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor, ruaDeOrigem1, ruaDeOrigem2, ruaDeOrigem3, ruaDeOrigem4, ruaDeOrigem5, labelTituloRuas;
    public Label ruaDeDestino1, ruaDeDestino2, ruaDeDestino3, ruaDeDestino4, ruaDeDestino5, labelCor, labelRuaOrigem, labelRuaDestino;
    public TextField ruaOrigem, ruaDestino;
    public ImageView mapaCidade,miniMapa, carro1, carro2, carro3, carro4, carro5;
    public ImageView iconeCarro1, iconeCarro2, iconeCarro3, iconeCarro4, iconeCarro5;
    public StackPane stackAnimacao;
    public Stage avisoErro;
    public AreaPrincipalHandle handleCarro1, handleCarro2, handleCarro3, handleCarro4, handleCarro5;
    public boolean keepGoing = true, rotasDefinidas = true, semaforosHabilitados = true;
    public int quantidadeDeCarros = 1, rotasCalculadas = 0;
    public Menu menuArquivo, menuAjuda;
    public MenuItem itemNovo, itemFechar, itemSobre;
    public MenuBar menuBar;

}
