package br.unitins.projetofinalcg;

import java.util.ArrayList;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;
import br.unitins.projetofinalcg.AndGraph.AGScreenManager;
import br.unitins.projetofinalcg.AndGraph.AGSprite;
import br.unitins.projetofinalcg.AndGraph.AGTimer;

public class CenaFase2 extends AGScene {

    private AGSprite background = null;

    public CenaFase2(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        Configuracoes.pontuacao = 0;
        Configuracoes.round = 1;

        Configuracoes.tempoDesce = new AGTimer(5000);
        background = createSprite(R.mipmap.backgroundfase1, 1, 1);
        background.setScreenPercent(100, 100);
        background.vrPosition.setXY(
                AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        Configuracoes.initBase(this);
        Configuracoes.blocos = new ArrayList<>();
        //chamado toda vez que uma cena é apresentada
        setSceneBackgroundColor(1, 1, 1);

        for (int i = 95; i >= 55; i -= 5) {

            Bloco bloco = new Bloco();
            int cor = Bloco.ORANGE;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11), (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 90; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.BLUE;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 2, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 85; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.GREEN;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 3, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 80; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.BLUE;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 4, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 75; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.RED;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 5, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 70; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.ORANGE;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 6, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 65; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.BLUE;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 7, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 60; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.GREEN;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 8, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 55; i >= 55; i -= 5) {
            Bloco bloco = new Bloco();
            int cor = Bloco.RED;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * 9, (AGScreenManager.iScreenHeight / 100) * i);
            Configuracoes.blocos.add(bloco);
        }
        for (int i = 1; i < 10; i++) {
            Bloco bloco = new Bloco();
            int cor = Bloco.SILVER;
            cor = bloco.getIdCor(cor);
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 50);
            Configuracoes.blocos.add(bloco);
        }
        Bloco bloco = new Bloco();
        int cor = Bloco.PINK;
        cor = bloco.getIdCor(cor);
        bloco.setVrSprite(createSprite(cor, 1, 1));
        bloco.getVrSprite().setScreenPercent(9, 5);
        bloco.getVrSprite().vrPosition.setXY(
                (AGScreenManager.iScreenWidth / 11) * 10, (AGScreenManager.iScreenHeight / 100) * 50);
        Configuracoes.blocos.add(bloco);


        Configuracoes.iniciaPontos(this);

    }


    @Override
    public void restart() {
        Configuracoes.bola.vrDirection.fX = Configuracoes.direcaoX;
        Configuracoes.bola.vrDirection.fY = Configuracoes.direcaoY;
    }

    @Override
    public void stop() {
        Configuracoes.direcaoX = Configuracoes.bola.vrDirection.fX;
        Configuracoes.direcaoY = Configuracoes.bola.vrDirection.fY;
        Configuracoes.bola.vrDirection.fX = 0;
        Configuracoes.bola.vrDirection.fY = 0;
    }


    @Override
    public void loop() {
        if (Configuracoes.gameOver != null) {
            Configuracoes.gameOver.update();
            if (Configuracoes.gameOver.isTimeEnded()) {
                Configuracoes.gameOver = null;
                if (Configuracoes.blocos.size() == 0) {
                    vrGameManager.setCurrentScene(Principal.FASE2);
                } else {
                    vrGameManager.setCurrentScene(Principal.MENU);
                }
                return;
            }
        }
        Configuracoes.loopBase(this);


        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(Principal.MENU);
        }
        if (AGInputManager.vrTouchEvents.screenClicked() && Configuracoes.botaoPause.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
            Configuracoes.isPlay = !Configuracoes.isPlay;
        }
    }
}
