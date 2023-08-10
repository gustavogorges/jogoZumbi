import Personagens.Pelotao.*;
import Personagens.Personagem;
import Personagens.Zumbis.Forte;
import Personagens.Zumbis.Fraco;
import Personagens.Zumbis.Normal;
import Personagens.Zumbis.Zumbi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean fimJogo = false;

    static ArrayList<Zumbi> grupo1 = new ArrayList<>();
    static ArrayList<Zumbi> grupo2 = new ArrayList<>();
    static ArrayList<Zumbi> grupo3 = new ArrayList<>();

    public static ArrayList<Soldado> pelotao = new ArrayList<>();

    static boolean fase1Concluida = false;
    static boolean fase2Concluida = false;
    static boolean fase3Concluida = false;
    static int faseAtual;

    public static void main(String[] args) {
        do {
            System.out.println("""
                    Bem Vindo !!!
                                    
                    //Menu Principal//
                    1- Jogar do inicio
                    2- Explicação Pelotão
                    """);
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Jogar();
                case 2:
                    ExplicacaoPelotao();
            }
        } while(!fimJogo);
    }

    public static void Jogar() {
        System.out.println("// FASE 1 //");
        fase1();
        if(fase1Concluida) {
            System.out.println("// FASE 2 //");
            fase2();
            if(fase2Concluida) {
                System.out.println("// FASE 3 //");
                fase3();
            }
        }
    }

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
            if(Fases.zumbisVivo1(grupo1)) {
                rodadaZumbi1();
            }
        } while (Fases.zumbisVivo1(grupo1));
        if(Fases.pelotaoVivo(pelotao) && !Fases.zumbisVivo1(grupo1)) {
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
            if(Fases.zumbisVivo2(grupo2)) {
                rodadaZumbi2();
            }
        } while (Fases.zumbisVivo2(grupo2));
        if(Fases.pelotaoVivo(pelotao) && !Fases.zumbisVivo2(grupo2)) {
            System.out.println("Parabens o seu pelotão passou da segunda fase!");
            fase2Concluida = true;
        } else if(!Fases.pelotaoVivo(pelotao) && Fases.zumbisVivo2(grupo2)) {
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
            if(Fases.zumbisVivo3(grupo3)) {
                rodadaZumbi3();
            }
        } while (Fases.zumbisVivo3(grupo3));
        if(Fases.pelotaoVivo(pelotao) && !Fases.zumbisVivo3(grupo3)) {
            System.out.println("Parabens o seu pelotão zerou o game!");
            Main.fimJogo = true;
            fase3Concluida = true;
        } else if(!Fases.pelotaoVivo(pelotao) && Fases.zumbisVivo3(grupo3)) {
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
        if(fase1Concluida && fase2Concluida) {
            faseAtual = 3;
        } else if (fase1Concluida){
            faseAtual = 2;
        } else {
            faseAtual = 1;
        }
        if(!Fases.pelotaoVivo(pelotao)) {
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
            if(pelotao.get(0).isVivo()) {
                jogadaAssalto(opcao, faseAtual);
            } else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 2) {
            if(pelotao.get(1).isVivo()) {
                jogadaSuporte(opcao, faseAtual);
            }else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 3) {
            if(pelotao.get(2).isVivo()) {
                jogadaMedico(opcao, faseAtual);
            }else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        } else if(opcao == 4) {
            if(pelotao.get(3).isVivo()) {
                jogadaBatedor(opcao, faseAtual);
            }  else {
                System.out.println("Este soldado está morto você passou a vez.");
            }
        }

    }

    public static void jogadaAssalto(int opcao, int faseAtual) {
        Soldado soldado = pelotao.get(0);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill granada
                """);
        int func = sc.nextInt();

        if(func == 1) {
            Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
            soldado.atirar(soldado, zumbiEscolhido);
        }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
                soldado.skill(zumbiEscolhido);
                soldado.setSkillBoolean(false);
            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }
        }
    }

    public static void jogadaBatedor(int opcao, int faseAtual) {
        Soldado soldado = pelotao.get(3);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill sniper
                """);
        int func = sc.nextInt();

        if(func == 1) {
            Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
            soldado.atirar(soldado, zumbiEscolhido);
        }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
                soldado.skill(zumbiEscolhido);
                soldado.setSkillBoolean(false);

            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }
        }
    }

    public static void jogadaMedico(int opcao, int faseAtual) {
        Soldado soldado = pelotao.get(2);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill cura
                """);
        int func = sc.nextInt();

        if (func == 1) {
            Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
            soldado.atirar(soldado, zumbiEscolhido);
        } else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                Soldado soldadoEscolhido = (Soldado) alvoSoldado();
                soldado.skill(soldadoEscolhido);
                soldado.setSkillBoolean(false);
            }
        }
    }

    public static void jogadaSuporte(int opcao, int faseAtual) {
        Soldado soldado = pelotao.get(1);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill recarga
                """);
        int func = sc.nextInt();

        if(func == 1) {
            if (func == 1) {
                Zumbi zumbiEscolhido = (Zumbi) alvoZumbi(faseAtual);
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (func == 2) {
                if (soldado.isSkillBoolean()) {
                    Soldado soldadoEscolhido = (Soldado) alvoSoldado();
                    soldado.skill(soldadoEscolhido);
                    soldado.setSkillBoolean(false);
                }
            }

        }
    }

    public static Personagem alvoZumbi(int faseAtual) {
        if (faseAtual == 1) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: grupo1) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return grupo1.get(escolha - 1);
        }
        else if(faseAtual == 2) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: grupo2) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return grupo2.get(escolha - 1);
        } else if(faseAtual == 3) {
            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: grupo3) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return grupo3.get(escolha - 1);
        }
        return null;
    }

    public static Personagem alvoSoldado() {
        int cont = 1;
        System.out.println("Digite qual seu alvo: ");
        for (Soldado soldadoFor : pelotao) {
            System.out.println(cont+"\n - classe : "+soldadoFor.getClasse()+"\n - vida : "+ soldadoFor.getVida());
            cont++;
        }
        int escolha = sc.nextInt();

        return pelotao.get(escolha - 1);
    }

    public static void rodadaZumbi1() {
        // ZUMBI ALEATÓRIO
        Zumbi zumbiRandom = Fases.zumbiRandom1(grupo1);

        Soldado soldadoRandom = Fases.soldadoRandom(pelotao);

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());

    }

    public static void rodadaZumbi2() {
        Zumbi zumbiRandom = Fases.zumbiRandom2(grupo2);

        Soldado soldadoRandom = Fases.soldadoRandom(pelotao);

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());
    }

    public static void rodadaZumbi3() {
        Zumbi zumbiRandom = Fases.zumbiRandom3(grupo3);

        Soldado soldadoRandom = Fases.soldadoRandom(pelotao);

        zumbiRandom.bater(soldadoRandom);
        System.out.println("Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse());
    }

    public static void ExplicacaoPelotao() {
        System.out.println("""
                Explicação de Skills de cada soldado
                1- Assalto, possui uma granada na qual desfere 70 de dano em zumbis atingidos
                2- Suporte, possui a habilidade de recuperar qualquer skill do pelotão que ja tenha sido utilizada
                3- Medico, possui a habilidade de recuperar 60 de vida de seus colegas
                4- Batedor, possui um único tiro de sniper que é hitkill em qualquer zumbi
                """);
    }
}