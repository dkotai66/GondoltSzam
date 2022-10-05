package com.example.gyakorlat1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewElet1, imageViewElet2, imageViewElet3, imageViewElet4, imageViewElet5;
    private TextView textViewTipp;
    private Button buttonNovel, buttonCsokkent, buttonTipp, buttonKonnyu, buttonNehez;
    private int gondoltSzam, tippeltSzam, elet, maxSzam;
    private AlertDialog.Builder builderJatekvege, builderNehezseg;
    private Toast egyediToast;
    private boolean nehezseg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //ujJatek();

        buttonTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gondoltSzam<tippeltSzam){
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                    eletLevon();
                }else if(gondoltSzam>tippeltSzam){
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                    eletLevon();
                }else{
                    //set title módosítás
                    builderJatekvege.show();
                }
            }
        });

        buttonCsokkent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tippeltSzam>1){
                    tippeltSzam--;
                    textViewTipp.setText(String.valueOf(tippeltSzam));
                }
                else{
                    Toast.makeText(MainActivity.this, "A szám nem lehet kisebb mint 1" + maxSzam, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void eletLevon() {
        switch (elet){
            case 5:
                imageViewElet5.setImageResource(R.drawable.heart1);
                break;
            case 4:
                imageViewElet4.setImageResource(R.drawable.heart1);
                break;
            case 3:
                imageViewElet3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                imageViewElet2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                imageViewElet1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        elet--;
        if (elet<1){
            builderJatekvege.show();
        }
    }



    private void init(){
        imageViewElet1 = findViewById(R.id.imageElet1);
        imageViewElet1 = findViewById(R.id.imageElet2);
        imageViewElet1 = findViewById(R.id.imageElet3);
        imageViewElet1 = findViewById(R.id.imageElet4);
        imageViewElet1 = findViewById(R.id.imageElet5);
        textViewTipp = findViewById(R.id.textViewTipp);
        buttonNovel = findViewById(R.id.buttonNovel);
        buttonCsokkent = findViewById(R.id.buttonCsokkent);
        buttonTipp = findViewById(R.id.buttonTipp);
        buttonKonnyu = findViewById(R.id.buttonKonnyu);
        buttonNehez = findViewById(R.id.buttonNehez);
        maxSzam= 10;
        Random random = new Random();
        gondoltSzam = random.nextInt(maxSzam)+1;
        elet = 5;
        tippeltSzam = 0;

        builderJatekvege = new AlertDialog.Builder(MainActivity.this);
        builderJatekvege.setCancelable(false)
                .setTitle("Nyert/vesztett")
                .setMessage("Szeretne új játékot játszani? ")
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ujJatek();
                    }
                })
                .create();
    }
}