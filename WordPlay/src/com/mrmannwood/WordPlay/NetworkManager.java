package com.mrmannwood.WordPlay;

import com.parse.Parse;
import com.parse.ParseObject;

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
    }

    public void saveTestObject(){
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("test", "test2");
        testObject.saveInBackground();
    }

}
