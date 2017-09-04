package com.mranuran.amazonprogressbarexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mranuran.amazonprogressbar.AmazonProgressbarView;

public class MainActivity extends AppCompatActivity {
    AmazonProgressbarView amazonProgressbarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amazonProgressbarView=(AmazonProgressbarView)findViewById(R.id.progressBar);
        amazonProgressbarView.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                amazonProgressbarView.stop();
            }
        },5000);

    }
}
