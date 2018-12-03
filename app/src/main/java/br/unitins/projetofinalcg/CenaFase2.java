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

        for (int j = 95; j >= 45; j -= 5) {

            Bloco bloco = new Bloco();
            int cor = Bloco.ORANGE;
            bloco.setVrSprite(createSprite(cor, 1, 1));
            bloco.getVrSprite().setScreenPercent(9, 5);
            bloco.getVrSprite().vrPosition.setXY(
                    (AGScreenManager.iScreenWidth / 11), (AGScreenManager.iScreenHeight / 100) * j);
            Configuracoes.blocos.add(bloco);
        }
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
