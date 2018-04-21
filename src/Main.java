import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String argv[])
    {
        GPS gps = new GPS();

        List <Vertice> menorRota = new ArrayList<Vertice>();

        menorRota = gps.getMenorRota();

        for(int i = 0; i < menorRota.size(); i++)
        {
            System.out.print(menorRota.get(i));
            System.out.printf(" -> ");
        }
    }
}