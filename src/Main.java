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
    static Fases fase;

    static boolean faseConcluida = false;
    static boolean fase2Concluida = false;
    static boolean fase3Concluida = false;
    static int faseAtual = 1;

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
        do {
            System.out.println("// FASE "+faseAtual+" //");
            fase1();
        } while(faseAtual<=3);
    }

    public static void fase1()  {
        faseConcluida = false;
        fase = new Fases(faseAtual);

        do {
            statusPelotao();
            escolhaJogadorRodada();
            if(fase.zumbisVivo()) {
                fase.rodadaZumbi();
            } else {
                faseAtual++;
                faseConcluida = true;
            }
        } while (!faseConcluida);
        if(fase.pelotaoVivo() && !fase.zumbisVivo()) {
            System.out.println("Parabens o seu pelotão passou da "+faseAtual+"ª fase!");
        }
    }

    public static void statusPelotao() {
        int cont = 1;
        System.out.println("Status do pelotão : ");
        for (Soldado soldadoFor: fase.getJogador().getPelotao()) {
            if(soldadoFor.isVivo()) {
                System.out.println(cont + ": " + soldadoFor + "\n");
            } else {
                System.out.println(cont + ": " + soldadoFor.getClasse() + "\n SOLDADO ABATIDO \n");
            }
            cont++;
        }
    }

    public static void escolhaJogadorRodada() {
        if(!fase.pelotaoVivo()) {
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

        ArrayList<Soldado> pelotao = fase.getJogador().getPelotao();


            if(pelotao.get(opcao - 1).isVivo()) {
                jogada(pelotao.get(opcao - 1));
            } else {
                System.out.println("Este soldado está morto você passou a vez.");
            }

    }

    public static void jogada(Soldado soldado) {
        System.out.println("Digite qual função você deseja utilizar : \n"+soldado.textoSkill());
        int func = sc.nextInt();
        Personagem personagemEscolhido;
        if(func == 1) {
            personagemEscolhido = alvoZumbi();
            soldado.atirar(soldado, personagemEscolhido);
        }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {

              //
                if(soldado instanceof Medico || soldado instanceof Suporte) {
                    personagemEscolhido = alvoSoldado();
                } else {
                    personagemEscolhido = alvoZumbi();
                }
                soldado.skill(personagemEscolhido);
            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }
        }
    }

    public static Personagem alvoZumbi() {

            int cont = 1;
            System.out.println("Digite qual seu alvo: ");
            for (Zumbi zumbiFor: fase.getGrupoZumbis()) {
                if(zumbiFor.isVivo()) {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - vida : " + zumbiFor.getVida());
                    cont++;
                } else {
                    System.out.println(cont + "\n - classe : " + zumbiFor.getClasse() + "\n - ZUMBI MORTO ");
                    cont++;
                }
            }
            int escolha = sc.nextInt();

            return fase.getGrupoZumbis().get(escolha - 1);

    }

    public static Personagem alvoSoldado() {
        int cont = 1;
        System.out.println("Digite qual seu alvo: ");
        for (Soldado soldadoFor : fase.getJogador().getPelotao()) {
            System.out.println(cont + "\n - classe : " + soldadoFor.getClasse() + "\n - vida : " + soldadoFor.getVida());
            cont++;
        }
        int escolha = sc.nextInt();

        return fase.getJogador().getPelotao().get(escolha - 1);

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