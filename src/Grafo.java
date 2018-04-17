import java.util.ArrayList;

public class Grafo
{
    public Grafo()
    {
        grafosQ1();
    }

    public void grafosQ1()
    {
        grafoMundo.get(0).add(new Vertice(1, 20, verticeVsInterseccao[0], verticeVsInterseccao[1]));
        grafoMundo.get(0).add(new Vertice(3, 10, verticeVsInterseccao[0], verticeVsInterseccao[3]));
        grafoMundo.get(1).add(new Vertice(0, 20, verticeVsInterseccao[1], verticeVsInterseccao[0]));
        grafoMundo.get(1).add(new Vertice(2, 15, verticeVsInterseccao[1], verticeVsInterseccao[2]));
        grafoMundo.get(1).add(new Vertice(5, 10, verticeVsInterseccao[1], verticeVsInterseccao[5]));
        grafoMundo.get(3).add(new Vertice(0, 10, verticeVsInterseccao[3], verticeVsInterseccao[0]));
        grafoMundo.get(3).add(new Vertice(4, 9, verticeVsInterseccao[3], verticeVsInterseccao[4]));
        grafoMundo.get(4).add(new Vertice(3, 9, verticeVsInterseccao[4], verticeVsInterseccao[3]));
        grafoMundo.get(4).add(new Vertice(5, 6, verticeVsInterseccao[4], verticeVsInterseccao[5]));
        grafoMundo.get(4).add(new Vertice(7, 10, verticeVsInterseccao[4], verticeVsInterseccao[7]));
        grafoMundo.get(5).add(new Vertice(4, 6, verticeVsInterseccao[5], verticeVsInterseccao[4]));
        grafoMundo.get(5).add(new Vertice(1, 10, verticeVsInterseccao[5], verticeVsInterseccao[1]));
        grafoMundo.get(5).add(new Vertice(6, 15, verticeVsInterseccao[5], verticeVsInterseccao[6]));
        grafoMundo.get(6).add(new Vertice(2, 10, verticeVsInterseccao[6], verticeVsInterseccao[2]));
        grafoMundo.get(6).add(new Vertice(5, 15, verticeVsInterseccao[6], verticeVsInterseccao[5]));
        grafoMundo.get(6).add(new Vertice(9, 10, verticeVsInterseccao[6], verticeVsInterseccao[9]));
        grafoMundo.get(7).add(new Vertice(4, 10, verticeVsInterseccao[7], verticeVsInterseccao[4]));
        grafoMundo.get(7).add(new Vertice(8, 11, verticeVsInterseccao[7], verticeVsInterseccao[8]));
        grafoMundo.get(7).add(new Vertice(12, 10, verticeVsInterseccao[7], verticeVsInterseccao[12]));
        grafoMundo.get(8).add(new Vertice(7, 11, verticeVsInterseccao[8], verticeVsInterseccao[7]));
        grafoMundo.get(8).add(new Vertice(9, 10, verticeVsInterseccao[8], verticeVsInterseccao[9]));
        grafoMundo.get(8).add(new Vertice(13, 10, verticeVsInterseccao[8], verticeVsInterseccao[13]));
        grafoMundo.get(9).add(new Vertice(6, 10, verticeVsInterseccao[9], verticeVsInterseccao[6]));
        grafoMundo.get(9).add(new Vertice(8, 10, verticeVsInterseccao[9], verticeVsInterseccao[8]));
        grafoMundo.get(10).add(new Vertice(11, 4, verticeVsInterseccao[10], verticeVsInterseccao[11]));
        grafoMundo.get(11).add(new Vertice(10, 4, verticeVsInterseccao[11], verticeVsInterseccao[10]));
        grafoMundo.get(11).add(new Vertice(12, 11, verticeVsInterseccao[11], verticeVsInterseccao[12]));
        grafoMundo.get(12).add(new Vertice(11, 11, verticeVsInterseccao[12], verticeVsInterseccao[11]));
        grafoMundo.get(12).add(new Vertice(7, 10, verticeVsInterseccao[12], verticeVsInterseccao[7]));
        grafoMundo.get(12).add(new Vertice(13, 12, verticeVsInterseccao[12], verticeVsInterseccao[13]));
        grafoMundo.get(13).add(new Vertice(12, 12, verticeVsInterseccao[13], verticeVsInterseccao[12]));

    }

    protected ArrayList <ArrayList <Vertice> > grafoMundo = new ArrayList<>(60);
    protected int[] verticeVsInterseccao = {10,11,12,13,14,15,16,17,18,19,20,21,22,23};
}
