package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Batedor extends Soldado {

    public Batedor() {
        super("batedor",90,100,999);
    }


    @Override
    public void skill(Personagem alvo) {
        Zumbi zumbi = (Zumbi) alvo;
        int danoSkill = this.getSkill();
        int vidaAlvo = zumbi.getVida();

        zumbi.setVida(vidaAlvo - danoSkill);
    }


}
