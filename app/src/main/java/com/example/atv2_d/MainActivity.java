package com.example.atv2_d;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    private double valorGasolina = 0.0;
    private double valorEtanol = 0.0;
    private TextView valseekBarGasolina;
    private TextView valseekBarEtanol;
   
    private ImageView imageView;

    private Drawable drawableGasolina;
    private Drawable drawableEtanol;

    private TextView totalTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valseekBarGasolina = findViewById(R.id.valseekBarGasolina);
        valseekBarEtanol = findViewById(R.id.valseekBarEtanol);
        totalTextView = findViewById(R.id.totalTextView);
        SeekBar seekbarEtanol = findViewById(R.id.seekbarEtanol);
        SeekBar seekbarGasolina = findViewById(R.id.seekbarGasolina);
        imageView = findViewById(R.id.imageView);


        drawableGasolina= getResources().getDrawable(R.drawable.gasolina);
        drawableEtanol = getResources().getDrawable(R.drawable.etanol);
        seekbarGasolina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress=progress + 450;
                valorGasolina = progress/100d;
                valseekBarGasolina.setText(currencyFormat.format(valorGasolina));
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbarEtanol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress=progress + 310;
                valorEtanol = progress / 100D;
                valseekBarEtanol.setText(currencyFormat.format(valorEtanol));
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
    private void calcular(){
        double total = valorEtanol / valorGasolina;
       // totalTextView.setText(currencyFormat.format(total));
        if(total >= 0.7){


            imageView.setImageDrawable(drawableGasolina);
        }
        else{
            imageView.setImageDrawable(drawableEtanol);
        }

    }

}
