package com.example.customcoloring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * class MainActivity
 *
 * A class that creates objects of android game controllers and custom objects
 * to create game interactions.
 *
 * @author Milton Nguy
 * @version 10 February 2022
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDrawings drawings = findViewById(R.id.bobross);
        TextView elementTV = findViewById(R.id.element);

        SeekBar redSB = findViewById(R.id.redSB);
        SeekBar greenSB = findViewById(R.id.greenSB);
        SeekBar blueSB = findViewById(R.id.blueSB);

        TextView redTV = findViewById(R.id.redTV);
        TextView greenTV = findViewById(R.id.greenTV);
        TextView blueTV = findViewById(R.id.blueTV);

        //adds all Android controllers to a controller class
        CustomController drawingCC = new CustomController(drawings, elementTV, redSB, greenSB, blueSB, redTV, greenTV, blueTV);
        drawings.setOnTouchListener(drawingCC);

        //makes it so that interactions with seekbars will link to CustomController class
        redSB.setOnSeekBarChangeListener(drawingCC);
        blueSB.setOnSeekBarChangeListener(drawingCC);
        greenSB.setOnSeekBarChangeListener(drawingCC);






    }

}