import Pelotao.Pelotao;
import Zumbis.Zumbi;
import Pelotao.Assalto;
import Pelotao.Soldado;

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
            if(faseAtual == 1) {
                Zumbi zumbiEscolhido = zumbiEscolhido1();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (faseAtual == 2) {
                Zumbi zumbiEscolhido = zumbiEscolhido2();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if( faseAtual == 3) {
                Zumbi zumbiEscolhido = zumbiEscolhido3();
                soldado.atirar(soldado, zumbiEscolhido);
            }
          }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                if(faseAtual == 1) {
                    Zumbi zumbiEscolhido = zumbiEscolhido1();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                } else if (faseAtual == 2) {
                    Zumbi zumbiEscolhido = zumbiEscolhido2();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                } else if( faseAtual == 3) {
                    Zumbi zumbiEscolhido = zumbiEscolhido3();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                }

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
            if(faseAtual == 1) {
                Zumbi zumbiEscolhido = zumbiEscolhido1();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (faseAtual == 2) {
                Zumbi zumbiEscolhido = zumbiEscolhido2();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if( faseAtual == 3) {
                Zumbi zumbiEscolhido = zumbiEscolhido3();
                soldado.atirar(soldado, zumbiEscolhido);
            }
        }
        else if (func == 2) {
            if (soldado.isSkillBoolean()) {
                if(faseAtual == 1) {
                    Zumbi zumbiEscolhido = zumbiEscolhido1();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                } else if (faseAtual == 2) {
                    Zumbi zumbiEscolhido = zumbiEscolhido2();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                } else if( faseAtual == 3) {
                    Zumbi zumbiEscolhido = zumbiEscolhido3();
                    zumbiEscolhido.setVida(zumbiEscolhido.getVida() - soldado.getSkill());
                    soldado.setSkillBoolean(false);
                }
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

        if(func == 1) {
            if(faseAtual == 1) {
                Zumbi zumbiEscolhido = zumbiEscolhido1();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (faseAtual == 2) {
                Zumbi zumbiEscolhido = zumbiEscolhido2();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if( faseAtual == 3) {
                Zumbi zumbiEscolhido = zumbiEscolhido3();
                soldado.atirar(soldado, zumbiEscolhido);
            }
        }
        else if (func == 2) {
            if(soldado.isSkillBoolean()) {
                Soldado soldadoEscolha = soldadoEscolha();
                int cura = soldado.getSkill();
                soldadoEscolha.setVida(soldadoEscolha.getVida() + cura);
                soldado.setSkillBoolean(false);
            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
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
            if(faseAtual == 1) {
                Zumbi zumbiEscolhido = zumbiEscolhido1();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if (faseAtual == 2) {
                Zumbi zumbiEscolhido = zumbiEscolhido2();
                soldado.atirar(soldado, zumbiEscolhido);
            } else if( faseAtual == 3) {
                Zumbi zumbiEscolhido = zumbiEscolhido3();
                soldado.atirar(soldado, zumbiEscolhido);
            }
        }
        else if (func == 2) {
            Soldado soldadoEscolha = soldadoEscolha();

            if(soldado.isSkillBoolean()) {
                if(!soldadoEscolha.isSkillBoolean()) {
                    soldadoEscolha.setSkillBoolean(true);
                    soldado.setSkillBoolean(false);
                } else {
                    System.out.println("O soladado escolhido ainda possui skill.");
                }

            } else {
                System.out.println("\n Este soldado ja utilizou sua skill. Você Perdeu a Vez \n");
            }


        }
    }

    public static Zumbi zumbiEscolhido1() {
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

    public static Zumbi zumbiEscolhido2() {
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
    }

    public static Zumbi zumbiEscolhido3() {
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

    public static Soldado soldadoEscolha() {
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
