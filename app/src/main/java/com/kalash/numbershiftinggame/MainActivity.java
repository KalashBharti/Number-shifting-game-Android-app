package com.kalash.numbershiftinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.kalash.numbershiftinggame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private static int MIN_DISTANCE = 150;
    private float x1, x2, y1, y2;
    private GestureDetector gestureDetector;
    ActivityMainBinding binding;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        game.setBinding(binding);
        setContentView(binding.getRoot());
//        R.layout.activity_main
        game.create();
getSupportActionBar().hide();
        //initialize gesture
        this.gestureDetector =new GestureDetector(MainActivity.this,this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:  //swiping down
                x1 = event.getX();
                y1 = event.getY();
                break;

            case MotionEvent.ACTION_UP:   //swiping up
                x2 = event.getX();
                y2 = event.getY();
                //getting value of horizontal swipe
                float valueX = x2 - x1;

                //getting value of vertical swipe
                float valueY = y2 - y1;

                if (Math.abs(valueX) > MIN_DISTANCE) {
                    if (x2 > x1)  //detect left to right swipe
                    {
                        game.swipeLeft();
                    } else  //detect right to left swipe
                    {
                        game.swipeRight();
                    }
                }
                else if (Math.abs(valueY) > MIN_DISTANCE) {
                    //detect top to bottom
                    if (y2 < y1) {
                       game.swipeDown();
                    }
                    //detect bottom to top
                    else{
                        game.swipeUp();
                    }
                }



        }
        return super.onTouchEvent(event);
    }




    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}