import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Interseccao {
    Interseccao()
    {

    }

    public void criaInterseccao(int quadrante)
    {
        try
        {
            List <Semaforo> semaforos = new ArrayList<Semaforo>();

            Manipulador manip = new Manipulador();
            Properties prop;

//            switch (quadrante)
//            {
//                default:
//                {
//                    prop = manip.getInterseccoesQ1();
//                    break;
//                }
//
//                case 2:
//                {
//                    prop = manip.getInterseccoesQ2();
//                    arestasQ2 = arestas;
//                    break;
//                }
//
//                case 3:
//                {
//                    prop = manip.getArestasQ3();
//                    arestasQ3 = arestas;
//                    break;
//                }
//
//                case 4:
//                {
//                    prop = manip.getArestasQ4();
//                    arestasQ4 = arestas;
//                    break;
//                }
//
//            }

            prop = manip.getInterseccoesQ1();


            int quantidadeDeInterseccoes = Integer.parseInt(prop.getProperty("quantidadeDeInterseccoes"));

            for(int i = 0; i < quantidadeDeInterseccoes; i++)
            {
                int descricao = Integer.parseInt("interseccao" + i + "Descricao");
                int quantidadeDeSemaforos = Integer.parseInt(prop.getProperty("interseccao" + i + "QuantidadeDeSemaforos"));

                for (int j = 0; j < quantidadeDeSemaforos; j++)
                {
                    int x = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoX" + j));
                    int y = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoY" + j));
                    boolean verde = Boolean.getBoolean(prop.getProperty("interseccao" + i + "SituacaoSemaforo" + j));
                    int duracao = Integer.parseInt("interseccao" + i + "DuracaoSemaforo");

                    //semaforos.add(new Semaforo(x, y, verde, duracao));
                }
            }

        }catch (IOException e){System.out.println("Erro no arquivo de propriedades Quadrante " + quadrante);}
    }

}
