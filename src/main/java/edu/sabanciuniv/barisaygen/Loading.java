package edu.sabanciuniv.barisaygen;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class Loading {

    Activity activity;
    AlertDialog alertDialog;

    Loading(Activity activity){
        this.activity = activity;
    }

    void DismissDialog(){
        alertDialog.dismiss();
    }

    void StartDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.layout_loading, null));
        builder.setCancelable(false);
        alertDialog = builder.create();
        alertDialog.show();
    }
}
