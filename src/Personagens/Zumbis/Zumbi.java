package Personagens.Zumbis;

import Personagens.Pelotao.Soldado;
import Personagens.Personagem;

public abstract class Zumbi extends Personagem{


    public Zumbi(String classe, int vida, int dano) {
        super(classe, vida, dano);
    }

    public abstract void bater(Soldado alvo);





}
