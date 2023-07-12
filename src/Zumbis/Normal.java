package Zumbis;

import Pelotao.Soldado;

public class Normal extends Zumbi{
    public Normal (String classe, int vida, int dano, boolean vivo) {
        super(classe,vida,dano,vivo);
    }

    @Override
    public void bater(Soldado alvo) {
        if (alvo.isVivo()) {
            int danoZumbi = this.getDano();

            alvo.setVida(alvo.getVida() - danoZumbi);
        }
    }
}
