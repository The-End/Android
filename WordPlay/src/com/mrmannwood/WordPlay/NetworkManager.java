package com.mrmannwood.WordPlay;

import android.widget.Toast;
import com.mrmannwood.WordPlay.DataObjects.Move;
import com.mrmannwood.WordPlay.DataObjects.PlayerMove;
import com.mrmannwood.WordPlay.DataObjects.Round;
import com.parse.*;

public class NetworkManager {

    static NetworkManager manager;

    static NetworkManager getNetworkManager(){
        if(manager == null){
            manager = new NetworkManager();
        }
        return manager;
    }

    private NetworkManager(){
        Parse.initialize(WordplayActivity.applicationContext(),
                "MxM9S6cX33zRIJuN1qjQJUgbXSVrD0o6IeEdPRCy", "kvyyq5akN2jemgf4eKVSl6Q73DB69fWbNP2ZYmKV");
        ParseObject.registerSubclass(Move.class);
        ParseObject.registerSubclass(PlayerMove.class);
        ParseObject.registerSubclass(Round.class);
    }

}
