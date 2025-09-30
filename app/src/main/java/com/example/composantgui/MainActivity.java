package com.example.composantgui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar bar = (ProgressBar) findViewById(R.id.progress);
        final Handler handler = new Handler();
        Thread worker = new Thread(new Runnable() {
            public void run() {
                while (progress < 100) {
                    try {

                        Thread.sleep(200);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        public void run() {
                            bar.setProgress(++progress);
                        }
                    });
                }
            }
        });
        worker.start();
    }
}