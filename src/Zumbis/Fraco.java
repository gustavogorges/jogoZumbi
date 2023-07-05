package Zumbis;

import Pelotao.Soldado;

public class Fraco extends Zumbi {

    public Fraco (String classe, int vida, int dano,boolean vivo) {
        super(classe,vida,dano,vivo);
    }

    @Override
    public void bater(Soldado alvo) {
        if (alvo.isVivo()) {
            int vidaAlvo = alvo.getVida();
            int danoZumbi = this.getVida();

            alvo.setVida(vidaAlvo - danoZumbi);
        }
    }
}
