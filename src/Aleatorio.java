/**
/ Classe responsável pela criação de ruas de origem, destino e IDs aleatórios
 **/

import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{

    /// Retorna uma Rua de Origem aleatória
    public static String randomizaRua()
    {
        String rua;
        int numero;

        numero = ThreadLocalRandom.current().nextInt(0,90);

        rua = "Rua " + numero;
        return rua;
    }

    /// Retorna uma Rua de Destino aleatória que não seja igual a rua de Origem ou a Rua 32
    public static String randomizaRuaComExcecao(String excecao)
    {
        String rua = randomizaRua();

        while (rua.equals(excecao) || rua.equals("Rua 32"))
        {
            rua = randomizaRua();
        }

        return rua;
    }

    ///volta um número aleatório entre 100 e 300000
    public static int randomizeID()
    {
        int id = ThreadLocalRandom.current().nextInt(100,300000);
        return id;
    }

    public static int randomizeIDParaAleatorios()
    {
        int id = ThreadLocalRandom.current().nextInt(300001,600000);
        return id;
    }

}
