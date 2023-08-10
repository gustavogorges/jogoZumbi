import Personagens.Pelotao.*;
import Personagens.Personagem;
import Personagens.Zumbis.Forte;
import Personagens.Zumbis.Fraco;
import Personagens.Zumbis.Normal;
import Personagens.Zumbis.Zumbi;

import java.util.ArrayList;
import java.util.Scanner;

public class Fases { // fazer um objeto fase e passar todos os souts para o main
    static Scanner sc = new Scanner(System.in);

    public static Zumbi zumbiRandom1(ArrayList<Zumbi> grupo1) {
        double randomZumbiNumber = Math.random() * grupo1.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo1.get(truncadoZumbi);
    }

    public static Zumbi zumbiRandom2(ArrayList<Zumbi> grupo2) {
        double randomZumbiNumber;
        randomZumbiNumber = Math.random() * grupo2.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo2.get(truncadoZumbi);
    }

    public static Zumbi zumbiRandom3(ArrayList<Zumbi> grupo3) {
        double randomZumbiNumber;
        randomZumbiNumber = Math.random() * grupo3.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo3.get(truncadoZumbi);
    }

    public static Soldado soldadoRandom(ArrayList<Soldado> pelotao) {
        double randomSoldadoNumber;
        randomSoldadoNumber = Math.random() * pelotao.size();
        int truncadoSoldado = (int)randomSoldadoNumber;

        return pelotao.get(truncadoSoldado);
    }



    public static boolean pelotaoVivo(ArrayList<Soldado> pelotao) {
        for (Soldado soldadoFor : pelotao) {
            if(soldadoFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo1(ArrayList<Zumbi> grupo1) {
        for (Zumbi zumbiFor : grupo1) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo2(ArrayList<Zumbi> grupo2) {
        for (Zumbi zumbiFor : grupo2) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo3(ArrayList<Zumbi> grupo3) {
        for (Zumbi zumbiFor : grupo3) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }




}
