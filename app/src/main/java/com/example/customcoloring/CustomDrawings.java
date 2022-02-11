package com.example.customcoloring;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * class CustomDrawing
 *
 * This is a class to draw objects into canvas
 *
 * @author Milton Nguy
 */

public class CustomDrawings extends SurfaceView {

    /* creates an arraylist of CustomElements. CustomCircle.java and CustomRect.java
    * are both CustomElements, and so I will be able to add the objects to the arraylist
    */
    private ArrayList<CustomElement> drawings;

    CustomRect sky = new CustomRect("sky", Color.BLUE, 0, 0, 1200, 800);
    CustomRect snow = new CustomRect("snow", Color.WHITE, 0, 800, 1200, 1600);
    CustomCircle sun = new CustomCircle("sun", Color.YELLOW, 150, 150, 100);

    CustomRect bamboo = new CustomRect("bamboo", Color.GREEN, 800, 500, 900, 1000);

    CustomRect lollipopS = new CustomRect("lollipop stick", Color.WHITE, 300, 600, 350, 900);
    CustomCircle lollipopCandy = new CustomCircle("lollipop good stuff", Color.CYAN, 325, 600, 100);




    public CustomDrawings(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        //assigns drawings to a new arrayList
        drawings = new ArrayList<>();

        //add all class objects into arraylist
        drawings.add(sky);
        drawings.add(snow);
        drawings.add(sun);
        drawings.add(bamboo);
        drawings.add(lollipopS);
        drawings.add(lollipopCandy);


        setBackgroundColor(Color.WHITE);
    }


    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //for each CustomElement into arraylist, draw into canvas
        for (CustomElement i : drawings) {
            i.drawMe(canvas);
        }


    }

    /*method is used in CustomController.java to access CustomElements from drawings arraylist
    * to gain (x,y) coordinates
    */
    public CustomElement getElement(int x, int y) {
        CustomElement a = null;
        for (CustomElement i : drawings) {
            if (i.containsPoint(x, y))  { //containsPoint method is gained from CustomElement
                a = i;
            }
        }
        return a;
    }




}
