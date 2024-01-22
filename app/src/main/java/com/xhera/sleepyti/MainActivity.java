package com.xhera.sleepyti;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int hours, newhours1;
    int minutes, newminutes1;
    String ampm1, ampm2,ampm;
    String ap1, ap2, ap3, ap4, ap5, ap6;

    EditText hourvalues,minutesvalue;
    CardView am1,pm1,am2,pm2,wakeUp,sleep,goTask,addTask;

    AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_main);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        am1= findViewById(R.id.am1);
        pm1= findViewById(R.id.pm1);

        am2= findViewById(R.id.am2);
        pm2= findViewById(R.id.pm2);

        wakeUp=findViewById(R.id.button_wake);
        sleep= findViewById(R.id.button_sleep);

        goTask= findViewById(R.id.myTaskCard);
        addTask = findViewById(R.id.addMyTaskCard);

        am1.setOnClickListener(this);
        pm1.setOnClickListener(this);

        am2.setOnClickListener(this);
        pm2.setOnClickListener(this);

        wakeUp.setOnClickListener(this);
        sleep.setOnClickListener(this);

        goTask.setOnClickListener(this);
        addTask.setOnClickListener(this);


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.am1:
                ampm="AM";

                am1.setCardBackgroundColor(Color.CYAN);

                am2.setCardBackgroundColor(Color.WHITE);
                pm1.setCardBackgroundColor(Color.WHITE);
                pm2.setCardBackgroundColor(Color.WHITE);
                break;
            case R.id.am2:
                ampm="AM";
                am2.setCardBackgroundColor(Color.CYAN);

                am1.setCardBackgroundColor(Color.WHITE);
                pm1.setCardBackgroundColor(Color.WHITE);
                pm2.setCardBackgroundColor(Color.WHITE);
                break;
            case R.id.pm1:
                ampm="PM";
                pm1.setCardBackgroundColor(Color.CYAN);
                am2.setCardBackgroundColor(Color.WHITE);
                am1.setCardBackgroundColor(Color.WHITE);
                pm2.setCardBackgroundColor(Color.WHITE);
                break;
            case R.id.pm2:
                ampm="PM";
                pm2.setCardBackgroundColor(Color.CYAN);
                am2.setCardBackgroundColor(Color.WHITE);
                pm1.setCardBackgroundColor(Color.WHITE);
                am1.setCardBackgroundColor(Color.WHITE);
                break;

            case R.id.button_wake:
                btnwakeup();
                break;

            case R.id.button_sleep:
                btnSleep();
                break;

            case R.id.addMyTaskCard:
                startActivity(new Intent(MainActivity.this, AddToDo.class));
                break;

            case R.id.myTaskCard:
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                break;


        }

    }

    private void btnSleep() {

        hourvalues= findViewById(R.id.hour2);
        minutesvalue= findViewById(R.id.minute2);

        if (!TextUtils.isEmpty(hourvalues.getText().toString()) && !TextUtils.isEmpty(minutesvalue.getText().toString())){
            hours= Integer.parseInt(hourvalues.getText().toString());
            minutes = Integer.parseInt(minutesvalue.getText().toString());

            if (minutes < 60) {


                int mini = (hours * 60) + minutes;
                int nhours = hours + 12;
                int minitime = nhours * 60 + minutes;


                if (Objects.equals(ampm, "AM")) {
                    if (mini >= 720) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else if (mini >= 540) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else if (mini >= 450) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = "AM";
                        ap6 = "PM";
                    } else if (mini >= 360) {
                        ap1 = ap2 = ap3 = ap4 = "AM";
                        ap5 = ap6 = "PM";
                    } else if (mini >= 270) {
                        ap1 = ap2 = ap3 = "AM";
                        ap4 = ap5 = ap6 = "PM";
                    } else if (mini >= 180) {
                        ap1 = ap2 = "AM";
                        ap3 = ap4 = ap5 = ap6 = "PM";
                    } else if (mini >= 90) {
                        ap1 = "AM";
                        ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    }
                } else {

                    if (mini >= 720) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else if (mini >= 540) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else if (mini >= 450) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = "PM";
                        ap6 = "AM";
                    } else if (mini >= 360) {
                        ap1 = ap2 = ap3 = ap4 = "PM";
                        ap5 = ap6 = "AM";
                    } else if (mini >= 270) {
                        ap1 = ap2 = ap3 = "PM";
                        ap4 = ap5 = ap6 = "AM";
                    } else if (mini >= 180) {
                        ap1 = ap2 = "PM";
                        ap3 = ap4 = ap5 = ap6 = "AM";
                    } else if (mini >= 90) {
                        ap1 = "PM";
                        ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    }


                }


                //First Time set
                newhours1 = Math.abs((minitime - 90) / 60);
                newminutes1 = 60 - Math.abs((minutes - 90) % 60);
                if (newminutes1 == 60) {
                    newminutes1 = 0;
                }
                if (newhours1 > 12) {
                    newhours1 -= 12;

                }
//
//
//        //Second time set
                int newhours2 = Math.abs((minitime - 180) / 60);
                int newminutes2 = 60 - Math.abs((minutes - 180) % 60);
                if (newminutes2 == 60) {
                    newminutes2 = 0;
                }

                if (newhours2 > 12) {
                    newhours2 -= 12;
                }


//
//        //Third time set
                int newhours3 = Math.abs((minitime - 270) / 60);
                int newminutes3 = 60 - Math.abs((minutes - 270) % 60);
                if (newminutes3 == 60) {
                    newminutes3 = 0;
                }

                if (newhours3 > 12) {
                    newhours3 -= 12;

                }


//
//
//        //Fourth Time set
                int newhours4 = Math.abs((minitime - 90 * 4) / 60);
                int newminutes4 = 60 - Math.abs((minutes - 90 * 4) % 60);

                if (newminutes4 == 60) {
                    newminutes4 = 0;
                }
                if (newhours4 > 12) {
                    newhours4 -= 12;

                }


                //Fifth time set
                int newhours5 = (minitime - 90 * 5) / 60;
                int newminutes5 = 60 - Math.abs((minutes - 90 * 5) % 60);
                if (newminutes5 == 60) {
                    newminutes5 = 0;
                }

                if (newhours5 > 12) {
                    newhours5 -= 12;
                }


                //Sixth time set
                int newhours6 = (minitime - 90 * 6) / 60;
                int newminutes6 = 60 - Math.abs((minutes - 90 * 6) % 60);
                if (newminutes6 == 60) {
                    newminutes6 = 0;
                }

                if (newhours6 > 12) {
                    newhours6 -= 12;

                }


                Intent result = new Intent(this, Times.class);
                Bundle extras = new Bundle();
                extras.putInt("NHOURS1", newhours1);
                extras.putInt("NMINUTES1", newminutes1);

                extras.putInt("NHOURS2", newhours2);
                extras.putInt("NMINUTES2", newminutes2);

                extras.putInt("NHOURS3", newhours3);
                extras.putInt("NMINUTES3", newminutes3);

                extras.putInt("NHOURS4", newhours4);
                extras.putInt("NMINUTES4", newminutes4);

                extras.putInt("NHOURS5", newhours5);
                extras.putInt("NMINUTES5", newminutes5);

                extras.putInt("NHOURS6", newhours6);
                extras.putInt("NMINUTES6", newminutes6);


                extras.putString("AP1", ap1);
                extras.putString("AP2", ap2);
                extras.putString("AP3", ap3);
                extras.putString("AP4", ap4);
                extras.putString("AP5", ap5);
                extras.putString("AP6", ap6);

                extras.putString("TITLE", "Best Times to Sleep");


                result.putExtras(extras);
                startActivity(result);


//             System.out.println(ampm1);
//
//
            }
            else {
//                Toasty.warning(this,"minutes must be less than 60", Toast.LENGTH_LONG).show();
            }



        }



    }

    private void btnwakeup() {

        hourvalues= findViewById(R.id.hour);
        minutesvalue= findViewById(R.id.minute);

        if (!TextUtils.isEmpty(hourvalues.getText().toString()) && !TextUtils.isEmpty(minutesvalue.getText().toString())){

            hours= Integer.parseInt(hourvalues.getText().toString());
            minutes = Integer.parseInt(minutesvalue.getText().toString());

            if (minutes<60) {
                if (hours > 12) {
                    hours -= 12;
                }

                int minitime = hours * 60 + minutes;

                if (!ampm.equals("AM")) {

                    if (minitime < 180) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else if (minitime < 270) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = "PM";
                        ap6 = "AM";
                    } else if (minitime < 360) {
                        ap1 = ap2 = ap3 = ap4 = "PM";
                        ap6 = "AM";
                        ap5 = "AM";
                    } else if (minitime < 450) {
                        ap1 = ap2 = ap3 = "PM";
                        ap6 = "AM";
                        ap5 = "AM";
                        ap4 = "AM";
                    } else if (minitime < 540) {
                        ap1 = "PM";
                        ap2 = "PM";
                        ap3 = ap4 = ap5 = ap6 = "AM";

                    } else if (minitime < 630) {
                        ap1 = "PM";
                        ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else if (720 <= minitime) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    }

                } else {

                    if (minitime < 180) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else if (minitime < 270) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = "AM";
                        ap6 = "PM";
                    } else if (minitime < 360) {
                        ap1 = ap2 = ap3 = ap4 = "AM";
                        ap6 = "PM";
                        ap5 = "PM";
                    } else if (minitime < 450) {
                        ap1 = ap2 = ap3 = "AM";
                        ap6 = "PM";
                        ap5 = "PM";
                        ap4 = "PM";
                    } else if (minitime < 540) {
                        ap1 = "AM";
                        ap2 = "PM";
                        ap3 = ap4 = ap5 = ap6 = "PM";

                    } else if (minitime < 630) {
                        ap1 = "AM";
                        ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    } else if (720 <= minitime) {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "AM";
                    } else {
                        ap1 = ap2 = ap3 = ap4 = ap5 = ap6 = "PM";
                    }

                    //            ap1=ap2=ap3=ap4=ap5=ap6="AM";
                }


                //First Time set
                newhours1 = (minitime + 90) / 60;
                newminutes1 = (minutes + 90) % 60;
                if (newhours1 > 12) {
                    newhours1 -= 12;

                }
                //        hh1 = Integer.toString(newhours1);


                //Second time set
                int newhours2 = (minitime + 180) / 60;
                int newminutes2 = (minutes + 180) % 60;
                if (newhours2 > 12) {
                    newhours2 -= 12;
                }

                //Third time set
                int newhours3 = (minitime + 270) / 60;
                int newminutes3 = (minutes + 270) % 60;
                if (newhours3 > 12) {
                    newhours3 -= 12;
                }


                //Fourth Time set
                int newhours4 = (minitime + 360) / 60;
                int newminutes4 = (minutes + 360) % 60;
                if (newhours4 > 12) {
                    newhours4 -= 12;
                }

                //Fifth time set
                int newhours5 = (minitime + 450) / 60;
                int newminutes5 = (minutes + 450) % 60;
                if (newhours5 > 12) {
                    newhours5 -= 12;
                }

                //Sixth time set
                int newhours6 = (minitime + 540) / 60;
                int newminutes6 = (minutes + 540) % 60;
                if (newhours6 > 12) {
                    newhours6 -= 12;
                }


//        n1.setText(ampm1);
//        System.out.println(newminutes6);


                //intent

                Intent result = new Intent(this, Times.class);
                Bundle extras = new Bundle();
                extras.putInt("NHOURS1", newhours1);
                extras.putInt("NMINUTES1", newminutes1);

                extras.putInt("NHOURS2", newhours2);
                extras.putInt("NMINUTES2", newminutes2);

                extras.putInt("NHOURS3", newhours3);
                extras.putInt("NMINUTES3", newminutes3);

                extras.putInt("NHOURS4", newhours4);
                extras.putInt("NMINUTES4", newminutes4);

                extras.putInt("NHOURS5", newhours5);
                extras.putInt("NMINUTES5", newminutes5);

                extras.putInt("NHOURS6", newhours6);
                extras.putInt("NMINUTES6", newminutes6);

                extras.putString("AP1", ap1);
                extras.putString("AP2", ap2);
                extras.putString("AP3", ap3);
                extras.putString("AP4", ap4);
                extras.putString("AP5", ap5);
                extras.putString("AP6", ap6);

                extras.putString("TITLE", "Best Times to Wake Up");


                result.putExtras(extras);
                startActivity(result);

            }
            else {
//                Toasty.warning(this,"minutes must be less than 60", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Minutes must be less than 60", Toast.LENGTH_SHORT).show();
            }



        }else
            Toast.makeText(this, "Please enter hour and minute value!", Toast.LENGTH_SHORT).show();


    }
}