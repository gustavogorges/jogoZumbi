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
        Fases.fase1();
    }

    public static void VerPelotao() {

    }
}