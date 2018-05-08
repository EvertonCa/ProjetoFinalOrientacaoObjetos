import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main
{
    public static List<Interseccao> criaInterseccao()
    {
        List<Interseccao> listaInterseccoes = new ArrayList<Interseccao>();
        try
        {
            for (int k = 0; k < 1; k ++)
            {


                Manipulador manip = new Manipulador();
                Properties prop;

//            switch (i)
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
//                    break;
//                }
//
//                case 3:
//                {
//                    prop = manip.getInterseccoesQ3();
//                    break;
//                }
//
//                case 4:
//                {
//                    prop = manip.getInterseccoesQ4();
//                    break;
//                }
//
//            }
                prop = manip.getInterseccoesQ1();

                int quantidadeDeInterseccoes = Integer.parseInt(prop.getProperty("quantidadeDeInterseccoes"));
                int quandrante = Integer.parseInt(prop.getProperty("quadrante"));

                for(int i = 0; i < quantidadeDeInterseccoes; i++)
                {
                    int descricao = Integer.parseInt(prop.getProperty("interseccao" + i + "Descricao"));
                    int quantidadeDeSemaforos = Integer.parseInt(prop.getProperty("interseccao" + i + "QuantidadeDeSemaforos"));
                    List <Semaforo> semaforosDaInterseccao = new ArrayList<Semaforo>();

                    for (int j = 0; j < quantidadeDeSemaforos; j++)
                    {
                        int x = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoX" + j));
                        int y = Integer.parseInt(prop.getProperty("interseccao" + i + "CoordenadaSemaforoY" + j));
                        boolean verde = Boolean.parseBoolean(prop.getProperty("interseccao" + i + "SituacaoSemaforo" + j));

                        int duracao = Integer.parseInt(prop.getProperty("interseccao" + i + "DuracaoSemaforo"));

                        semaforosDaInterseccao.add(new Semaforo(x, y, verde, duracao));
                    }
                    listaInterseccoes.add(new Interseccao(semaforosDaInterseccao, descricao, quandrante));
                }
            }
        }catch (IOException e){System.out.println("Erro no arquivo de propriedades");}

        return listaInterseccoes;
    }

    public static void main (String argv[])
    {
        ///criação do objeto mundo
        Mundo meuMundo = new Mundo();

        List <Interseccao> listaInterseccoes = criaInterseccao();


        while(true)
        {
            meuMundo.populaInterseccao(listaInterseccoes);

            for (int i = 0; i < listaInterseccoes.size(); i++)
            {
                listaInterseccoes.get(i).verificaSemaforo(meuMundo.mundoQ1);
            }

            meuMundo.desenhaMundo(meuMundo.getMundoQ1());
            System.out.println("");

            meuMundo.pausaMundo();
        }
    }
}
