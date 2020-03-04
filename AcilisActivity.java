package com.worldofwords.worldofwords.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.worldofwords.worldofwords.R;

public class AcilisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_acilis);

        new Beklet().start();

    }

    private class Beklet extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(3000);
            }catch (Exception e){}

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }
}
