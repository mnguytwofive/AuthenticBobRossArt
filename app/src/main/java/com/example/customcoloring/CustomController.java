

package com.example.customcoloring;

import android.graphics.Color;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;


/**
 * class CustomController
 *
 * This is a controller class for CustomDrawings that will register
 * specific in-game actions from interacting with surfaceview & seekbar.
 *
 * @author Milton Nguy
 *
 */

public class CustomController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {


    private CustomDrawings bob;
    private TextView elementTV;

    private SeekBar redSB;
    private SeekBar greenSB;
    private SeekBar blueSB;

    private TextView redTV;
    private TextView greenTV;
    private TextView blueTV;

    private CustomElement element1;
    private int color;

    //see onTouch method & onProgressChanged methods.
    private int alpha;
    private int red;
    private int green;
    private int blue;

    public CustomController(CustomDrawings a, TextView tv, SeekBar red, SeekBar green, SeekBar blue,
                            TextView redT,TextView greenT,TextView blueT) {

        //gains all xml controllers and initializes it to the private variables
        this.bob = a;
        this.elementTV = tv;

        this.redSB = red;
        this.greenSB = green;
        this.blueSB = blue;

        this.redTV = redT;
        this.greenTV = greenT;
        this.blueTV = blueT;

    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //scans the seekbar and checks the id to see if it matches with specific colors
        //value of colors are found on lines 115-118
        if (seekBar.getId() == R.id.redSB) {
            redTV.setText("red: " + i);
            red = i;
            element1.setColor(Color.argb(alpha,red,green,blue));
        } //set color variables to i so that it won't automatically revert to original value
        if (seekBar.getId() == R.id.greenSB) {
            greenTV.setText("green: " + i);
            green = i;
            element1.setColor(Color.argb(alpha,red,green,blue));
        }
        if (seekBar.getId() == R.id.blueSB) {
            blueTV.setText("blue: " + i);
            blue = i;
            element1.setColor(Color.argb(alpha,red,green,blue));
        }



        //invalidate() method updates canvas
        bob.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //finds x and y coordinates of where user clicks on screen
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();

        //finds the name of object user clicked and sets the text in a textview
        elementTV.setText((bob.getElement(x,y)).getName());

        //finds the int value of CustomElement. type of variables shown through private instances
        element1 = bob.getElement(x,y);
        color = element1.getColor();

        //sets the int value of color so that it will be accessed
        //in onProgressChanged, and then change element color.
        alpha = Color.alpha(color);
        red = Color.red(color);
        green = Color.green(color);
        blue = Color.blue(color);

        redSB.setProgress(red);
        redTV.setText("red: " + red);

        greenSB.setProgress(green);
        greenTV.setText("green: " + green);

        blueSB.setProgress(blue);
        blueTV.setText("blue: " + blue);


        bob.invalidate();
        return true;
    }
}
