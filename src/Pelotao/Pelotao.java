package Pelotao;

import java.util.ArrayList;

public class Pelotao {
    public static ArrayList<Soldado> pelotao = new ArrayList<>();
    public static void novoPelotao() {
        Soldado assalto = new Assalto("assalto",100,45,20,true,true);
        pelotao.add(assalto);
        Soldado suporte = new Suporte("suporte",110,25,1,true,true);
        pelotao.add(suporte);
        Soldado medico = new Medico("medico",90,30,60,true,true);
        pelotao.add(medico);
        Soldado batedor = new Batedor("batedor",90,100,999,true,true);
        pelotao.add(batedor);


    }
}
