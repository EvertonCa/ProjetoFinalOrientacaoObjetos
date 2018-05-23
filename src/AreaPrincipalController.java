import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class AreaPrincipalController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Inicializou o programa");
        defineCoordenadaSemaforo();
        System.out.println("Criou lista de interseccoes");
        criaArrayDeImagens();
        System.out.println("Criou array de imagens");
        colocaSemaforoNoMapa();
        System.out.println("Semaforos Habilitados: true");
    }

    public void colocaSemaforoNoMapa()
    {
        int cont = 0;

        Image img;
        for (int i = 0; i < listaDeInteseccao.size(); i++)
        {
            for (int j = 0; j < listaDeInteseccao.get(i).getListaSemaforos().size(); j++){
                if (listaDeInteseccao.get(i).getListaSemaforos().get(j).getQuadrante() == 1)
                {
                    vetorDeImagensDoSemaforo.get(cont).setLayoutX(listaDeInteseccao.get(i).getListaSemaforos().get(j).getX() * 6.5 - 4);
                    vetorDeImagensDoSemaforo.get(cont).setLayoutY(listaDeInteseccao.get(i).getListaSemaforos().get(j).getY() * 6.5 - 7);
                }
                else if (listaDeInteseccao.get(i).getListaSemaforos().get(j).getQuadrante() == 2)
                {
                    vetorDeImagensDoSemaforo.get(cont).setLayoutX((listaDeInteseccao.get(i).getListaSemaforos().get(j).getX() + 60) * 6.5 - 4);
                    vetorDeImagensDoSemaforo.get(cont).setLayoutY(listaDeInteseccao.get(i).getListaSemaforos().get(j).getY() * 6.5 - 7);
                }
                else if (listaDeInteseccao.get(i).getListaSemaforos().get(j).getQuadrante() == 3)
                {
                    vetorDeImagensDoSemaforo.get(cont).setLayoutX(listaDeInteseccao.get(i).getListaSemaforos().get(j).getX() * 6.5 - 4);
                    vetorDeImagensDoSemaforo.get(cont).setLayoutY((listaDeInteseccao.get(i).getListaSemaforos().get(j).getY() + 60) * 6.5 - 7);
                }
                else
                {
                    vetorDeImagensDoSemaforo.get(cont).setLayoutX((listaDeInteseccao.get(i).getListaSemaforos().get(j).getX() + 60) * 6.5 - 4);
                    vetorDeImagensDoSemaforo.get(cont).setLayoutY((listaDeInteseccao.get(i).getListaSemaforos().get(j).getY() + 60) * 6.5 - 7);
                }

                if (listaDeInteseccao.get(i).getListaSemaforos().get(j).getVerde())
                {
                    img = new Image("FarolVerde.png");
                    vetorDeImagensDoSemaforo.get(cont).setImage(img);
                }
                else
                {
                    img = new Image("FarolVermelho.png");
                    vetorDeImagensDoSemaforo.get(cont).setImage(img);
                }

                vetorDeImagensDoSemaforo.get(cont).setVisible(true);

                cont ++;
            }
        }
    }

    public void tiraSemaforoDoMapa ()
    {
        for (int i = 0; i < vetorDeImagensDoSemaforo.size(); i++)
        {
            vetorDeImagensDoSemaforo.get(i).setVisible(false);
        }
    }

    public void defineCoordenadaSemaforo()
    {
        listaDeInteseccao = new ArrayList<>();
        try
        {
            for (int k = 1; k <= 4; k ++)
            {
                Manipulador manip = new Manipulador();
                Properties prop;

                switch (k)
                {
                    case 1:
                    {
                        prop = manip.getInterseccoesQ1();
                        break;
                    }

                    case 2:
                    {
                        prop = manip.getInterseccoesQ2();
                        break;
                    }

                    case 3:
                    {
                        prop = manip.getInterseccoesQ3();
                        break;
                    }

                    default:
                    {
                        prop = manip.getInterseccoesQ4();
                        break;
                    }

                }

                int quantidadeDeInterseccoes = Integer.parseInt(prop.getProperty("quantidadeDeInterseccoes"));

                for(int i = 0; i < quantidadeDeInterseccoes; i++)
                {
                    int descricao = Integer.parseInt(prop.getProperty("interseccao" + i + "Descricao"));
                    int duracao = Integer.parseInt(prop.getProperty("interseccao" + i + "DuracaoSemaforo"));
                    int quantidadeDeSemaforos = Integer.parseInt(prop.getProperty("interseccao" + i + "QuantidadeDeSemaforos"));

                    ArrayList <Semaforo> semaforosDaInterseccao = new ArrayList<Semaforo>();

                    for (int j = 0; j < quantidadeDeSemaforos; j++)
                    {
                        int quadrante = Integer.parseInt(prop.getProperty("interseccao" + i + "QuadranteDoSemaforo" + j));
                        int x = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoX" + j));
                        int y = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoY" + j));
                        boolean verde = Boolean.parseBoolean(prop.getProperty("interseccao" + i + "SituacaoSemaforo" + j));

                        semaforosDaInterseccao.add(new Semaforo(x, y, verde, duracao, quadrante));
                    }

                    listaDeInteseccao.add(new Interseccao(semaforosDaInterseccao, descricao));
                }
                System.out.println("Leu os semaforos do quadrante " + (k));
            }
        }catch (IOException e){System.out.println("Erro no arquivo de propriedades");}
    }

    public void criaArrayDeImagens ()
    {
        vetorDeImagensDoSemaforo = new ArrayList<ImageView>();

        vetorDeImagensDoSemaforo.add(semaforo1);
        vetorDeImagensDoSemaforo.add(semaforo2);
        vetorDeImagensDoSemaforo.add(semaforo3);
        vetorDeImagensDoSemaforo.add(semaforo4);
        vetorDeImagensDoSemaforo.add(semaforo5);
        vetorDeImagensDoSemaforo.add(semaforo6);
        vetorDeImagensDoSemaforo.add(semaforo7);
        vetorDeImagensDoSemaforo.add(semaforo8);
        vetorDeImagensDoSemaforo.add(semaforo9);
        vetorDeImagensDoSemaforo.add(semaforo10);
        vetorDeImagensDoSemaforo.add(semaforo11);
        vetorDeImagensDoSemaforo.add(semaforo12);
        vetorDeImagensDoSemaforo.add(semaforo13);
        vetorDeImagensDoSemaforo.add(semaforo14);
        vetorDeImagensDoSemaforo.add(semaforo15);
        vetorDeImagensDoSemaforo.add(semaforo16);
        vetorDeImagensDoSemaforo.add(semaforo17);
        vetorDeImagensDoSemaforo.add(semaforo18);
        vetorDeImagensDoSemaforo.add(semaforo19);
        vetorDeImagensDoSemaforo.add(semaforo20);
        vetorDeImagensDoSemaforo.add(semaforo21);
        vetorDeImagensDoSemaforo.add(semaforo22);
        vetorDeImagensDoSemaforo.add(semaforo23);
        vetorDeImagensDoSemaforo.add(semaforo24);
        vetorDeImagensDoSemaforo.add(semaforo25);
        vetorDeImagensDoSemaforo.add(semaforo26);
        vetorDeImagensDoSemaforo.add(semaforo27);
        vetorDeImagensDoSemaforo.add(semaforo28);
        vetorDeImagensDoSemaforo.add(semaforo29);
        vetorDeImagensDoSemaforo.add(semaforo30);
        vetorDeImagensDoSemaforo.add(semaforo31);
        vetorDeImagensDoSemaforo.add(semaforo32);
        vetorDeImagensDoSemaforo.add(semaforo33);
        vetorDeImagensDoSemaforo.add(semaforo34);
        vetorDeImagensDoSemaforo.add(semaforo35);
        vetorDeImagensDoSemaforo.add(semaforo36);
        vetorDeImagensDoSemaforo.add(semaforo37);
        vetorDeImagensDoSemaforo.add(semaforo38);
        vetorDeImagensDoSemaforo.add(semaforo39);
        vetorDeImagensDoSemaforo.add(semaforo40);
        vetorDeImagensDoSemaforo.add(semaforo41);
        vetorDeImagensDoSemaforo.add(semaforo42);
        vetorDeImagensDoSemaforo.add(semaforo43);
        vetorDeImagensDoSemaforo.add(semaforo44);
        vetorDeImagensDoSemaforo.add(semaforo45);
        vetorDeImagensDoSemaforo.add(semaforo46);
        vetorDeImagensDoSemaforo.add(semaforo47);
        vetorDeImagensDoSemaforo.add(semaforo48);
        vetorDeImagensDoSemaforo.add(semaforo49);
        vetorDeImagensDoSemaforo.add(semaforo50);
        vetorDeImagensDoSemaforo.add(semaforo51);
        vetorDeImagensDoSemaforo.add(semaforo52);
        vetorDeImagensDoSemaforo.add(semaforo53);
        vetorDeImagensDoSemaforo.add(semaforo54);
        vetorDeImagensDoSemaforo.add(semaforo55);
        vetorDeImagensDoSemaforo.add(semaforo56);
        vetorDeImagensDoSemaforo.add(semaforo57);
        vetorDeImagensDoSemaforo.add(semaforo58);
        vetorDeImagensDoSemaforo.add(semaforo59);
        vetorDeImagensDoSemaforo.add(semaforo60);
        vetorDeImagensDoSemaforo.add(semaforo61);
        vetorDeImagensDoSemaforo.add(semaforo62);
        vetorDeImagensDoSemaforo.add(semaforo63);
        vetorDeImagensDoSemaforo.add(semaforo64);
        vetorDeImagensDoSemaforo.add(semaforo65);
        vetorDeImagensDoSemaforo.add(semaforo66);
        vetorDeImagensDoSemaforo.add(semaforo67);
        vetorDeImagensDoSemaforo.add(semaforo68);
        vetorDeImagensDoSemaforo.add(semaforo69);
        vetorDeImagensDoSemaforo.add(semaforo70);
        vetorDeImagensDoSemaforo.add(semaforo71);
        vetorDeImagensDoSemaforo.add(semaforo72);
        vetorDeImagensDoSemaforo.add(semaforo73);
        vetorDeImagensDoSemaforo.add(semaforo74);
        vetorDeImagensDoSemaforo.add(semaforo75);
        vetorDeImagensDoSemaforo.add(semaforo76);
        vetorDeImagensDoSemaforo.add(semaforo77);
        vetorDeImagensDoSemaforo.add(semaforo78);
        vetorDeImagensDoSemaforo.add(semaforo79);
        vetorDeImagensDoSemaforo.add(semaforo80);
        vetorDeImagensDoSemaforo.add(semaforo81);
        vetorDeImagensDoSemaforo.add(semaforo82);
        vetorDeImagensDoSemaforo.add(semaforo83);
        vetorDeImagensDoSemaforo.add(semaforo84);
        vetorDeImagensDoSemaforo.add(semaforo85);
        vetorDeImagensDoSemaforo.add(semaforo86);
        vetorDeImagensDoSemaforo.add(semaforo87);
        vetorDeImagensDoSemaforo.add(semaforo88);
        vetorDeImagensDoSemaforo.add(semaforo89);
        vetorDeImagensDoSemaforo.add(semaforo90);
        vetorDeImagensDoSemaforo.add(semaforo91);
        vetorDeImagensDoSemaforo.add(semaforo92);
        vetorDeImagensDoSemaforo.add(semaforo93);
        vetorDeImagensDoSemaforo.add(semaforo94);
        vetorDeImagensDoSemaforo.add(semaforo95);
        vetorDeImagensDoSemaforo.add(semaforo96);
        vetorDeImagensDoSemaforo.add(semaforo97);
        vetorDeImagensDoSemaforo.add(semaforo98);
        vetorDeImagensDoSemaforo.add(semaforo99);
        vetorDeImagensDoSemaforo.add(semaforo100);
        vetorDeImagensDoSemaforo.add(semaforo101);
        vetorDeImagensDoSemaforo.add(semaforo102);
        vetorDeImagensDoSemaforo.add(semaforo103);
        vetorDeImagensDoSemaforo.add(semaforo104);
        vetorDeImagensDoSemaforo.add(semaforo105);
        vetorDeImagensDoSemaforo.add(semaforo106);
        vetorDeImagensDoSemaforo.add(semaforo107);
        vetorDeImagensDoSemaforo.add(semaforo108);
        vetorDeImagensDoSemaforo.add(semaforo109);
        vetorDeImagensDoSemaforo.add(semaforo110);
        vetorDeImagensDoSemaforo.add(semaforo111);
        vetorDeImagensDoSemaforo.add(semaforo112);
        vetorDeImagensDoSemaforo.add(semaforo113);
        vetorDeImagensDoSemaforo.add(semaforo114);
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

        if(!rotasDefinidas)
            habilitaRotasAleatórias();
        else
            habilitaRotasDefinidas();

        System.out.println("Rotas definidas: " + rotasDefinidas);
    }

    public void determinaSemaforosHabilitados()
    {
        if(toggleButton2Group.getSelectedToggle().equals(botaoHabilitado))
        {
            semaforosHabilitados = true;
            colocaSemaforoNoMapa();
        }
        else
        {
            semaforosHabilitados = false;
            tiraSemaforoDoMapa();
        }

        System.out.println("Semaforos Habilitados: " + semaforosHabilitados);
    }


    public void obterRota() throws IOException
    {
        if(!rotasDefinidas)
        {
            rotasAleatorias();
        }
        else
        {
            if(ruaDestino.getText().equals("Rua 32"))
            {
                ruaDestino.clear();
                erroRua32();
            }
            else if(rotasCalculadas == 0)
            {
                handleCarro1 = new AreaPrincipalHandle(ruaOrigem.getText(), ruaDestino.getText());

                if(handleCarro1.getRespostaGPSOrigem().equals("Formato Errado!") || handleCarro1.getRespostaGPSDestino().equals("Formato Errado!"))
                {
                    chamaErroEndereco();
                }
                else
                {
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
                    botaoDefinido.setDisable(true);
                    botaoAleatorio.setDisable(true);
                    botaoHabilitado.setDisable(true);
                    botaoNaoHabilitado.setDisable(true);
                    radioButton1.setDisable(true);
                    radioButton2.setDisable(true);
                    radioButton3.setDisable(true);
                    radioButton4.setDisable(true);
                    radioButton5.setDisable(true);
                }
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
            if(botaoEnderecos.isDisabled())
                botaoMostrarNoMapa.setDisable(false);
            ruaOrigem.clear();
            ruaDestino.clear();
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
        avisoErro.initStyle(StageStyle.UNDECORATED);
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
            Mundo meuMundo = new Mundo();
            int tempo = 13;

            boolean podeMover[];

            podeMover = new boolean[quantidadeDeCarros];


            try
            {
                while (keepGoing)
                {
                    meuMundo.reiniciaMundos();
                    Thread.sleep(25); //40fps

                    if (tempo == 13)
                    {
                        if (!semaforosHabilitados)
                        {
                            for(int i = 0; i < quantidadeDeCarros; i++)
                            {
                                podeMover[i] = true;
                            }
                        }

                        int xDoCarro[], yDoCarro[];

                        tempo = 0;
                        xDoCarro = new int[quantidadeDeCarros];
                        yDoCarro = new int[quantidadeDeCarros];

                        for (int i = 0; i < quantidadeDeCarros; i ++)
                        {
                            int quadrante;
                            if (i == 1)
                            {
                                xDoCarro[i] = (int) ((handleCarro1.getxAtual() + 6) / 6.5);
                                yDoCarro[i] = (int) ((handleCarro1.getyAtual() + 7) / 6.5);
                            }
                            else if (i == 2)
                            {
                                xDoCarro[i] = (int) ((handleCarro2.getxAtual() + 6) / 6.5);
                                yDoCarro[i] = (int) ((handleCarro2.getyAtual() + 7) / 6.5);
                            }
                            else if (i == 3)
                            {
                                xDoCarro[i] = (int) ((handleCarro3.getxAtual() + 6) / 6.5);
                                yDoCarro[i] = (int) ((handleCarro3.getyAtual() + 7) / 6.5);
                            }
                            else if (i == 4)
                            {
                                xDoCarro[i] = (int) ((handleCarro4.getxAtual() + 6) / 6.5);
                                yDoCarro[i] = (int) ((handleCarro4.getyAtual() + 7) / 6.5);
                            }
                            else if (i == 5)
                            {
                                xDoCarro[i] = (int) ((handleCarro5.getxAtual() + 6) / 6.5);
                                yDoCarro[i] = (int) ((handleCarro5.getyAtual() + 7) / 6.5);
                            }

                            if (xDoCarro[i] - 60 >= 0 && yDoCarro[i] - 60 >= 0)
                            {
                                xDoCarro[i] -= 60;
                                yDoCarro[i] -= 60;
                                quadrante = 4;
                            }
                            else if (xDoCarro[i] - 60 >= 0)
                            {
                                xDoCarro[i] -= 60;
                                quadrante = 2;
                            }
                            else if (yDoCarro[i] - 60 >= 0)
                            {
                                yDoCarro[i] -= 60;
                                quadrante = 3;
                            }
                            else
                            {
                                quadrante = 1;
                            }

                            meuMundo.insereVeiculoNoMundo(xDoCarro[i], yDoCarro[i], quadrante);
                        }

                        if (semaforosHabilitados)
                        {
                            int xDoSemaforo, yDoSemaforo;

                            // Executa logica do semaforo
                            for (int i = 0; i < listaDeInteseccao.size(); i++)
                            {
                                listaDeInteseccao.get(i).verificaSemaforo(meuMundo);
                            }
                            //coloca os semaforos na interface grafica
                            colocaSemaforoNoMapa();

                            // Carro verifica se tem semaforo e a cor dele
                            boolean temSemaforo;
                            for (int k = 0; k < quantidadeDeCarros; k++)
                            {
                                temSemaforo = false;
                                for (int i = 0; i < listaDeInteseccao.size(); i++)
                                {
                                    for (int j = 0; j < listaDeInteseccao.get(i).getListaSemaforos().size(); j++)
                                    {

                                        xDoSemaforo = listaDeInteseccao.get(i).getListaSemaforos().get(j).getX();
                                        yDoSemaforo = listaDeInteseccao.get(i).getListaSemaforos().get(j).getY();

                                        if (xDoCarro[k] == xDoSemaforo && yDoCarro[k] + 1 == yDoSemaforo)
                                        {
                                            temSemaforo = true;
                                            podeMover[k] = listaDeInteseccao.get(i).getListaSemaforos().get(j).getVerde();
                                        }
                                        else if (xDoCarro[k] == xDoSemaforo && yDoCarro[k] - 1 == yDoSemaforo)
                                        {
                                            temSemaforo = true;
                                            podeMover[k] = listaDeInteseccao.get(i).getListaSemaforos().get(j).getVerde();
                                        }
                                        else if (xDoCarro[k] + 1 == xDoSemaforo && yDoCarro[k] == yDoSemaforo)
                                        {
                                            temSemaforo = true;
                                            podeMover[k] = listaDeInteseccao.get(i).getListaSemaforos().get(j).getVerde();
                                        }
                                        else if (xDoCarro[k] - 1 == xDoSemaforo && yDoCarro[k] == yDoSemaforo)
                                        {
                                            temSemaforo = true;
                                            podeMover[k] = listaDeInteseccao.get(i).getListaSemaforos().get(j).getVerde();
                                        }
                                    }
                                }
                                if (!temSemaforo)
                                {
                                    podeMover[k] = true;
                                }
                            }
                        }
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            if(quantidadeDeCarros == 1)
                            {
                                if (podeMover[0])
                                    handleCarro1.moveObjetos(carro1);

                                keepGoing = handleCarro1.isKeepGoing();
                                checaPopUpChegou(1);

                            }
                            else if(quantidadeDeCarros == 2)
                            {
                                if (podeMover[0])
                                    handleCarro1.moveObjetos(carro1);
                                if (podeMover[1])
                                    handleCarro2.moveObjetos(carro2);

                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing())
                                    keepGoing = false;

                                checaPopUpChegou(1);
                                checaPopUpChegou(2);
                            }
                            else if(quantidadeDeCarros == 3)
                            {
                                if (podeMover[0])
                                    handleCarro1.moveObjetos(carro1);
                                if (podeMover[1])
                                    handleCarro2.moveObjetos(carro2);
                                if (podeMover[2])
                                    handleCarro3.moveObjetos(carro3);

                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() && !handleCarro3.isKeepGoing())
                                    keepGoing = false;

                                checaPopUpChegou(1);
                                checaPopUpChegou(2);
                                checaPopUpChegou(3);
                            }
                            else if(quantidadeDeCarros == 4)
                            {
                                if (podeMover[0])
                                    handleCarro1.moveObjetos(carro1);
                                if (podeMover[1])
                                    handleCarro2.moveObjetos(carro2);
                                if (podeMover[2])
                                    handleCarro3.moveObjetos(carro3);
                                if (podeMover[3])
                                    handleCarro4.moveObjetos(carro4);

                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() &&
                                        !handleCarro3.isKeepGoing() && !handleCarro4.isKeepGoing())
                                    keepGoing = false;

                                checaPopUpChegou(1);
                                checaPopUpChegou(2);
                                checaPopUpChegou(3);
                                checaPopUpChegou(4);
                            }
                            else
                            {
                                if (podeMover[0])
                                    handleCarro1.moveObjetos(carro1);
                                if (podeMover[1])
                                    handleCarro2.moveObjetos(carro2);
                                if (podeMover[2])
                                    handleCarro3.moveObjetos(carro3);
                                if (podeMover[3])
                                    handleCarro4.moveObjetos(carro4);
                                if (podeMover[4])
                                    handleCarro5.moveObjetos(carro5);

                                if(!handleCarro1.isKeepGoing() && !handleCarro2.isKeepGoing() &&
                                        !handleCarro3.isKeepGoing() && !handleCarro4.isKeepGoing() && !handleCarro5.isKeepGoing())
                                    keepGoing = false;

                                checaPopUpChegou(1);
                                checaPopUpChegou(2);
                                checaPopUpChegou(3);
                                checaPopUpChegou(4);
                                checaPopUpChegou(5);
                            }
                        }
                    });
                    tempo ++;
                }

            }catch (InterruptedException ex)
            {
                return;
            }
        }
    }

    public void checaPopUpChegou(int carro)
    {
        if(carro == 1)
        {
            if(!handleCarro1.isKeepGoing() && !popUpChegou1Exibido)
            {
                popUpChegou(1);
                popUpChegou1Exibido = true;
            }
        }
        else if(carro == 2)
        {
            if(!handleCarro2.isKeepGoing() && !popUpChegou2Exibido)
            {
                popUpChegou(2);
                popUpChegou2Exibido = true;
            }
        }
        else if(carro == 3)
        {
            if(!handleCarro3.isKeepGoing() && !popUpChegou3Exibido)
            {
                popUpChegou(3);
                popUpChegou3Exibido = true;
            }
        }
        else if(carro == 4)
        {
            if(!handleCarro4.isKeepGoing() && !popUpChegou4Exibido)
            {
                popUpChegou(4);
                popUpChegou4Exibido = true;
            }
        }
        else
        {
            if(!handleCarro5.isKeepGoing() && !popUpChegou5Exibido)
            {
                popUpChegou(5);
                popUpChegou5Exibido = true;
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

    public void habilitaRotasAleatórias()
    {
        origem.setDisable(true);
        destino.setDisable(true);
        ruaOrigem.setDisable(true);
        ruaDestino.setDisable(true);
    }

    public void habilitaRotasDefinidas()
    {
        origem.setDisable(false);
        destino.setDisable(false);
        ruaOrigem.setDisable(false);
        ruaDestino.setDisable(false);
    }

    public void rotasAleatorias()
    {
        for(int i=0; i < quantidadeDeCarros; i++)
        {
            if(rotasCalculadas == 0)
            {
                String ruaOrigemAleatoria = Aleatorio.randomizaRua();
                String ruaDestinoAleatorio = Aleatorio.randomizaRuaComExcecao(ruaOrigemAleatoria);

                handleCarro1 = new AreaPrincipalHandle(ruaOrigemAleatoria, ruaDestinoAleatorio);

                rotasCalculadas = 1;
                labelTituloRuas.setVisible(true);
                labelCor.setVisible(true);
                labelRuaDestino.setVisible(true);
                labelRuaOrigem.setVisible(true);
                ruaDeOrigem1.setText(ruaOrigemAleatoria);
                ruaDeOrigem1.setVisible(true);
                ruaDeDestino1.setText(ruaDestinoAleatorio);
                ruaDeDestino1.setVisible(true);
                iconeCarro1.setVisible(true);
                botaoDefinido.setDisable(true);
                botaoAleatorio.setDisable(true);
                botaoHabilitado.setDisable(true);
                botaoNaoHabilitado.setDisable(true);
                radioButton1.setDisable(true);
                radioButton2.setDisable(true);
                radioButton3.setDisable(true);
                radioButton4.setDisable(true);
                radioButton5.setDisable(true);
            }
            else if(rotasCalculadas == 1)
            {
                String ruaOrigemAleatoria = Aleatorio.randomizaRua();
                String ruaDestinoAleatorio = Aleatorio.randomizaRuaComExcecao(ruaOrigemAleatoria);

                handleCarro2 = new AreaPrincipalHandle(ruaOrigemAleatoria, ruaDestinoAleatorio);

                rotasCalculadas = 2;
                ruaDeOrigem2.setText(ruaOrigemAleatoria);
                ruaDeOrigem2.setVisible(true);
                ruaDeDestino2.setText(ruaDestinoAleatorio);
                ruaDeDestino2.setVisible(true);
                iconeCarro2.setVisible(true);
            }
            else if(rotasCalculadas == 2)
            {
                String ruaOrigemAleatoria = Aleatorio.randomizaRua();
                String ruaDestinoAleatorio = Aleatorio.randomizaRuaComExcecao(ruaOrigemAleatoria);

                handleCarro3 = new AreaPrincipalHandle(ruaOrigemAleatoria, ruaDestinoAleatorio);

                rotasCalculadas = 3;
                ruaDeOrigem3.setText(ruaOrigemAleatoria);
                ruaDeOrigem3.setVisible(true);
                ruaDeDestino3.setText(ruaDestinoAleatorio);
                ruaDeDestino3.setVisible(true);
                iconeCarro3.setVisible(true);
            }
            else if(rotasCalculadas == 3)
            {
                String ruaOrigemAleatoria = Aleatorio.randomizaRua();
                String ruaDestinoAleatorio = Aleatorio.randomizaRuaComExcecao(ruaOrigemAleatoria);

                handleCarro4 = new AreaPrincipalHandle(ruaOrigemAleatoria, ruaDestinoAleatorio);

                rotasCalculadas = 4;
                ruaDeOrigem4.setText(ruaOrigemAleatoria);
                ruaDeOrigem4.setVisible(true);
                ruaDeDestino4.setText(ruaDestinoAleatorio);
                ruaDeDestino4.setVisible(true);
                iconeCarro4.setVisible(true);
            }
            else if(rotasCalculadas == 4)
            {
                String ruaOrigemAleatoria = Aleatorio.randomizaRua();
                String ruaDestinoAleatorio = Aleatorio.randomizaRuaComExcecao(ruaOrigemAleatoria);

                handleCarro5 = new AreaPrincipalHandle(ruaOrigemAleatoria, ruaDestinoAleatorio);

                rotasCalculadas = 5;
                ruaDeOrigem5.setText(ruaOrigemAleatoria);
                ruaDeOrigem5.setVisible(true);
                ruaDeDestino5.setText(ruaDestinoAleatorio);
                ruaDeDestino5.setVisible(true);
                iconeCarro5.setVisible(true);
            }
            if(rotasCalculadas == quantidadeDeCarros)
            {
                botaoEnderecos.setDisable(true);
            }
            if(botaoEnderecos.isDisabled())
                botaoMostrarNoMapa.setDisable(false);
        }
    }

    public void sobre()
    {
        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource("PopUpSobre.fxml"));
        }catch (IOException ex)
        {
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void popUpChegou(int carro)
    {
        if(carro == 1)
        {
            {
                Parent root;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("PopUpChegou1.fxml"));
                }catch (IOException ex)
                {
                    return;
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            }
        }
        else if(carro == 2)
        {
            {
                Parent root;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("PopUpChegou2.fxml"));
                }catch (IOException ex)
                {
                    return;
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            }
        }
        else if(carro == 3)
        {
            {
                Parent root;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("PopUpChegou3.fxml"));
                }catch (IOException ex)
                {
                    return;
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            }
        }
        else if(carro == 4)
        {
            {
                Parent root;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("PopUpChegou4.fxml"));
                }catch (IOException ex)
                {
                    return;
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            }
        }
        else
        {
            {
                Parent root;
                try
                {
                    root = FXMLLoader.load(getClass().getResource("PopUpChegou5.fxml"));
                }catch (IOException ex)
                {
                    return;
                }
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    public void mostrarLegenda()
    {
        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource("LegendaMapa.fxml"));
        }catch (IOException ex)
        {
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void fecharLegenda()
    {
        Stage stage = (Stage) legendaMapa.getScene().getWindow();
        stage.close();
    }

    public void erroRua32()
    {
        Parent root;
        try
        {
            root = FXMLLoader.load(getClass().getResource("PAM.fxml"));
        }catch (IOException ex)
        {
            return;
        }
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public void fecharErro32()
    {
        Stage stage = (Stage) botaoFechaErro32.getScene().getWindow();
        stage.close();
    }

    public Button botaoEnderecos, botaoOk, botaoMostrarNoMapa, botaoFechaErro32;
    public RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;
    public ToggleButton botaoDefinido, botaoAleatorio, botaoHabilitado, botaoNaoHabilitado;
    public ToggleGroup radioButtonGroup, toggleButton1Group, toggleButton2Group;
    public Pane layoutAnimacao;
    public HBox menuInferior;
    public VBox layout;
    public Label origem, destino, feitoPor, ruaDeOrigem1, ruaDeOrigem2, ruaDeOrigem3, ruaDeOrigem4, ruaDeOrigem5, labelTituloRuas;
    public Label ruaDeDestino1, ruaDeDestino2, ruaDeDestino3, ruaDeDestino4, ruaDeDestino5, labelCor, labelRuaOrigem, labelRuaDestino;
    public TextField ruaOrigem, ruaDestino;
    public ImageView mapaCidade,miniMapa, legendaMapa, carro1, carro2, carro3, carro4, carro5;
    public ImageView iconeCarro1, iconeCarro2, iconeCarro3, iconeCarro4, iconeCarro5;
    public StackPane stackAnimacao;
    public Stage avisoErro;
    public AreaPrincipalHandle handleCarro1, handleCarro2, handleCarro3, handleCarro4, handleCarro5;
    public boolean keepGoing = true, rotasDefinidas = true, semaforosHabilitados = true;
    public boolean popUpChegou1Exibido = false, popUpChegou2Exibido = false, popUpChegou3Exibido = false,
            popUpChegou4Exibido = false, popUpChegou5Exibido = false;
    public int quantidadeDeCarros = 1, rotasCalculadas = 0;
    public Menu menuArquivo, menuAjuda;
    public MenuItem itemNovo, itemFechar, itemSobre;
    public MenuBar menuBar;
    public ImageView semaforo1, semaforo2, semaforo3, semaforo4, semaforo5, semaforo6, semaforo7, semaforo8, semaforo9,
            semaforo10, semaforo11, semaforo12, semaforo13, semaforo14, semaforo15, semaforo16, semaforo17, semaforo18,
            semaforo19, semaforo20, semaforo21, semaforo22, semaforo23, semaforo24, semaforo25, semaforo26, semaforo27,
            semaforo28, semaforo29, semaforo30, semaforo31, semaforo32, semaforo33, semaforo34, semaforo35, semaforo36,
            semaforo37, semaforo38, semaforo39, semaforo40, semaforo41, semaforo42, semaforo43, semaforo44, semaforo45,
            semaforo46, semaforo47, semaforo48, semaforo49, semaforo50, semaforo51, semaforo52, semaforo53, semaforo54,
            semaforo55, semaforo56, semaforo57, semaforo58, semaforo59, semaforo60, semaforo61, semaforo62, semaforo63,
            semaforo64, semaforo65, semaforo66, semaforo67, semaforo68, semaforo69, semaforo70, semaforo71, semaforo72,
            semaforo73, semaforo74, semaforo75, semaforo76, semaforo77, semaforo78, semaforo79, semaforo80, semaforo81,
            semaforo82, semaforo83, semaforo84, semaforo85, semaforo86, semaforo87, semaforo88, semaforo89, semaforo90,
            semaforo91, semaforo92, semaforo93, semaforo94, semaforo95, semaforo96, semaforo97, semaforo98, semaforo99,
            semaforo100, semaforo101, semaforo102, semaforo103, semaforo104, semaforo105, semaforo106, semaforo107, semaforo108,
            semaforo109, semaforo110, semaforo111, semaforo112, semaforo113, semaforo114, semaforo115, semaforo116, semaforo117,
            semaforo118, semaforo119, semaforo120;
    protected ArrayList <Interseccao> listaDeInteseccao;
    protected ArrayList <ImageView> vetorDeImagensDoSemaforo;
}
