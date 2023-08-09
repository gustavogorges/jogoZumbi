package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Medico extends Soldado {

    public Medico(String classe, int vida, int dano, int skill, boolean vivo, boolean skillBoolean) {
        super(classe,vida,dano,skill,vivo, skillBoolean);
    }




    public void skill(Personagem alvo) {
        Soldado soldado = (Soldado) alvo;
        int curaVida = this.getSkill();
        int vidaAlvo = soldado.getVida();

        soldado.setVida(vidaAlvo + curaVida);
    }
}
