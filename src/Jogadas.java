import Personagens.Pelotao.Batedor;
import Personagens.Zumbis.Zumbi;
import Personagens.Pelotao.Soldado;

import java.util.Scanner;

public class Jogadas {
    static Scanner sc = new Scanner(System.in);


    public static void jogadaAssalto(int opcao, int faseAtual) {
        Soldado soldado = Fases.pelotao.get(0);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill granada
                """);
        int func = sc.nextInt();

        if(func == 1) {
            Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
            soldado.atirar(soldado, zumbiEscolhido);
          }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
                soldado.skill(zumbiEscolhido);
                soldado.setSkillBoolean(false);
            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }
        }
    }

    public static void jogadaBatedor(int opcao, int faseAtual) {
        Soldado soldado = Fases.pelotao.get(3);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill sniper
                """);
        int func = sc.nextInt();

        if(func == 1) {
                Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
                soldado.atirar(soldado, zumbiEscolhido);
        }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                    Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
                    soldado.skill(zumbiEscolhido);
                    soldado.setSkillBoolean(false);

            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }
        }
    }

    public static void jogadaMedico(int opcao, int faseAtual) {
        Soldado soldado = Fases.pelotao.get(2);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill cura
                """);
        int func = sc.nextInt();

        if (func == 1) {
            Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
            soldado.atirar(soldado, zumbiEscolhido);
        } else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                Soldado soldadoEscolhido = (Soldado) Fases.alvoSoldado();
                soldado.skill(soldadoEscolhido);
                soldado.setSkillBoolean(false);
            }
        }
    }

    public static void jogadaSuporte(int opcao, int faseAtual) {
        Soldado soldado = Fases.pelotao.get(1);
        System.out.println("""
                Digite qual função você deseja utilizar : 
                1- Atirar
                2- Skill recarga
                """);
        int func = sc.nextInt();

        if(func == 1) {
            if (func == 1) {
                Zumbi zumbiEscolhido = (Zumbi) Fases.alvoZumbi(faseAtual);
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (func == 2) {
                if (soldado.isSkillBoolean()) {
                    Soldado soldadoEscolhido = (Soldado) Fases.alvoSoldado();
                    soldado.skill(soldadoEscolhido);
                    soldado.setSkillBoolean(false);
                }
            }

        }
    }

}
