package br.unitins.projetofinalcg;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;
import br.unitins.projetofinalcg.AndGraph.AGScreenManager;
import br.unitins.projetofinalcg.AndGraph.AGSoundManager;
import br.unitins.projetofinalcg.AndGraph.AGSprite;
import br.unitins.projetofinalcg.AndGraph.AGTimer;

public class CenaMenu extends AGScene {
    private AGSprite background = null;
    private AGSprite playButton = null;
    private AGSprite helpButton = null;
    private int codSom = 0;

    public CenaMenu(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        codSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav");


        background = createSprite(R.mipmap.background, 1, 1);
        background.setScreenPercent(100, 100);
        background.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);


        playButton = createSprite(R.mipmap.playbutton, 1, 1);
        playButton.setScreenPercent(20, 20);
        playButton.vrPosition.setXY(AGScreenManager.iScreenWidth / 8, (AGScreenManager.iScreenHeight / 9) * 8);

        helpButton = createSprite(R.mipmap.helpbutton, 1, 1);
        helpButton.setScreenPercent(20, 10);
        helpButton.vrPosition.setXY(AGScreenManager.iScreenWidth / 7, (AGScreenManager.iScreenHeight / 10) * 6);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {

        if (AGInputManager.vrTouchEvents.screenClicked()) {
            AGSoundManager.vrSoundEffects.play(codSom);
            if (playButton.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                vrGameManager.setCurrentScene(Principal.JOGO);
                return;
            }
            if (helpButton.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                vrGameManager.setCurrentScene(Principal.CREDITOS);
                return;
            }


        }
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(Principal.CREDITOS);
            return;
        }

    }
}
