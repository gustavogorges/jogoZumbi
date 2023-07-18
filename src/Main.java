import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                Bem Vindo !!!
                
                //Menu Principal//
                1- Jogar do inicio
                2- Ver meu pelotão
                """);
        int opcao = sc.nextInt();

        switch(opcao) {
            case 1:
                Jogar();

            case 2:
                VerPelotao();
        }
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

    public static void VerPelotao() {

    }
}