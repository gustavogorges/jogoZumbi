package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public abstract class Soldado extends Personagem {

    private int skill;

    private boolean skillBoolean;

    public Soldado(String classe,int vida, int dano, int skill) {
        super(classe, vida, dano);
        this.skill = skill;
        this.skillBoolean = true;
    }

    public void atirar(Soldado atirador, Personagem alvo) {
        if(alvo.isVivo()) {
            int danoAtirador = atirador.getDano();
            int vidaAlvo = alvo.getVida();

            alvo.setVida(vidaAlvo - danoAtirador);
        }
    }

    public String textoSkill() {
        return "1- Atirar";
    }

    public abstract void skill(Personagem alvo);

    public int getSkill() {
        return skill;
    }

    public boolean isSkillBoolean() {
        return skillBoolean;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setSkillBoolean(boolean skillBoolean) {
        this.skillBoolean = skillBoolean;
    }

    @Override
    public String toString() {
        return this.getClasse() + "\n vida: " + this.getVida() + "\n dano: " + this.getDano() + "\n skill: " + this.getSkill();
    }
}


