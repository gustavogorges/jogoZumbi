package Personagens;

public abstract class Personagem {
    private String classe;
    private int vida;
    private int dano;

    public Personagem(String classe, int vida, int dano) {
        this.classe = classe;
        this.vida = vida;
        this.dano = dano;
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
        return this.getVida() > 0;
    }
}
