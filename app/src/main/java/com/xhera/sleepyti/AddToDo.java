package com.xhera.sleepyti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AddToDo extends AppCompatActivity {

    private EditText title, desc;
    private CardView add;
    private DbHandler dbHandler;
    private Context context;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_add_to_do);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_addTask);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        title =findViewById(R.id.editTextTitle);
        desc =findViewById(R.id.editTextDescription);
        add = findViewById(R.id.buttonadd);
        context =this;
        dbHandler =new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usertitle= title.getText().toString();
                String userDesc =desc.getText().toString();

                if (!TextUtils.isEmpty(usertitle)){
                    long started = System.currentTimeMillis();
//
                    ToDo toDo= new ToDo(usertitle,userDesc,started,0);
                    dbHandler.addToDo(toDo);
                    startActivity(new Intent(context,MainActivity2.class));
                    finish();

                }else
                    Toast.makeText(context, "Please enter a title for the task!", Toast.LENGTH_SHORT).show();


            }
        });



    }
}