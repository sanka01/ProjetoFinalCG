package br.unitins.projetofinalcg;

import br.unitins.projetofinalcg.AndGraph.AGSprite;

public class Bloco {

    public static final int SILVER = 1;
    public static final int RED = 2;
    public static final int BLUE = 3;
    public static final int ORANGE = 4;
    public static final int PINK = 5;
    public static final int GREEN = 6;
    public static final int GOLD = 7;

    private AGSprite vrSprite = null;
    private int hp = 1;
    private int pontuacao = 0;

    public Bloco() {
    }

    public Bloco(AGSprite sprite) {
        vrSprite = sprite;
    }

    public int getIdCor(int i) {
        switch (i) {
            case SILVER:
                pontuacao = 50 * Configuracoes.round;
                hp = 3;
                return R.mipmap.silverwall;
            case RED:
                pontuacao = 90;
                return R.mipmap.redwall;
            case BLUE:
                pontuacao = 100;
                return R.mipmap.bluewall;
            case ORANGE:
                pontuacao = 60;
                return R.mipmap.orangewall;
            case PINK:
                pontuacao = 110;
                return R.mipmap.pinkwall;
            case GREEN:
                pontuacao = 80;
                return R.mipmap.greenwall;
            case GOLD:
                hp = -1;
                pontuacao = 0;
                return 0;
        }
        return 0;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Bloco setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;

        return this;
    }

    public void hit() {
        hp--;
    }

    public int getHp() {
        return hp;
    }

    public Bloco setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public AGSprite getVrSprite() {
        return vrSprite;
    }

    public Bloco setVrSprite(AGSprite vrSprite) {
        this.vrSprite = vrSprite;
        return this;
    }
}
