package br.unitins.projetofinalcg;

import android.os.Bundle;

import br.unitins.projetofinalcg.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {

    //ID para as telas
    public static final int ABERTURA = 0;
    public static final int CONFIGURACOES = 1;
    public static final int CREDITOS = 2;
    public static final int MENU = 3;
    public static final int FASE1 = 4;
    public static final int FASE2 = 5;

    CenaAbertura abertura = null;
    CenaConfiguracoes configuracoes = null;
    CenaCreditos creditos = null;
    CenaMenu menu = null;
    CenaFase1 fase1 = null;
    CenaFase2 fase2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //dá a partida no motor
        this.init(this,false); // init(activity, temAcelerometro?)


        //Instancia do objeto de cena
        abertura = new CenaAbertura(getGameManager());
        configuracoes = new CenaConfiguracoes(getGameManager());
        creditos = new CenaCreditos(getGameManager());
        menu = new CenaMenu(getGameManager());
        fase1 = new CenaFase1(getGameManager());
        fase2 = new CenaFase2(getGameManager());
        //registra a cena ao gerenciador
        getGameManager().addScene(abertura);
        getGameManager().addScene(configuracoes);
        getGameManager().addScene(creditos);
        getGameManager().addScene(menu);
        getGameManager().addScene(fase1);
        getGameManager().addScene(fase2);

        getGameManager().setCurrentScene(ABERTURA);
    }
}