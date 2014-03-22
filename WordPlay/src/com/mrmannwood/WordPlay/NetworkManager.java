package com.mrmannwood.WordPlay;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class NetworkManager {

    static NetworkManager manager;

    static NetworkManager getNetworkManager(){
        if(manager == null){
            manager = new NetworkManager();
        }
        return manager;
    }

    RequestQueue requests;

    private NetworkManager(){
        requests = Volley.newRequestQueue(WordplayActivity.currentActivity.getApplicationContext());
    }

    public void performRequest(Request request){
        requests.add(request);
    }

}
