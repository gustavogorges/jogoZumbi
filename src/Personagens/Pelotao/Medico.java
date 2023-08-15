package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Medico extends Soldado {

    public Medico() {
        super("medico",90,30,60);
    }




    public void skill(Personagem alvo) {
        Soldado soldado = (Soldado) alvo;
        int curaVida = this.getSkill();
        int vidaAlvo = soldado.getVida();

        soldado.setVida(vidaAlvo + curaVida);
    }
}
