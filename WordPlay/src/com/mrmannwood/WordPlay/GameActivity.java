package com.mrmannwood.WordPlay;

import android.os.Bundle;

public class GameActivity extends WordplayActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_activity);

        NetworkManager manager = NetworkManager.getNetworkManager();

        manager.saveTestObject();

    }

}
