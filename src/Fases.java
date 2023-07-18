import Pelotao.Assalto;
import Pelotao.Suporte;
import Pelotao.Medico;
import Pelotao.Batedor;
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

    public static ArrayList<Soldado> pelotao = new ArrayList<>();

    static boolean fase1Concluida = false;
    static boolean fase2Concluida = false;
    static boolean fase3Concluida = false;
    static int faseAtual;

    public static void fase1()  {
        Soldado assalto = new Assalto("assalto",100,45,60,true,true);
        pelotao.add(assalto);
        Soldado suporte = new Suporte("suporte",110,25,1,true,true);
        pelotao.add(suporte);
        Soldado medico = new Medico("medico",90,30,60,true,true);
        pelotao.add(medico);
        Soldado batedor = new Batedor("batedor",90,100,999,true,true);
        pelotao.add(batedor);

        Zumbi zumbiFraco11 = new Fraco("fraco",50,20,true);
        grupo1.add(zumbiFraco11);
        Zumbi zumbiFraco12 = new Fraco("fraco",50,20,true);
        grupo1.add(zumbiFraco12);
        Zumbi zumbiFraco13 = new Fraco("fraco",50,20,true);
        grupo1.add(zumbiFraco13);
        Zumbi zumbiNormal11 = new Normal("normal",80,50,true);
        grupo1.add(zumbiNormal11);
        Zumbi zumbiNormal12 = new Normal("normal",80,50,true);
        grupo1.add(zumbiNormal12);

        do {
            statusPelotao();
            escolhaJogadorRodada();
            rodadaZumbi1();
        } while (zumbisVivo1());
        if(pelotaoVivo() && !zumbisVivo1()) {
            System.out.println("Parabens o seu pelotão passou da primeira fase!");
            fase1Concluida = true;
        }
    }

    public static void fase2()  {
        Zumbi zumbiNormal21 = new Normal("normal",80,50,true);
        grupo2.add(zumbiNormal21);
        Zumbi zumbiNormal22 = new Normal("normal",80,50,true);
        grupo2.add(zumbiNormal22);
        Zumbi zumbiForte21 = new Forte("forte",150,60,true);
        grupo2.add(zumbiForte21);
        Zumbi zumbiForte22 = new Forte("forte",150,60,true);
        grupo2.add(zumbiForte22);
        Zumbi zumbiForte23 = new Forte("forte",150,60,true);
        grupo2.add(zumbiForte23);

        do {
            statusPelotao();
            escolhaJogadorRodada();
            if(!fase2Concluida) {
                rodadaZumbi2();
            }
        } while (zumbisVivo2());
        if(pelotaoVivo() && !zumbisVivo2()) {
            System.out.println("Parabens o seu pelotão passou da primeira fase!");
            fase2Concluida = true;
        } else if(!pelotaoVivo() && zumbisVivo2()) {
            System.out.println("Seu pelotão morreu na segunda fase!");
        }
    }

    public static void fase3()  {
        Zumbi zumbiForte31 = new Forte("forte",150,60,true);
        Zumbi zumbiForte32 = new Forte("forte",150,60,true);
        Zumbi zumbiForte33 = new Forte("forte",150,60,true);
        Zumbi zumbiForte34 = new Forte("forte",150,60,true);
        Zumbi zumbiForte35 = new Forte("forte",150,60,true);

        do {
            statusPelotao();
            escolhaJogadorRodada();
            if(!fase3Concluida) {
                rodadaZumbi3();
            }
        } while (zumbisVivo3());
        if(pelotaoVivo() && !zumbisVivo3()) {
            System.out.println("Parabens o seu pelotão zerou o game!");
            fase3Concluida = true;
        } else if(!pelotaoVivo() && zumbisVivo3()) {
            System.out.println("Seu pelotão morreu na terceira fase!");
        }
    }

    public static void statusPelotao() {
        int cont = 1;
        System.out.println("Status do pelotão : ");
        for (Soldado soldadoFor: pelotao) {
            if(soldadoFor.isVivo()) {
                System.out.println(cont + ": " + soldadoFor.getClasse() + "\n vida: " + soldadoFor.getVida() + "\n dano: " + soldadoFor.getDano() + "\n skill: " + soldadoFor.getSkill() + "\n");
                cont++;
            } else {
                System.out.println(cont + ": " + soldadoFor.getClasse() + "\n SOLDADO ABATIDO \n");
                cont++;
            }
        }
    }

    public static void escolhaJogadorRodada() {
        if(Fases.fase1Concluida && Fases.fase2Concluida) {
            faseAtual = 3;
        } else if (Fases.fase1Concluida){
            faseAtual = 2;
        } else {
            faseAtual = 1;
        }
        if(!pelotaoVivo()) {
            System.out.println("Você perdeu!");
            System.exit(0);
        }
        Soldado atual;
        System.out.println("""
                Qual Soldado você deseja utilizar, nesta rodada ?
                1- Assalto
                2- Suporte
                3- Medico
                4- Batedor
                """);
        int opcao = sc.nextInt();

        if(opcao == 1) {
            if(Fases.pelotao.get(0).isVivo()) {
                Jogadas.jogadaAssalto(opcao, faseAtual);
            } else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 2) {
            if(Fases.pelotao.get(1).isVivo()) {
                Jogadas.jogadaSuporte(opcao, faseAtual);
            }else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 3) {
            if(Fases.pelotao.get(2).isVivo()) {
                Jogadas.jogadaMedico(opcao, faseAtual);
            }else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 4) {
            if(Fases.pelotao.get(3).isVivo()) {
                Jogadas.jogadaBatedor(opcao, faseAtual);
            }  else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        }

    }

    public static void rodadaZumbi1() {
        double randomZumbiNumber, randomSoldadoNumber;
        randomZumbiNumber = Math.random() * 4;
        randomSoldadoNumber = Math.random() * 4;
        int truncadoZumbi = (int)randomZumbiNumber;
        int truncadoSoldado = (int)randomSoldadoNumber;

        Zumbi zumbiRandom = grupo1.get(truncadoZumbi);
        Soldado jogadorRandom = pelotao.get(truncadoSoldado);

        zumbiRandom.bater(jogadorRandom);
        System.out.println("Zumbi "+zumbiRandom.getClasse()+" bateu em Soldado "+ jogadorRandom.getClasse());
    }

    public static void rodadaZumbi2() {
        double randomZumbiNumber, randomSoldadoNumber;
        randomZumbiNumber = Math.random() * 4;
        randomSoldadoNumber = Math.random() * 4;
        int truncadoZumbi = (int)randomZumbiNumber;
        int truncadoSoldado = (int)randomSoldadoNumber;

        Zumbi zumbiRandom = grupo2.get(truncadoZumbi);
        Soldado jogadorRandom = pelotao.get(truncadoSoldado);

        zumbiRandom.bater(jogadorRandom);
        System.out.println("Zumbi "+zumbiRandom.getClasse()+" bateu em Soldado "+ jogadorRandom.getClasse());
    }

    public static void rodadaZumbi3() {
        double randomZumbiNumber, randomSoldadoNumber;
        randomZumbiNumber = Math.random() * 4;
        randomSoldadoNumber = Math.random() * 4;
        int truncadoZumbi = (int)randomZumbiNumber;
        int truncadoSoldado = (int)randomSoldadoNumber;

        Zumbi zumbiRandom = grupo3.get(truncadoZumbi);
        Soldado jogadorRandom = pelotao.get(truncadoSoldado);

        zumbiRandom.bater(jogadorRandom);
        System.out.println("Zumbi "+zumbiRandom.getClasse()+" bateu em Soldado "+ jogadorRandom.getClasse());
    }

    public static boolean pelotaoVivo() {
        for (Soldado soldadoFor : pelotao) {
            if(soldadoFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo1() {
        for (Zumbi zumbiFor : grupo1) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo2() {
        for (Zumbi zumbiFor : grupo2) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public static boolean zumbisVivo3() {
        for (Zumbi zumbiFor : grupo3) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }
}
