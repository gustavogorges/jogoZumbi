package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Suporte extends Soldado {

    public Suporte() {
        super("suporte",110,25,1);
    }


    public void skill(Personagem alvo) {
        Soldado soldado = (Soldado) alvo;

        boolean skillAlvoBoolean = soldado.isSkillBoolean();

        if(skillAlvoBoolean = false) {
            soldado.setSkillBoolean(true);
        }
    }

}
