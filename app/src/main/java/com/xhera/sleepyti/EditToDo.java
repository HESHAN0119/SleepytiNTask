package com.xhera.sleepyti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class EditToDo extends AppCompatActivity {


    private EditText title,des;
    private CardView edit;
    private DbHandler dbHandler;
    private Context context;
    private Long updateData;
     AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_edit_to_do);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_editTask);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        context = this;
        dbHandler =new DbHandler(context);
//
        title = findViewById(R.id.editToDoTextTitle);
        des =findViewById(R.id.editToDoTextDescription);
        edit =findViewById(R.id.buttonedit);
//
        final String id =getIntent().getStringExtra("id");
        System.out.println(id);
        ToDo todo= dbHandler.getSingleToDo(Integer.parseInt(id));
        title.setText(todo.getTitle());
        des.setText(todo.getDescription());



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleText =title.getText().toString();
                String decText = des.getText().toString();
                updateData =System.currentTimeMillis();

                ToDo toDo =new ToDo(Integer.parseInt(id),titleText,decText,updateData,0);
                int state =dbHandler.updateSingleToDo(toDo);
                System.out.println(state);
                finish();
                startActivity(new Intent(context,MainActivity2.class));

            }
        });

    }
}