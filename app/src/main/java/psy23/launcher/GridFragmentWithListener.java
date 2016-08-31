package psy23.launcher;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by pkb on 28/08/16.
 */
public class GridFragmentWithListener extends AppsGridFragment implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;

    public GridFragmentWithListener() {
        super();


        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(getActivity().getApplicationContext(),this);

    }


    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        //There isn't a superclass implementation!!!
        return this.mDetector.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        Context context = getActivity().getApplicationContext();
        CharSequence text = " GridFragmentWithListener -- Hello World!";
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
        Context context = getActivity().getApplicationContext();
        CharSequence text = "GridFragmentWithListener -- Button Down";
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
