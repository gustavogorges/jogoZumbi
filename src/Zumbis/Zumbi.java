package Zumbis;

import Pelotao.Soldado;

public abstract class Zumbi {
    private String classe;
    private int vida;
    private int dano;
    private boolean vivo;

    public Zumbi(String classe, int vida, int dano, boolean vivo) {
        this.classe = classe;
        this.vida = vida;
        this.dano = dano;
        this.vivo = vivo;
    }

    public abstract void bater(Soldado alvo);

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getClasse() {
        return classe;
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public boolean isVivo() {
        if(this.getVida() <= 0) {
            return false;
        }
        return true;
    }
}
