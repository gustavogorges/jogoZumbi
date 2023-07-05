package Pelotao;

import Zumbis.Zumbi;

import java.util.ArrayList;

public abstract class Soldado {
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

    public abstract void atirar(Soldado atirador, Zumbi alvo);

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
        return vivo;
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


