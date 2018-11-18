package br.unitins.projetofinalcg;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;

public class CenaConfiguracoes  extends AGScene {

    public  CenaConfiguracoes(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() {
        this.setSceneBackgroundColor(0,1,0);

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if (AGInputManager.vrTouchEvents.backButtonClicked()){
            vrGameManager.vrActivity.finish();
        }
        if (AGInputManager.vrTouchEvents.screenClicked()){
            vrGameManager.setCurrentScene(Principal.MENU);
        }

    }
}
