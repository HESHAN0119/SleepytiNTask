package com.xhera.sleepyti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.text.DecimalFormat;

public class Times extends AppCompatActivity {


    TextView hour1,minute1,hour2,minute2,hour3,minute3,hour4,minute4,hour5,minute5,hour6,minute6,Ap1,Ap2,Ap3,Ap4,Ap5,Ap6;
    int hh1,hh2,hh3,hh4,hh5,hh6;
    int mm1,mm2,mm3,mm4,mm5,mm6;
    String ap1,ap2,ap3,ap6,ap4,ap5,heading;
    ImageView alarm;
    CardView viewTask,addTask;
    AdView mAdView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_times);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_times);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        hour1=findViewById(R.id.hour1);
        minute1=findViewById(R.id.minute1);

        hour2=findViewById(R.id.hour2);
        minute2=findViewById(R.id.minute2);

        hour3=findViewById(R.id.hour3);
        minute3=findViewById(R.id.minute3);

        hour4=findViewById(R.id.hour4);
        minute4=findViewById(R.id.minute4);

        hour5=findViewById(R.id.hour5);
        minute5=findViewById(R.id.minute5);

        hour6=findViewById(R.id.hour6);
        minute6=findViewById(R.id.minute6);

        viewTask = findViewById(R.id.myTaskButton);
        viewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Times.this, MainActivity2.class));
                finish();
            }
        });

        addTask= findViewById(R.id.addTaskButton);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Times.this,AddToDo.class));
                finish();
            }
        });

        alarm= findViewById(R.id.alarmImage);
        alarm.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(Times.this, "Set Alarm", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent alarm=new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(alarm);
                finish();

            }
        });


        Ap1=findViewById(R.id.ampm1);
        Ap2=findViewById(R.id.ampm2);
        Ap3=findViewById(R.id.ampm3);
        Ap4=findViewById(R.id.ampm4);
        Ap5=findViewById(R.id.ampm5);
        Ap6=findViewById(R.id.ampm6);


        TextView title=findViewById(R.id.title);

        Intent result2=getIntent();
        Bundle extras= result2.getExtras();

        hh1 = extras.getInt("NHOURS1",0);
        mm1 = extras.getInt("NMINUTES1",0);

        hh2 = extras.getInt("NHOURS2",0);
        mm2 = extras.getInt("NMINUTES2",0);

        hh3 = extras.getInt("NHOURS3",0);
        mm3 = extras.getInt("NMINUTES3",0);

        hh4 = extras.getInt("NHOURS4",0);
        mm4 = extras.getInt("NMINUTES4",0);

        hh5 = extras.getInt("NHOURS5",0);
        mm5 = extras.getInt("NMINUTES5",0);

        hh6 = extras.getInt("NHOURS6",0);
        mm6 = extras.getInt("NMINUTES6",0);


        hour1.setText(String.valueOf(hh1));
        minute1.setText(String.valueOf(new DecimalFormat("00").format(mm1)));

        hour2.setText(String.valueOf(hh2));
        minute2.setText(String.valueOf(new DecimalFormat("00").format(mm2)));

        hour3.setText(String.valueOf(hh3));
        minute3.setText(String.valueOf(new DecimalFormat("00").format(mm3)));

        hour4.setText(String.valueOf(hh4));
        minute4.setText(String.valueOf(new DecimalFormat("00").format(mm4)));

        hour5.setText(String.valueOf(hh5));
        minute5.setText(String.valueOf(new DecimalFormat("00").format(mm5)));

        hour6.setText(String.valueOf(hh6));
        minute6.setText(String.valueOf(new DecimalFormat("00").format(mm6)));

        ap1=extras.getString("AP1");
        Ap1.setText(ap1);

        ap2=extras.getString("AP2");
        Ap2.setText(ap2);

        ap3=extras.getString("AP3");
        Ap3.setText(ap3);

        ap4=extras.getString("AP4");
        Ap4.setText(ap4);

        ap5=extras.getString("AP5");
        Ap5.setText(ap5);

        ap6=extras.getString("AP6");
        Ap6.setText(ap6);

        heading=extras.getString("TITLE");
        title.setText(heading);


    }
}