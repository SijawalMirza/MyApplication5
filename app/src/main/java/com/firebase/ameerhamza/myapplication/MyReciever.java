package com.firebase.ameerhamza.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getBooleanExtra("state",false))
        {
            Toast.makeText(context,"Connected to internet now",Toast.LENGTH_SHORT);

        }
        else{
            Toast.makeText(context,"Connection lost",Toast.LENGTH_SHORT);
        }

    }
}
