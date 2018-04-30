import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.text.Element;

public class Main extends Application
{
    public static void main (String argv[])
    {
        launch(argv);
        int i;

        GPS gps = new GPS("definido");

        AutoPilot tesla = new AutoPilot(gps.getMenorRota(), gps.getArestasDefinitivas(), "definido");

        System.out.print("Arestas Definitivas" + gps.getArestasDefinitivas().get(0).getOrigem() + " e " + gps.getArestasDefinitivas().get(1).getDestino() + "\n");

        gps.exibirMenorRota();

        //Exibir o mundo com os 4 quadrantes funcionando
        ///criação do objeto mundo
        Mundo meuMundo = new Mundo();

        ///criação do objeto padrao de coordenadas de semaforos
        CoordenadasSemaforos coordenadas = new CoordenadasSemaforos();

        ///criação da lista que armazena os objetos semaforos do Q1
        ArrayList <Semaforo> semaforosQ1 = new ArrayList<>();

        ///criação da lista que armazena os objetos semaforos do Q2
        ArrayList <Semaforo> semaforosQ2 = new ArrayList<>();
      
        ///criação da lista que armazana os objetos semaforos do Q3
        ArrayList <Semaforo> semaforosQ3 = new ArrayList<>();
      
        ///criação da lista que armazana os objetos semaforos do Q4
        ArrayList <Semaforo> semaforosQ4 = new ArrayList<>();

        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q1
        for (i=0; i < coordenadas.getSizeQ1(); i++)
        {
            semaforosQ1.add(new Semaforo(coordenadas.getCoordenadasXQ1(i), coordenadas.getCoordenadasYQ1(i), coordenadas.getVerdeQ1(i)));
        }
      
        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q2
        for (i=0; i < coordenadas.getSizeQ2(); i++)
        {
            semaforosQ2.add(new Semaforo(coordenadas.getCoordenadasXQ2(i), coordenadas.getCoordenadasYQ2(i), coordenadas.getVerdeQ2(i)));
        }

        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q3
        for (i=0; i < coordenadas.getSizeQ3(); i++)
        {
            semaforosQ3.add(new Semaforo(coordenadas.getCoordenadasXQ3(i), coordenadas.getCoordenadasYQ3(i), coordenadas.getVerdeQ3(i)));
        }

        ///adiciona os objetos semaforos com as coordenadas padrão na lista do Q4
        for (i=0; i < coordenadas.getSizeQ4(); i++)
        {
            semaforosQ4.add(new Semaforo(coordenadas.getCoordenadasXQ4(i), coordenadas.getCoordenadasYQ4(i), coordenadas.getVerdeQ4(i)));
        }

/*
        List <AutoPilot> veiculosAleatorios = new ArrayList<>();

        List <GPS> GPSsParaVeiculosAleatorios = new ArrayList<>();

        for(i=0; i < 10; i++)
        {
            GPSsParaVeiculosAleatorios.add(new GPS("aleatorio"));
            veiculosAleatorios.add(new AutoPilot(GPSsParaVeiculosAleatorios.get(i).getMenorRota(),
                    GPSsParaVeiculosAleatorios.get(i).getArestasDefinitivas(), "aleatorio"));
        }
*/

        ///boleano que gerencia se os veiculos entrados pelo usuario chegaram ao destino final
        boolean cheguei = false;

        ///loop infinito de execução do programa
        while (true)
        {
            ///loop de execução enquanto os veiculos nao chegam ao destino
            while (!tesla.getCheguei())
            {
                ///popula os semaforos do Q1 no mundo
                for (i=0; i < semaforosQ1.size(); i++)
                {
                    meuMundo.populaSemaforoQ1(semaforosQ1.get(i));
                }

                ///popula os semaforos do Q2 no mundo
                for (i=0; i < semaforosQ2.size(); i++)
                {
                    meuMundo.populaSemaforoQ2(semaforosQ2.get(i));
                }
                ///popula os semaforos do Q3 no mundo
                for (i=0; i < semaforosQ3.size(); i++)
                {
                    meuMundo.populaSemaforoQ3(semaforosQ3.get(i));
                }  
                ///popula os semaforos do Q4 no mundo
                for (i=0; i < semaforosQ4.size(); i++)
                {
                    meuMundo.populaSemaforoQ4(semaforosQ4.get(i));
                }


                meuMundo.insereVeiculoNoMundo(tesla.getX(), tesla.getY(), tesla.getQuadranteAtual(), tesla.getID());
/*
                for(i=0; i < 10; i++)
                {
                    meuMundo.insereVeiculoNoMundo(veiculosAleatorios.get(i).getX(), veiculosAleatorios.get(i).getY(),
                            veiculosAleatorios.get(i).getQuadranteAtual(), veiculosAleatorios.get(i).getID());
                }


                ///desenha o mundo com os quadrantes 1 e 2
                meuMundo.desenhaMundo(meuMundo.getMundoQ1(), meuMundo.getMundoQ2());
                ///desenha o mundo com os quadrantes 3 e 4
                meuMundo.desenhaMundo(meuMundo.getMundoQ3(), meuMundo.getMundoQ4());
                ///pausa a execução do programa pelo tempo determinado
                meuMundo.pausaMundo();
                meuMundo.reiniciaMundos();

*/
/**/
                System.out.printf("X e Y\n");
                System.out.print(tesla.getX() + " " + tesla.getY() + "\n");
                System.out.printf("X final e Y final\n");
                System.out.print(tesla.getxDestino() + " " + tesla.getyDestino() + "\n");
                System.out.printf("Quadrante\n");
                System.out.print(tesla.getQuadranteAtual() + "\n\n");
/**/

                tesla.move();
/*

                for(i=0; i < 10; i++)
                {
                    if(veiculosAleatorios.get(i).getCheguei())
                    {
                        veiculosAleatorios.remove(i);
                        GPSsParaVeiculosAleatorios.remove(i);
                        GPSsParaVeiculosAleatorios.add(new GPS("aleatorio"));
                        veiculosAleatorios.add(new AutoPilot(GPSsParaVeiculosAleatorios.get(i).getMenorRota(),
                                GPSsParaVeiculosAleatorios.get(i).getArestasDefinitivas(), "aleatorio"));
                    }
                    veiculosAleatorios.get(i).move();
                }
*/
                meuMundo.voltaComeco();
            }
        }

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException
    {
        window = primaryStage;
        window.setTitle("Ruas Inteligentes - Trabalho Final Orientação a Objetos");

        botaoEnderecos = new Button("Mostrar Rota");
        botaoEnderecos.setOnAction(e -> pegaRuas());
        origem = new Label("Origem");
        destino = new Label("Destino");
        feitoPor = new Label("Feito por: Éverton Cardoso Acchetta");

        ruaOrigem = new TextField();
        ruaOrigem.setPromptText("Rua X");

        ruaDestino = new TextField();
        ruaDestino.setPromptText("Rua Y");

        menuSuperior = new HBox(10);
        menuSuperior.getChildren().addAll(origem, ruaOrigem, destino, ruaDestino, botaoEnderecos);
        menuSuperior.setAlignment(Pos.CENTER);
        menuSuperior.setPadding(new Insets(10,10,10,10));

        layoutAnimacao = new Pane();
        layoutAnimacao.setMinHeight(600);
        layoutAnimacao.setMinWidth(600);

        imagem = new Image(new FileInputStream("Image/Imagem.png"));
        mapaCidade = new ImageView(imagem);

        stackAnimacao = new StackPane();
        stackAnimacao.getChildren().add(mapaCidade);

        layoutAnimacao.getChildren().add(stackAnimacao);

        menuInferior = new HBox(10);
        menuInferior.getChildren().addAll(feitoPor);
        menuInferior.setPadding(new Insets(10,10,10,10));
        menuInferior.setAlignment(Pos.CENTER_RIGHT);

        layout = new VBox(10);
        layout.getChildren().addAll(menuSuperior, layoutAnimacao, menuInferior);

        scene = new Scene(layout);
        window.setScene(scene);
        window.show();

    }

    public static void pegaRuas()
    {
        ruaDeOrigem = ruaOrigem.getText();
        ruaDeDestino = ruaDestino.getText();
        System.out.println(ruaDeOrigem + " e " + ruaDeDestino);
    }

    public static Stage window;
    public static Scene scene;
    public static Button botaoEnderecos;
    public static Pane layoutAnimacao;
    public static HBox menuSuperior, menuInferior;
    public static VBox layout;
    public static Label origem, destino, feitoPor;
    public static TextField ruaOrigem, ruaDestino;
    public static String ruaDeOrigem, ruaDeDestino;
    public static ImageView mapaCidade;
    public static StackPane stackAnimacao;
    public static Image imagem;
}
