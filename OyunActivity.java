package com.worldofwords.worldofwords.Activity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nex3z.flowlayout.FlowLayout;
import com.worldofwords.worldofwords.Helper.DatabaseHelper;
import com.worldofwords.worldofwords.Model.Kelime;
import com.worldofwords.worldofwords.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class OyunActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnGeri, btnSure, btnSeviye, btnHarf1, btnHarf2, btnHarf3, btnHarf4, btnHarf5, btnTemizle, btnTamam;
    TextView tvKelime;
    FlowLayout flowlayout;
    //String[] data = {"EV","AV"};
    String uretilenKelime="";
    String dizi = "";

    int seviye_id,kelime_indis;

    ArrayList<Kelime> kelimeler;
    ArrayList<Integer> uretilenKelimeIndisler = new ArrayList<>();

    public void harfEkle(String c){
        uretilenKelime += c;
    }

    public void kelimeHarfleriGetir(String kelime){
            for (int y=0; y<kelime.length(); y++){
                Button btn = new Button(this);
                btn.setId(y);
                btn.setBackgroundResource(R.drawable.button_shape);
                btn.setLayoutParams(new LinearLayout.LayoutParams(80,80));
                btn.setGravity(Gravity.CENTER);
                flowlayout.addView(btn);
            }
        }




    public void tumKelimeleriGetir(int kelime_sayisi,String kelime){
        for (int i=0; i<kelime_sayisi; i++){
            kelimeHarfleriGetir(kelime);
        }
    }

    public void degerleriTemizle(){
        try {
            flowlayout.removeAllViews();
            uretilenKelime = "";

        }catch (Exception e){

        }

    }

    public void soruHarfleriGuncelle(String uretilenYeniKelime){
        Button b = findViewById(uretilenYeniKelime.length());
        b.setText("");
    }


    public void soruGetir(){

        kelimeHarfleriGetir(kelimeler.get(kelime_indis).getKelime());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_oyun);


        try {
            dbHelper = new DatabaseHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

       kelimeler = dbHelper.getKelimeler(seviye_id);


        final MediaPlayer btnTıklama = MediaPlayer.create(this, R.raw.buttonclick);

        btnGeri = findViewById(R.id.btnGeri);
        btnSure = findViewById(R.id.btnSure);
        btnSeviye = findViewById(R.id.btnSeviye);
        btnHarf1 = findViewById(R.id.btnHarf1);
        btnHarf2 = findViewById(R.id.btnHarf2);
        btnHarf3 = findViewById(R.id.btnHarf3);
        btnHarf4 = findViewById(R.id.btnHarf4);
        btnHarf5 = findViewById(R.id.btnHarf5);
        tvKelime = findViewById(R.id.tvKelime);
        btnTemizle = findViewById(R.id.btnTemizle);
        btnTamam = findViewById(R.id.btnTamam);
        flowlayout = findViewById(R.id.flowlayout);


        tumKelimeleriGetir(2,"MERVE");

        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnHarf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                btnHarf1.setBackgroundResource(R.drawable.squaretik);
                uretilenKelime += btnHarf1.getText();
                tvKelime.setText(uretilenKelime);


            }
        });

        btnHarf2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                btnHarf2.setBackgroundResource(R.drawable.squaretik);
                uretilenKelime += btnHarf2.getText();
                tvKelime.setText(uretilenKelime);
            }
        });

        btnHarf3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                btnHarf3.setBackgroundResource(R.drawable.squaretik);
                uretilenKelime += btnHarf3.getText();
                tvKelime.setText(uretilenKelime);
            }
        });

        btnHarf4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                btnHarf4.setBackgroundResource(R.drawable.squaretik);
                uretilenKelime += btnHarf4.getText();
                tvKelime.setText(uretilenKelime);
            }
        });

        btnHarf5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                btnHarf5.setBackgroundResource(R.drawable.squaretik);
                uretilenKelime += btnHarf5.getText();
                tvKelime.setText(uretilenKelime);
            }
        });

        btnTemizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
                uretilenKelime = "";
                tvKelime.setText(uretilenKelime);
                btnHarf1.setBackgroundResource(R.drawable.square);
                btnHarf2.setBackgroundResource(R.drawable.square);
                btnHarf3.setBackgroundResource(R.drawable.square);
                btnHarf4.setBackgroundResource(R.drawable.square);
                btnHarf5.setBackgroundResource(R.drawable.square);
            }
        });

        btnTamam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTıklama.start();
            }
        });


    }

}
