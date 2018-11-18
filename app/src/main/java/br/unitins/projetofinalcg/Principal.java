package br.unitins.projetofinalcg;

import android.os.Bundle;

import br.unitins.projetofinalcg.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {

    public static final int ABERTURA = 0;
    public static final int CONFIGURACOES = 1;
    public static final int CREDITOS = 2;
    public static final int MENU = 3;

    CenaAbertura abertura = null;
    CenaConfiguracoes configuracoes = null;
    CenaCreditos creditos = null;
    CenaMenu menu = null;
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
        //registra a cena ao gerenciador
        getGameManager().addScene(abertura);
        getGameManager().addScene(configuracoes);
        getGameManager().addScene(creditos);
        getGameManager().addScene(menu);

        getGameManager().setCurrentScene(ABERTURA);
    }
}