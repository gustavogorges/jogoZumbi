import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean fimJogo = false;
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
        Fases.fase1();
        if(Fases.fase1Concluida) {
            System.out.println("// FASE 2 //");
            Fases.fase2();
            if(Fases.fase2Concluida) {
                System.out.println("// FASE 3 //");
                Fases.fase3();
            }
        }
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