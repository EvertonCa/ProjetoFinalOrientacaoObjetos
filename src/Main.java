import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {

        GPS gps = new GPS();

        AutoPilot tesla = new AutoPilot(gps.getMenorRota(), gps.getArestasDefinitivas());

        System.out.print("Arestas Definitivas" + gps.getArestasDefinitivas().get(0).getOrigem() + " e " + gps.getArestasDefinitivas().get(1).getDestino() + "\n");

        gps.exibirMenorRota();

        int i=0;

        while(!tesla.getCheguei() || i < 20)
        {
            tesla.move(false);
            System.out.printf("\nX e Y inicial:\n");
            System.out.print(tesla.getX() + " " + tesla.getY() + "\n");
            System.out.printf("X e Y destino:\n");
            System.out.print(tesla.getxDestino() + " " + tesla.getyDestino() + "\n");
            i++;
        }

    }
}
