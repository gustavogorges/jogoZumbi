import Personagens.Pelotao.*;
import Personagens.Personagem;
import Personagens.Zumbis.Forte;
import Personagens.Zumbis.Fraco;
import Personagens.Zumbis.Normal;
import Personagens.Zumbis.Zumbi;

import java.util.ArrayList;
import java.util.Scanner;

public class Fases { // fazer um objeto fase e passar todos os souts para o main
    private ArrayList<Zumbi> grupoZumbis = new ArrayList<>();
    private Jogador jogador;
    Fases(int faseAtual) {

        int fraco = 0, normal = 0, forte = 0;

        if(faseAtual == 1) {
            fraco = 3;
            normal = 2;
        }

        else if(faseAtual == 2) {
            normal = 2;
            forte = 3;
        }

        else if(faseAtual == 3) {
            forte = 5;
        }

        for (int i = 0; i < fraco; i++) {
            grupoZumbis.add(new Fraco("fraco", 50, 20, true));
        }
        for (int i = 0; i < normal; i++) {
            grupoZumbis.add(new Normal("normal", 80, 50, true));
        }
        for (int i = 0; i < forte; i++) {
            grupoZumbis.add(new Forte("forte", 150, 60, true));
        }
    }

    public Zumbi zumbiRandom() {
        double randomZumbiNumber = Math.random() * grupoZumbis.size();
        int truncadoZumbi = (int)randomZumbiNumber;

        return grupoZumbis.get(truncadoZumbi);
    }

    public Personagem soldadoRandom() {
        double randomSoldadoNumber;
        randomSoldadoNumber = Math.random() * jogador.getPelotao().size();
        int truncadoSoldado = (int)randomSoldadoNumber;

        return jogador.getPelotao().get(truncadoSoldado);
    }



    public boolean pelotaoVivo() {
        for (Personagem soldadoFor : jogador.getPelotao()) {
            if(soldadoFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public boolean zumbisVivo() {
        for (Zumbi zumbiFor : grupoZumbis) {
            if(zumbiFor.isVivo()){
                return true;
            }
        }
        return false;
    }

    public String rodadaZumbi() {
        // ZUMBI ALEATÓRIO
        Zumbi zumbiRandom = zumbiRandom();

        Soldado soldadoRandom = (Soldado) soldadoRandom();

        zumbiRandom.bater(soldadoRandom);
        return "Zumbi " + zumbiRandom.getClasse() + " bateu em Soldado " + soldadoRandom.getClasse();
    }

    public ArrayList<Zumbi> getGrupoZumbis() {
        return grupoZumbis;
    }

    public Jogador getJogador() {
        return jogador;
    }
}
