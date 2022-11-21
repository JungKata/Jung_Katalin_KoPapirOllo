package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView geplife1;
    private ImageView geplife2;
    private ImageView geplife3;
    private ImageView jatekoslife1;
    private ImageView jatekoslife2;
    private ImageView jatekoslife3;
    private ImageView enValasztas;
    private ImageView gepValasztas;
    private ImageButton KoButton;
    private ImageButton PapirButton;
    private ImageButton OlloButton;
    private final Random random = new Random();
    private int robotDontes;
    private int jatekos;
    private TextView DontetlenekSzama;
    private int ember = 0;
    private int gep = 0;
    private int dontetlenertek = 0;
    private TextView Eredmeny;
    private int ensziv= 0;
    private int robotelet = 0;
    private AlertDialog.Builder UjJatekAlert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        KoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekos = 0;
                enValasztas.setImageResource(R.drawable.rock);
                RobotValasztas();
                KiAGyoztes();

            }
        });

        PapirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekos = 1;
                enValasztas.setImageResource(R.drawable.paper);
                RobotValasztas();
                KiAGyoztes();

            }
        });

        OlloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jatekos = 2;
                enValasztas.setImageResource(R.drawable.scissors);
                RobotValasztas();
                KiAGyoztes();

            }
        });

    }


    private void RobotValasztas(){
        robotDontes = random.nextInt(3);
        switch (robotDontes){
            case 0 : gepValasztas.setImageResource(R.drawable.rock); break;
            case 1 : gepValasztas.setImageResource(R.drawable.paper);break;
            case 2 : gepValasztas.setImageResource(R.drawable.scissors);break;

        }
    }

    private void KiAGyoztes(){


        if (jatekos == robotDontes){
            Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
            dontetlenertek++;
            DontetlenekSzama.setText("Döntetlenek száma: " + dontetlenertek);



        }
        else if (jatekos == 0 && robotDontes == 2 || jatekos == 1 && robotDontes == 0 || jatekos == 2 && robotDontes == 1)  {
            ember++;
            //Eredmeny.setText("Eredmény: Ember: " + ember + " Conputer: " + gep);
            RobotElet();


        }
        else {
            gep++;
            EmberElet();

        }
        Gyoztes();
    }

   /* private void Nullazas(){
        jatekos = 0;
        robotDontes = 0;
    }*/

    private void EmberElet(){

        ensziv++;
        switch (ensziv){
            case 1 :  jatekoslife1.setImageResource(R.drawable.heart1);break;
            case 2 : jatekoslife2.setImageResource(R.drawable.heart1);break;
            case 3 : jatekoslife3.setImageResource(R.drawable.heart1);break;
        }

    }

    private void RobotElet(){

        robotelet++;
        switch (robotelet){
            case 1 :  geplife1.setImageResource(R.drawable.heart1);break;
            case 2 : geplife2.setImageResource(R.drawable.heart1);break;
            case 3 : geplife3.setImageResource(R.drawable.heart1);break;
        }

    }

    private void Gyoztes(){
        if (ensziv == 3) {
            UjJatekAlert = new AlertDialog.Builder(MainActivity.this);
            UjJatekAlert.setTitle("Győzelem");
            UjJatekAlert.setMessage("Szeretne új játékot játszani?");
            UjJatekAlert.setCancelable(false);
            UjJatekAlert.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Kezdes();
                }
            });
            UjJatekAlert.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            UjJatekAlert.create().show();
        }
        else if (robotelet == 3){
            UjJatekAlert = new AlertDialog.Builder(MainActivity.this);
            UjJatekAlert.setTitle("Veresség");
            UjJatekAlert.setMessage("Szeretne új játékot játszani?");
            UjJatekAlert.setCancelable(false);
            UjJatekAlert.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Kezdes();
                }
            });
            UjJatekAlert.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
            });
            UjJatekAlert.create().show();
        }
    }

    private void Kezdes(){
        ensziv = 0;
        robotelet = 0;
        dontetlenertek = 0;
        gepValasztas.setImageResource(R.drawable.rock);
        enValasztas.setImageResource(R.drawable.rock);
        jatekoslife1.setImageResource(R.drawable.heart2);
        jatekoslife2.setImageResource(R.drawable.heart2);
        jatekoslife3.setImageResource(R.drawable.heart2);
        geplife1.setImageResource(R.drawable.heart2);
        geplife2.setImageResource(R.drawable.heart2);
        geplife3.setImageResource(R.drawable.heart2);
    }

    private void init() {
    geplife1 = findViewById(R.id.geplife1);
    geplife2 = findViewById(R.id.geplife2);
    geplife3 = findViewById(R.id.geplife3);
    jatekoslife1 = findViewById(R.id.jatekoslife1);
    jatekoslife2 = findViewById(R.id.jatekoslife2);
    jatekoslife3 = findViewById(R.id.jatekoslife3);
    enValasztas = findViewById(R.id.enValasztas);
    gepValasztas = findViewById(R.id.gepValasztas);
    KoButton = findViewById(R.id.koButton);
    PapirButton = findViewById(R.id.papirButton);
    OlloButton = findViewById(R.id.olloButton);
    DontetlenekSzama = findViewById(R.id.dontetlenekSzama);
    Eredmeny = findViewById(R.id.eredmeny);



    }
}
