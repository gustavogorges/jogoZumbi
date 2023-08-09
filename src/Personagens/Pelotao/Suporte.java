package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Suporte extends Soldado {

    public Suporte(String classe, int vida, int dano, int skill, boolean vivo, boolean skillBoolean) {
        super(classe,vida,dano,skill,vivo, skillBoolean);
    }


    public void skill(Personagem alvo) {
        Soldado soldado = (Soldado) alvo;

        boolean skillAlvoBoolean = soldado.isSkillBoolean();

        if(skillAlvoBoolean = false) {
            soldado.setSkillBoolean(true);
        }
    }

}
