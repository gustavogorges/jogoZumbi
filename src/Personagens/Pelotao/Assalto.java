package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Assalto extends Soldado {
    public Assalto(String classe, int vida, int dano, int skill, boolean vivo, boolean skillBoolean) {
        super(classe,vida,dano,skill,vivo,skillBoolean);
    }



    public void skill(Personagem alvo) {
        Zumbi zumbi = (Zumbi) alvo;
        int danoSkill = this.getSkill();
        int vidaAlvo = zumbi.getVida();

        zumbi.setVida(vidaAlvo - danoSkill);
    }




}
