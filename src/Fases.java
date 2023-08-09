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
    static ArrayList<Zumbi> grupo1 = new ArrayList<>();
    static ArrayList<Zumbi> grupo2 = new ArrayList<>();
    static ArrayList<Zumbi> grupo3 = new ArrayList<>();

    public static ArrayList<Soldado> pelotao = new ArrayList<>();

    static boolean fase1Concluida = false;
    static boolean fase2Concluida = false;
    static boolean fase3Concluida = false;
    static int faseAtual;

    public static void fase1()  {
        Soldado assalto = new Assalto("assalto",100,45,70,true,true);
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
            if(zumbisVivo1()) {
                rodadaZumbi1();
            }
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
            if(zumbisVivo2()) {
                rodadaZumbi2();
            }
        } while (zumbisVivo2());
        if(pelotaoVivo() && !zumbisVivo2()) {
            System.out.println("Parabens o seu pelotão passou da segunda fase!");
            fase2Concluida = true;
        } else if(!pelotaoVivo() && zumbisVivo2()) {
            System.out.println("Seu pelotão morreu na segunda fase!");
        }
    }

    public static void fase3()  {

        for (int i = 0; i < 5; i++) {
            grupo3.add(new Forte("forte", 150, 60, true));
        }

        do {
            statusPelotao();
            escolhaJogadorRodada();
            if(zumbisVivo3()) {
                rodadaZumbi3();
            }
        } while (zumbisVivo3());
        if(pelotaoVivo() && !zumbisVivo3()) {
            System.out.println("Parabens o seu pelotão zerou o game!");
            Main.fimJogo = true;
            fase3Concluida = true;
        } else if(!pelotaoVivo() && zumbisVivo3()) {
            System.out.println("Seu pelotão morreu na terceira e última fase!");
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
            System.out.println("Você perdeu! O seu pelotão inteiro morreu!");
            System.exit(0);
        }
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

    public static Zumbi zumbiRandom1() {
        double randomZumbiNumber = Math.random() * grupo1.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo1.get(truncadoZumbi);
    }

    public static Zumbi zumbiRandom2() {
        double randomZumbiNumber;
        randomZumbiNumber = Math.random() * grupo2.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo2.get(truncadoZumbi);
    }

    public static Zumbi zumbiRandom3() {
        double randomZumbiNumber;
        randomZumbiNumber = Math.random() * grupo3.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupo3.get(truncadoZumbi);
    }

    public static Soldado soldadoRandom() {
        double randomSoldadoNumber;
        randomSoldadoNumber = Math.random() * pelotao.size();
        int truncadoSoldado = (int)randomSoldadoNumber;

        return pelotao.get(truncadoSoldado);
    }

    public static void rodadaZumbi1() {
        // ZUMBI ALEATÓRIO
        Zumbi zumbiRandom = zumbiRandom1();

        Soldado soldadoRandom = soldadoRandom();

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());

    }

    public static void rodadaZumbi2() {
        Zumbi zumbiRandom = zumbiRandom2();

        Soldado soldadoRandom = soldadoRandom();

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());
    }

    public static void rodadaZumbi3() {
        Zumbi zumbiRandom = zumbiRandom3();

        Soldado soldadoRandom = soldadoRandom();

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());
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

    public static Personagem alvoZumbi(int faseAtual) {
        if (faseAtual == 1) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: Fases.grupo1) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return Fases.grupo1.get(escolha - 1);
        }
        else if(faseAtual == 2) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: Fases.grupo2) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return Fases.grupo2.get(escolha - 1);
        } else if(faseAtual == 3) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: Fases.grupo3) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return Fases.grupo3.get(escolha - 1);
        }
        return null;
    }

    public static Personagem alvoSoldado() {
        int cont = 1;
        System.out.println("Digite qual seu alvo: ");
        for (Soldado soldadoFor : Fases.pelotao) {
            System.out.println(cont+"\n - classe : "+soldadoFor.getClasse()+"\n - vida : "+ soldadoFor.getVida());
            cont++;
        }
        int escolha = sc.nextInt();

        return Fases.pelotao.get(escolha - 1);
    }
}
