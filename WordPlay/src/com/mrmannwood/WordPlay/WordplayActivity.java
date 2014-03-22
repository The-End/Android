package com.mrmannwood.WordPlay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class WordplayActivity extends Activity {

    static Context currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentActivity = this;
    }

    @Override
    protected void onStart(){
        super.onStart();

        currentActivity = this;
    }

    @Override
    protected void onResume(){
        super.onResume();

        currentActivity = this;
    }

    public static Context activityContext(){
        return currentActivity;
    }

    public static Context applicationContext(){
        return currentActivity.getApplicationContext();
    }
}
