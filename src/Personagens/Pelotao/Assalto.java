package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public class Assalto extends Soldado {
    public Assalto() {
        super("assalto",100,45,70);
    }

    @Override
    public String textoSkill() {
        return super.textoSkill() + "\n"+"2- Skill granada";
    }

    public void skill(Personagem alvo) {
        Zumbi zumbi = (Zumbi) alvo;
        int danoSkill = this.getSkill();
        int vidaAlvo = zumbi.getVida();

        zumbi.setVida(vidaAlvo - danoSkill);
        setSkillBoolean(false);
    }




}
