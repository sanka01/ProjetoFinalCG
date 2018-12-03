package br.unitins.projetofinalcg;

import java.util.ArrayList;

import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;
import br.unitins.projetofinalcg.AndGraph.AGScreenManager;
import br.unitins.projetofinalcg.AndGraph.AGSoundManager;
import br.unitins.projetofinalcg.AndGraph.AGSprite;
import br.unitins.projetofinalcg.AndGraph.AGTimer;

public class Configuracoes {

    public static int round = 2;
    public static int pontuacao = 0;
    public static ArrayList<AGSprite> pontos = null;
    public static AGTimer gameOver = null;
    public static boolean isPlay = true;
    public static AGSprite modulo = null;
    public static AGSprite background = null;
    public static AGSprite bola = null;
    public static AGSprite botaoPause = null;
    public static float direcaoX = 1, direcaoY = 1, velocidadeX = 1, velocidadeY = 1;
    public static int codToque = 0;
    public static ArrayList<Bloco> blocos = null;
    public static AGTimer tempoDesce = null, colider = null;


    public static AGSprite criaBola(AGScene cena, float velocidadeX, float velocidadeY) {
        AGSprite bola = cena.createSprite(R.mipmap.bola, 1, 1);
        bola.setScreenPercent(5, 5);
        bola.vrPosition.setXY((AGScreenManager.iScreenWidth / 100) * 50, (AGScreenManager.iScreenHeight / 100) * 14);
        bola.vrDirection.setXY(velocidadeX, velocidadeY);
        return bola;
    }

    public static void initBase(AGScene cena) {
        colider = new AGTimer(0);
        codToque = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav");
        botaoPause = cena.createSprite(R.mipmap.pausebutton, 1, 1);
        botaoPause.setScreenPercent(10, 10);
        botaoPause.vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 100) * 90, (AGScreenManager.iScreenHeight / 100) * 96);
        modulo = Configuracoes.criaModulo(cena);
        bola = Configuracoes.criaBola(cena, velocidadeX, velocidadeY);
    }

    public static void loopBase(AGScene cena) {
        if (Configuracoes.isPlay) {
            colider.update();
            if (bola.collideY(0) || blocos.size() == 0) {
                Configuracoes.fimDeJogo(cena);
                Configuracoes.isPlay = false;
                return;
            }
            if (tempoDesce.isTimeEnded()) {
                for (Bloco bloco :
                        blocos) {

                    bloco.getVrSprite().vrPosition.setY(bloco.getVrSprite().vrPosition.getY() - 50);
                    if (bloco.getVrSprite().collideY(modulo.vrPosition.fY)) {
                        Configuracoes.isPlay = false;
                        return;
                    }
                }
                tempoDesce = new AGTimer(7000);
            }

            tempoDesce.update();
            for (Bloco bloco :
                    blocos) {

                if (bloco.getVrSprite().collide(bola)) {

                    velocidadeX = (float) Math.random() * 2;
                    bloco.hit();
                    Configuracoes.pontuacao += bloco.getPontuacao();
                    Configuracoes.atualizaPontos();
                    if (bloco.getHp() == 0) {
                        AGSoundManager.vrSoundEffects.play(codToque);
                        cena.removeSprite(bloco.getVrSprite());
                        blocos.remove(bloco);
                    }
                    bola.vrDirection.fX *= -1;
                    bola.vrDirection.fY *= -1;
                    return;
                }
            }
            if (modulo.collideX(AGInputManager.vrTouchEvents.getLastPosition().fX)) {
                modulo.vrPosition.setX(AGInputManager.vrTouchEvents.getLastPosition().fX);
            }
            if (bola.collideX(AGScreenManager.iScreenWidth)) {
                AGSoundManager.vrSoundEffects.play(codToque);
                bola.vrDirection.fX = -1;
            }
            if (bola.collideX(0)) {
                AGSoundManager.vrSoundEffects.play(codToque);
                bola.vrDirection.fX = 1;
            }
            if (bola.collideY(AGScreenManager.iScreenHeight)) {
                AGSoundManager.vrSoundEffects.play(codToque);
                bola.vrDirection.fY *= -1;
            }

            if (modulo.collide(bola) && colider.isTimeEnded()) {

                colider = new AGTimer(100);
                velocidadeX = (float) Math.random() * 2;

                AGSoundManager.vrSoundEffects.play(codToque);
                bola.vrDirection.fX = Math.random() > 0.5 ? 1 : -1;
                bola.vrDirection.fY *= -1;

            }

            bola.moveTo(2,
                    bola.vrPosition.fX + velocidadeX * bola.vrDirection.fX,
                    bola.vrPosition.fY + bola.vrDirection.fY * velocidadeY);

        }
    }

    public static AGSprite criaModulo(AGScene cena) {
        AGSprite modulo = cena.createSprite(R.mipmap.forma, 1, 1);
        modulo.setScreenPercent(15, 2);
        modulo.vrPosition.setXY((AGScreenManager.iScreenWidth / 100) * 50, (AGScreenManager.iScreenHeight / 100) * 10);

        return modulo;
    }

    private static void addAnimationNumbers(AGSprite number) {
        number.addAnimation(30, false, 0, 0);
        number.addAnimation(30, false, 0, 1);
        number.addAnimation(30, false, 0, 2);
        number.addAnimation(30, false, 0, 3);
        number.addAnimation(30, false, 0, 4);
        number.addAnimation(30, false, 0, 5);
        number.addAnimation(30, false, 0, 6);
        number.addAnimation(30, false, 0, 7);
        number.addAnimation(30, false, 0, 8);
        number.addAnimation(30, false, 0, 9);
    }

    public static void iniciaPontos(AGScene cena) {
        pontos = new ArrayList<>();
        AGSprite number = cena.createSprite(R.mipmap.numbers, 10, 1);
        number.setScreenPercent(5, 5);
        number.vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 100) * 15, (AGScreenManager.iScreenHeight / 100) * 96);
        addAnimationNumbers(number);


        pontos.add(number);


        number = cena.createSprite(R.mipmap.numbers, 10, 1);
        number.setScreenPercent(5, 5);
        number.setCurrentAnimation(0);
        number.vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 100) * 20, (AGScreenManager.iScreenHeight / 100) * 96);
        addAnimationNumbers(number);

        pontos.add(number);

        number = cena.createSprite(R.mipmap.numbers, 10, 1);
        number.setScreenPercent(5, 5);
        number.setCurrentAnimation(0);
        number.vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 100) * 25, (AGScreenManager.iScreenHeight / 100) * 96);
        addAnimationNumbers(number);

        pontos.add(number);

        number = cena.createSprite(R.mipmap.numbers, 10, 1);
        number.setScreenPercent(5, 5);
        number.setCurrentAnimation(0);
        number.vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 100) * 30, (AGScreenManager.iScreenHeight / 100) * 96);
        addAnimationNumbers(number);
        pontos.add(number);
    }

    public static void fimDeJogo(AGScene cena) {
        AGSprite gameOverSprite = cena.createSprite(R.mipmap.gameover, 1, 1);
        gameOverSprite.setScreenPercent(80, 20);
        gameOverSprite.vrPosition.setXY(
                AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);
        if (gameOver == null)
            gameOver = new AGTimer(5000);

    }

    public static void atualizaPontos() {
        int pontuacao = Configuracoes.pontuacao;
        int unidade = 0;
        int dezena = 0;
        int centena = 0;
        int milhar = 0;
        int resto1 = 0;
        int resto2 = 0;
        int resto3 = 0;
        if (pontuacao % 1000 > 0)
            resto1 = pontuacao % 1000;
        if (pontuacao % 100 > 0)
            resto2 = pontuacao % 100;
        if (pontuacao % 10 > 0)
            resto3 = pontuacao % 10;
        milhar = pontuacao / 1000;
        if (resto1 > 0)
            centena = resto1 / 100;
        if (resto2 > 0)
            dezena = resto2 / 10;
        unidade = resto3;

        pontos.get(0).setCurrentAnimation(milhar);
        pontos.get(1).setCurrentAnimation(centena);
        pontos.get(2).setCurrentAnimation(dezena);
        pontos.get(3).setCurrentAnimation(unidade);
    }
}
