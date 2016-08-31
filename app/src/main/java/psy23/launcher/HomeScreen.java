package psy23.launcher;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class HomeScreen extends FragmentActivity implements GestureDetector.OnGestureListener {

    public GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);

        View view = findViewById(R.id.apps_grid);




        // Set the gesture detector as the double tap
        // listener.
        //mDetector.setOnDoubleTapListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        Context context = getApplicationContext();
        CharSequence text = " Home-Screen -- Hello World!";
        int duration = Toast.LENGTH_LONG;
        Toast myToast = Toast.makeText(context,text,duration);
        myToast.show();
        return true;

    }

    @Override
    public void onShowPress(MotionEvent e1) {
        //do nothing
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Context context = getApplicationContext();
        CharSequence text = "HomeScreen -- Button Down";
        int duration = Toast.LENGTH_LONG;
        Toast myToast = Toast.makeText(context,text,duration);
        myToast.show();
        return true;

    }

    public void onLongPress(MotionEvent e) {
        //do nothing
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }



}