package br.unitins.projetofinalcg;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;

public class CenaCreditos  extends AGScene {

    public  CenaCreditos(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() {
        setSceneBackgroundColor(0,0,1);

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        if (AGInputManager.vrTouchEvents.screenClicked()){
            vrGameManager.setCurrentScene(Principal.MENU);
        }
        if (AGInputManager.vrTouchEvents.backButtonClicked()){
            vrGameManager.vrActivity.finish();
        }

    }
}
