import Personagens.Pelotao.*;
import Personagens.Personagem;

import java.util.ArrayList;

public class Jogador {
    private ArrayList<Soldado> pelotao = new ArrayList<>();
    Jogador() {
        Soldado assalto = new Assalto();
        pelotao.add(assalto);
        Soldado suporte = new Suporte();
        pelotao.add(suporte);
        Soldado medico = new Medico();
        pelotao.add(medico);
        Soldado batedor = new Batedor();
        pelotao.add(batedor);
    }

    public ArrayList<Soldado> getPelotao() {
        return pelotao;
    }
}
