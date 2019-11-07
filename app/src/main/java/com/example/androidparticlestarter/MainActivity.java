package com.example.androidparticlestarter;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.cloud.ParticleEvent;
import io.particle.android.sdk.cloud.ParticleEventHandler;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import io.particle.android.sdk.utils.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.callback.Callback;


public class MainActivity extends AppCompatActivity {
    // MARK: Debug info
    private final String TAG="";

    // MARK: Particle Account Info
    private final String PARTICLE_USERNAME = "simranbal01@gmail.com";
    private final String PARTICLE_PASSWORD = "Nirvair@99";

    // MARK: Particle device-specific info
    private final String DEVICE_ID = "340036000f47363333343437";

    // MARK: Particle Publish / Subscribe variables
    private long subscriptionId;
    Button monitorButton;
    TextView textView;
    Handler handler;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] ListElements = new  String[] {};
    long Millisecondtime, StartTime, TimeBuff, UpdateTime = 0L ;
    int seconds , minutes, milliseconds;

    List<String> ArrayListelement;


    String ans = "0";
    String ans1 = "4";
    String ans2 = "9";
    String ans3 = "14";
    String ans4 = "19";
    String ans5 = "20";



    // MARK: Particle device
    private ParticleDevice mDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monitorButton= findViewById(R.id.timerButton);
        textView = findViewById(R.id.showTime);
////        long time = 0;
////
////        long millis = System.currentTimeMillis() = time;
////        int seconds = (int)
//
//        handler = new Handler();
//        ArrayListelement = new ArrayList<String>(Arrays.asList(ListElements));
//        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple)

//

        monitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartTime = (int) SystemClock.uptimeMillis();
                handler.postDelayed(runnable,0);
            }


            public Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Millisecondtime = (int) SystemClock.uptimeMillis() - StartTime;
                    UpdateTime = TimeBuff + Millisecondtime;
                    seconds = (int) (UpdateTime / 1000);
                    minutes = seconds / 60;
                    seconds = seconds %60;
                    milliseconds = (int) (UpdateTime % 1000);
                    textView.setText("" + minutes + String.format("%02d",seconds) + ":" + String.format("%03d",milliseconds) );


                    if (String.valueOf(seconds).equals(ans))
                    {
                        second("positive");
                    }

                    // try catch



                    handler.postDelayed(this,0);
                }
            };
        });

            }

    {
        // 1. Initialize your connection to the Particle API
        ParticleCloudSDK.init(this.getApplicationContext());

        // 2. Setup your device variable
        getDeviceFromCloud();

    }






    /**
     * Custom function to connect to the Particle Cloud and get the device
     */
    public void getDeviceFromCloud() {
        // This function runs in the background
        // It tries to connect to the Particle Cloud and get your device
        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {

            @Override
            public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {
                particleCloud.logIn(PARTICLE_USERNAME, PARTICLE_PASSWORD);
                mDevice = particleCloud.getDevice(DEVICE_ID);
                return -1;
            }

            @Override
            public void onSuccess(Object o) {
                Log.d(TAG, "Successfully got device from Cloud");
            }

            @Override
            public void onFailure(ParticleCloudException exception) {
                Log.d(TAG, exception.getBestMessage());
            }
        });
    }
    public void second(String second)
    {

        Log.d(TAG, "positive:");
        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {
            @Override
            public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {
                // put your logic here to talk to the particle
                // --------------------------------------------
                List<String> functionParameters = new ArrayList<String>();
//                functionParameters.add();
                try {
                    mDevice.callFunction(""+ second, functionParameters);

                } catch (ParticleDevice.FunctionDoesNotExistException e1) {
                    e1.printStackTrace();
                }


                return -1;
            }

            @Override
            public void onSuccess(Object o) {
                // put your success message here
                Log.d(TAG, "Success: Turned light green!!");
            }

            @Override
            public void onFailure(ParticleCloudException exception) {
                // put your error handling code here
                Log.d(TAG, exception.getBestMessage());
            }
        });
    }




}


