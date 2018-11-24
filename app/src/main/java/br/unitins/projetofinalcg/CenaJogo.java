package br.unitins.projetofinalcg;

import java.util.ArrayList;

import br.unitins.projetofinalcg.AndGraph.AGGameManager;
import br.unitins.projetofinalcg.AndGraph.AGInputManager;
import br.unitins.projetofinalcg.AndGraph.AGScene;
import br.unitins.projetofinalcg.AndGraph.AGScreenManager;
import br.unitins.projetofinalcg.AndGraph.AGSprite;

public class CenaJogo extends AGScene {


    private AGSprite forma = null;
    private AGSprite background = null;
    private AGSprite bola = null;
    private int direcaoX = 1, direcaoY = 1;
    private ArrayList<AGSprite> blocos = null;

    public CenaJogo(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {

        background = createSprite(R.mipmap.backgroundfase1, 1, 1);
        background.setScreenPercent(100, 100);
        background.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, AGScreenManager.iScreenHeight / 2);

        blocos = new ArrayList<>();
        //chamado toda vez que uma cena é apresentada
        setSceneBackgroundColor(1, 1, 1);

        forma = createSprite(R.mipmap.forma, 1, 1);
        forma.setScreenPercent(15, 2);
        forma.vrPosition.setXY((AGScreenManager.iScreenWidth / 100) * 50, (AGScreenManager.iScreenHeight / 100) * 10);

        bola = createSprite(R.mipmap.bola, 1, 1);
        bola.setScreenPercent(5, 5);
        bola.vrPosition.setXY((AGScreenManager.iScreenWidth / 100) * 50, (AGScreenManager.iScreenHeight / 100) * 14);


        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.silverwall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 90);
            blocos.add(bloco);
        }
        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.redwall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 85);
            blocos.add(bloco);
        }
        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.bluewall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 80);
            blocos.add(bloco);
        }
        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.orangewall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 75);
            blocos.add(bloco);
        }
        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.pinkwall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 70);
            blocos.add(bloco);
        }
        for (int i = 1; i < 11; i++) {
            AGSprite bloco = createSprite(R.mipmap.greenwall, 1, 1);
            bloco.setScreenPercent(9, 5);
            bloco.vrPosition.setXY((AGScreenManager.iScreenWidth / 11) * i, (AGScreenManager.iScreenHeight / 100) * 65);
            blocos.add(bloco);
        }

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {


        for (AGSprite bloco :
                blocos) {
            if (bloco.collide(bola)) {
                blocos.remove(bloco);
                direcaoX *= -1;
                direcaoY *= -1;
            }

        }

        if (forma.collide(bola)) {
            direcaoX *= -1;
            direcaoY *= -1;
        }


        bola.vrPosition.setXY(bola.vrPosition.getX() + direcaoX, bola.vrPosition.getY() + direcaoY);
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(Principal.MENU);
        }


    }
}
