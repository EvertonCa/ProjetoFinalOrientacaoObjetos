public class Mundo
{
    public Mundo()
    {
        reiniciaMundo();
    }

    public void reiniciaMundo()
    {
        mundoQ1 = new int[][] //60x60 primeiro quadrante / 31 semaforos / 13 cruzamentos
                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{0,0,0,0,0,0,0,0,0,0,10,10,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,11,11,11,11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,12,12,12,12,12}
                ,{6,6,6,6,6,6,6,6,6,6,10,10,10,10,10,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,11,11,11,11,11,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,12,12,12,12,12}
                ,{2,2,2,2,0,0,2,2,2,2,10,10,10,10,10,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,11,11,11,11,11,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,12,12,12,12,12}
                ,{5,5,5,5,5,5,5,5,5,5,10,10,10,10,10,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,11,11,11,11,11,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,12,12,12,12,12}
                ,{0,0,0,0,0,0,0,0,0,0,10,10,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,11,11,11,11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,12,12,12,12,12}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{0,0,0,0,0,0,0,0,0,0,13,13,13,13,13,0,0,0,0,0,0,0,0,0,14,14,14,14,14,0,0,0,0,0,0,15,15,15,15,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,16,16,16,16}
                ,{6,6,6,6,6,6,6,6,6,6,13,13,13,13,13,6,6,6,6,6,6,6,6,6,14,14,14,14,14,6,6,6,6,6,6,15,15,15,15,15,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,16,16,16,16,16}
                ,{2,2,2,2,0,0,2,2,2,2,13,13,13,13,13,2,2,2,2,0,0,2,2,2,14,14,14,14,14,0,0,2,2,2,2,15,15,15,15,15,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,16,16,16,16,16}
                ,{5,5,5,5,5,5,5,5,5,5,13,13,13,13,13,5,5,5,5,5,5,5,5,5,14,14,14,14,14,5,5,5,5,5,5,15,15,15,15,15,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,16,16,16,16,16}
                ,{0,0,0,0,0,0,0,0,0,0,13,13,13,13,13,0,0,0,0,0,0,0,0,0,14,14,14,14,14,0,0,0,0,0,0,15,15,15,15,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16,16,16,16,16}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,5,2,5,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0}
                ,{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,17,17,17,17,0,0,0,0,0,0,0,0,0,0,0,18,18,18,18,18,0,0,0,0,0,0,0,0,0,0,19,19,19,19,19}
                ,{6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,17,17,1,17,17,6,6,6,6,6,6,6,6,6,6,6,18,18,18,18,18,6,6,6,6,6,6,6,6,6,6,19,19,19,19,19}
                ,{0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,17,1,1,1,17,0,2,2,2,2,0,0,2,2,2,2,18,18,18,18,18,2,2,2,2,0,0,2,2,2,2,19,19,19,19,19}
                ,{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,17,17,1,17,17,5,5,5,5,5,5,5,5,5,5,5,18,18,18,18,18,5,5,5,5,5,5,5,5,5,5,19,19,19,19,19}
                ,{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,17,17,17,17,17,0,0,0,0,0,0,0,0,0,0,0,18,18,18,18,18,0,0,0,0,0,0,0,0,0,0,19,19,19,19,19}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,5,2,5,0,0,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,21,21,21,21,21,0,0,0,0,0,0,0,0,0,0,0,22,22,22,22,22,0,0,0,0,0,0,0,0,0,0,0,0,23,23,23,23,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                ,{1,1,1,1,1,1,1,21,21,21,21,21,6,6,6,6,6,6,6,6,6,6,6,22,22,22,22,22,6,6,6,6,6,6,6,6,6,6,6,6,23,23,23,23,23,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}
                ,{1,1,1,1,1,1,1,21,21,21,21,21,2,2,2,2,0,0,2,2,2,2,0,22,22,22,22,22,2,2,2,2,0,0,2,2,2,2,0,0,23,23,23,23,23,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2}
                ,{1,1,1,1,1,1,1,21,21,21,21,21,5,5,5,5,5,5,5,5,5,5,5,22,22,22,22,22,5,5,5,5,5,5,5,5,5,5,5,5,23,23,23,23,23,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}
                ,{1,1,1,1,1,1,1,21,21,21,21,21,0,0,0,0,0,0,0,0,0,0,0,23,22,22,22,22,0,0,0,0,0,0,0,0,0,0,0,0,23,23,23,23,23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                ,{1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{0,0,0,0,0,0,0,20,20,20,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{6,6,6,6,6,6,6,20,20,20,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{2,0,0,2,2,2,2,20,20,20,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{5,5,5,5,5,5,5,20,20,20,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                ,{0,0,0,0,0,0,0,20,20,20,20,20,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

        mundoQ2 = new int[][] //60x60 quarto quadrante / 28 semaforos / 11 cruzamentos
                {
                         {1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{0,0,0,0,0,0,0,0,0,30,30,30,30,30,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{6,6,6,6,6,6,6,6,6,30,30,30,30,30,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,31,31,31,31,31,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{2,2,2,0,0,2,2,2,2,30,30,30,30,30,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2,2,0,0,2,31,31,31,31,31,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{5,5,5,5,5,5,5,5,5,30,30,30,30,30,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,31,31,31,31,31,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{0,0,0,0,0,0,0,0,0,30,30,30,30,30,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,31,31,31,31,31,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,5,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,32,32,32,32,32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,33,33,33,0,0,0,0,5,0,34,34,34,34,34,0,0,0,35,35,35,35,35,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,32,32,32,32,32,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,33,33,33,33,33,6,6,6,6,6,6,34,34,34,34,34,6,6,6,35,35,35,35,35,6,6,6}
                        ,{1,1,1,1,1,1,1,1,1,32,32,32,32,32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,33,33,33,33,33,0,0,0,0,0,0,34,34,34,34,34,5,0,0,35,35,35,35,35,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,36,36,36,36,36,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,36,36,36,36,36,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,36,36,36,36,36,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,36,36,36,36,36,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,36,36,36,36,36,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,0,8,2,5,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1}
                        ,{0,0,0,0,0,0,0,0,0,37,37,37,37,37,0,0,0,0,0,0,0,0,0,0,38,38,38,38,38,0,0,0,0,0,0,0,0,0,0,0,39,39,39,39,39,0,0,0,0,0,0,0,40,40,40,40,40,0,0,0}
                        ,{6,6,6,6,6,6,6,6,6,37,37,37,37,37,6,6,6,6,6,6,6,6,6,6,38,38,38,38,38,6,6,6,6,6,6,6,6,6,6,6,39,39,39,39,39,6,6,6,6,6,6,6,40,40,40,40,40,6,6,6}
                        ,{2,2,2,0,0,2,2,2,2,37,37,37,37,37,2,2,2,2,0,0,2,2,2,2,38,38,38,38,38,2,2,2,2,0,0,2,2,2,2,0,39,39,39,39,39,2,2,2,2,0,0,2,40,40,40,40,40,0,2,2}
                        ,{5,5,5,5,5,5,5,5,5,37,37,37,37,37,5,5,5,5,5,5,5,5,5,5,38,38,38,38,38,5,5,5,5,5,5,5,5,5,5,5,39,39,39,39,39,5,5,5,5,5,5,5,40,40,40,40,40,5,5,5}
                        ,{0,0,0,0,0,0,0,0,0,37,37,37,37,37,0,0,0,0,0,0,0,0,0,0,38,38,38,38,38,0,0,0,0,0,0,0,0,0,0,0,39,39,39,39,39,0,0,0,0,0,0,0,40,40,40,40,40,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}
                        ,{1,1,1,1,1,1,1,1,1,0,8,0,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,2,2,2,2,0,0,2,2,2,2,0,0,2,2,2}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}
                        ,{1,1,1,1,1,1,1,1,1,0,8,2,7,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,41,41,41,41,41,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
                };
    }

    public void desenhaMundo(int[][] q1, int[][] q2)
    {
        for (int i = 0; i < 60; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                desenhaLinha(q1, i, j);
            }

            for (int j = 0; j < 60; j++)
            {
                desenhaLinha(q2, i, j);
            }

            System.out.printf("\n");
        }
    }

    public void desenhaLinha(int[][] quadrante, int i, int j)
    {
        if(quadrante[i][j] == 1) //quarteirao - azul
        {
            System.out.printf("\33[7;34m  \33[0m");
        }

        else if(quadrante[i][j] == 0) //rua - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }

        else if(quadrante[i][j] == 2) //faixa - branca
        {
            System.out.printf("\33[7;37m  \33[0m");
        }

        else if(quadrante[i][j] == 3) //semarofo - vermelho
        {
            System.out.printf("\33[7;31m  \33[0m");
        }

        else if(quadrante[i][j] == 4) //semaforo - verde
        {
            System.out.printf("\33[7;32m  \33[0m");
        }

        else if(quadrante[i][j] == 5) //caminho possivel para o carro para direita - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }

        else if(quadrante[i][j] == 6) //caminho possivel para o carro para esquerda - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }

        else if(quadrante[i][j] == 7) //caminho possivel para o carro para cima - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }

        else if(quadrante[i][j] == 8) //caminho possivel para o carro para baixo - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }

        else if(quadrante[i][j] == 9) //carros - ciano
        {
            System.out.printf("\33[7;36m  \33[0m");
        }

        else if(quadrante[i][j] >= 10 && quadrante[i][j] <= 99) //caminho possivel para o carro para baixo - preta
        {
            System.out.printf("\33[7;30m  \33[0m");
        }
    }

    public void voltaComeco()
    {
        for (int i = 0; i < 60; i++)
        {
            System.out.printf("\33[A");
        }
    }

    public void populaSemaforoQ1(Semaforo farol)
    {
        if(farol.getVerde() == true)
        {
            mundoQ1[farol.getX()][farol.getY()] = 4;
        }
        else
        {
            mundoQ1[farol.getX()][farol.getY()] = 3;
        }
    }

    public void pausaMundo()
    {
        try
        {
            Thread.sleep(50000); //funcao para dar uma pequena pausa
        }
        catch (InterruptedException e) { }
    }

    public int getLocalizacao(int quadrante, int x, int y)
    {
        if(quadrante == 1)
        {
            return mundoQ1[x][y];
        }

        else if (quadrante == 2)
        {
            return mundoQ2[x][y];
        }

        else if (quadrante == 3)
        {
            return mundoQ3[x][y];
        }

        else
        {
            return mundoQ4[x][y];
        }
    }

    public int[][] getMundoQ1()
    {
        return mundoQ1;
    }

    public int[][] getMundoQ2()
    {
        return mundoQ2;
    }

    public int[][] getMundoQ3()
    {
        return mundoQ3;
    }

    public int[][] getMundoQ4()
    {
        return mundoQ4;
    }

    protected int mundoQ1[][], mundoQ2[][], mundoQ3[][], mundoQ4[][];
}
