import Pelotao.Pelotao;
import Pelotao.Soldado;
import Zumbis.Forte;
import Zumbis.Fraco;
import Zumbis.Normal;
import Zumbis.Zumbi;

import java.util.ArrayList;
import java.util.Scanner;

public class Fases {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Zumbi> grupo1 = new ArrayList<>();
    static ArrayList<Zumbi> grupo2 = new ArrayList<>();
    static ArrayList<Zumbi> grupo3 = new ArrayList<>();

    public static void fase1()  {
        Zumbi zumbiFraco1 = new Fraco("fraco",50,20,true);
        grupo1.add(zumbiFraco1);
        Zumbi zumbiFraco2 = new Fraco("fraco",50,20,true);
        grupo2.add(zumbiFraco2);
        Zumbi zumbiNormal = new Normal("normal",80,50,true);
        grupo3.add(zumbiNormal);

        Pelotao.novoPelotao();

        do {
            escolhaJogadorRodada();
            rodadaZumbi();
        } while (pelotaoVivo() || zumbisVivo1());
    }

    public static void fase2()  {
        Zumbi zumbiNormal1 = new Normal("normal",80,50,true);
        Zumbi zumbiNormal2 = new Normal("normal",80,50,true);
        Zumbi zumbiForte = new Forte("forte",150,60,true);
    }

    public static void fase3()  {
        Zumbi zumbiForte1 = new Forte("forte",150,60,true);
        Zumbi zumbiForte2 = new Forte("forte",150,60,true);
    }

    public static void escolhaJogadorRodada() {
        Soldado atual;
        System.out.println("""
                Qual Soldado você deseja utilizar, nesta rodada ?
                1- Assalto
                2- Batedor
                3- Medico
                4- Suporte
                """);
        int opcao = sc.nextInt();

        switch(opcao) {
            case 1:
                System.out.println("""
                        Digite qual função você deseja realizar :
                        1- Skill Granada
                        2- Atirar
                        """);
                int func = sc.nextInt();

                if(func == 1) {

                }

            case 2:


            case 3:


            case 4:

        }

    }

    public static void rodadaZumbi() {

    }

    public static boolean pelotaoVivo() {
        for (Soldado soldadoFor : Pelotao.pelotao) {
            if(soldadoFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo1() {

        return true;
    }

    public static boolean zumbisVivo2() {

        return true;
    }

    public static boolean zumbisVivo3() {

        return true;
    }
}
