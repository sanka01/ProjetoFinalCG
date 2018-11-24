package br.unitins.projetofinalcg;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;
import br.unitins.projetofinalcg.AndGraph.AGScreenManager;
import br.unitins.projetofinalcg.AndGraph.AGSoundManager;
import br.unitins.projetofinalcg.AndGraph.AGSprite;
import br.unitins.projetofinalcg.AndGraph.AGTimer;

public class CenaAbertura extends AGScene {

    AGTimer timer = null;
    private AGSprite background = null;


    public CenaAbertura(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        AGSoundManager.vrMusic.loadMusic("arkanoid.mp3", true);
        AGSoundManager.vrMusic.play();
        AGSoundManager.vrMusic.setVolume(0.3f, 0.3f);
        //chamado toda vez que uma cena é apresentada
        setSceneBackgroundColor(1, 1, 0);
        timer = new AGTimer(3000);
        background = createSprite(R.mipmap.logo,1,1);
        background.setScreenPercent(100,100);
        background.vrPosition.setXY(AGScreenManager.iScreenWidth/2,AGScreenManager.iScreenHeight/2);
    }

    @Override
    public void restart() {
        //Chamado na volta de uma interrupção

    }

    @Override
    public void stop() {
        //Chamado quando a interrupção ocorrer

    }

    @Override
    public void loop() {
        //Metodo Chamado N vezes por segundo que ira
        // controlar a logica da cena

        timer.update();
        if ( timer.isTimeEnded() ||
                AGInputManager.vrTouchEvents.screenClicked()) {
            vrGameManager.setCurrentScene(Principal.MENU);
            return;
        }


    }
}
