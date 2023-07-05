package Pelotao;

import Zumbis.Zumbi;

public class Medico extends Soldado {

    public Medico(String classe, int vida, int dano, int skill, boolean vivo, boolean skillBoolean) {
        super(classe,vida,dano,skill,vivo, skillBoolean);
    }

    @Override
    public void atirar(Soldado atirador, Zumbi alvo) {
        if(alvo.isVivo()) {
            int danoAtirador = atirador.getDano();
            int vidaAlvo = alvo.getVida();

            alvo.setVida(vidaAlvo - danoAtirador);
        }
    }


    public void skill(Soldado atirador, Soldado alvo) {
        int curaVida = atirador.getSkill();
        int vidaAlvo = alvo.getVida();

        alvo.setVida(vidaAlvo + curaVida);
    }
}
