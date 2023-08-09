package Personagens.Pelotao;

import Personagens.Personagem;
import Personagens.Zumbis.Zumbi;

public abstract class Soldado extends Personagem {
    private String classe;
    private int vida;
    private int dano;
    private int skill;
    private boolean vivo = true;

    private boolean skillBoolean;

    public Soldado(String classe,int vida, int dano, int skill, boolean vivo, boolean skillBoolean) {
        this.classe = classe;
        this.vida = vida;
        this.dano = dano;
        this.skill = skill;
        this.vivo = vivo;
        this.skillBoolean = skillBoolean;
    }

    public void atirar(Soldado atirador, Zumbi alvo) {
        if(alvo.isVivo()) {
            int danoAtirador = atirador.getDano();
            int vidaAlvo = alvo.getVida();

            alvo.setVida(vidaAlvo - danoAtirador);
        }
    }

    public abstract void skill(Personagem alvo);

    public int getVida() {
        return vida;
    }

    public String getClasse() {
        return classe;
    }

    public int getDano() {
        return dano;
    }

    public int getSkill() {
        return skill;
    }

    public boolean isVivo() {
        if(this.getVida() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isSkillBoolean() {
        return skillBoolean;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setSkillBoolean(boolean skillBoolean) {
        this.skillBoolean = skillBoolean;
    }
}


